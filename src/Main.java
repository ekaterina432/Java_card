import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Иванов Иван Иванович", LocalDate.of(1990, 5, 15), "ivanov@example.com", "1234567890"));
        clients.add(new Client("Петров Петр Петрович", LocalDate.of(1985, 8, 25), "petrov@example.com", "0987654321"));
        clients.add(new Client("Сидорова Анна Павловна", LocalDate.of(1987, 3, 10), "sidorova@example.com", "2345678901"));
        clients.add(new Client("Козлов Алексей Игоревич", LocalDate.of(1992, 9, 7), "kozlov@example.com", "9876543210"));
        clients.add(new Client("Михайлова Екатерина Сергеевна", LocalDate.of(1983, 11, 18), "mihaylova@example.com", "3456789012"));
        clients.add(new Client("Федоров Степан Петрович", LocalDate.of(1995, 2, 22), "fedorov@example.com", "8901234567"));
        clients.add(new Client("Николаева Ольга Владимировна", LocalDate.of(1986, 7, 30), "nikolaeva@example.com", "4567890123"));
        clients.add(new Client("Григорьев Владимир Дмитриевич", LocalDate.of(1991, 4, 12), "grigoryev@example.com", "9012345678"));
        clients.add(new Client("Белякова Людмила Александровна", LocalDate.of(1988, 10, 5), "belyakova@example.com", "5678901234"));
        clients.add(new Client("Шевченко Ирина Анатольевна", LocalDate.of(1994, 6, 28), "shevchenko@example.com", "2345678901"));

        Random random = new Random();
        List<Bank_card> cards = new ArrayList<>();
        for (Client client : clients) {
            LocalDate randomDate = LocalDate.now().minusDays(random.nextInt(1825)); // 5 лет = 1825 дней
            cards.add(new Bank_card(client, randomDate));
            System.out.println("Создана банковская карта для клиента: " + client.getFIO());
        }
        System.out.println("\n");

        //Проверка рассылки уведомлений
        clients.add(new Client("Прищепа Екатерина Григорьевна", LocalDate.of(2002, 8, 3), "prishchepa@sfedu.ru"));
        cards.add(new Bank_card(clients.get(clients.size() - 1), LocalDate.of(2018, 1, 4)));
        for (Bank_card card: cards){
            card.notification_expiration_date(LocalDate.of(2022, 12, 4));
        }

    }
}
