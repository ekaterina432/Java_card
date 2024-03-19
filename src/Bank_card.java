import java.time.LocalDate;
import java.util.Random;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class Bank_card extends Client{

    /**
     * Клиент банка
     */
    private Client client;

    /**
     * Номер карты
     */
    private String number_card;

    /**
     * Дата выпуска карты
     */
    private LocalDate date_issue;

    /**
     * Дата окончания карты
     */
    private LocalDate date_expiration;

    /**
     * Код CVC
     */
    private  int CVC;


    public Bank_card(Client client,  LocalDate date_issue) {
        this.client = client;
        this.number_card = generateNumberCard();
        this.date_issue = date_issue;
        this.date_expiration = date_issue.plusYears(5);
        Random random = new Random();
        this.CVC = random.nextInt(900) + 100;
    }

    public Bank_card(String FIO, LocalDate birthday, String mail, Client client,  LocalDate date_issue) {
        super(FIO, birthday, mail);
        this.client = client;
        this.number_card = generateNumberCard();
        this.date_issue = date_issue;
        this.date_expiration = date_issue.plusYears(5);
        Random random = new Random();
        this.CVC = random.nextInt(900) + 100;
    }

    public Bank_card(String FIO, LocalDate birthday, String mail, String number_password, Client client, LocalDate date_issue) {
        super(FIO, birthday, mail, number_password);
        this.client = client;
        this.number_card = generateNumberCard();
        this.date_issue = date_issue;
        this.date_expiration = date_issue.plusYears(5);
        Random random = new Random();
        this.CVC = random.nextInt(900) + 100;
    }

    public Client getClient() {
        return client;
    }


    public String getNumber_card() {
        return number_card;
    }

    public void setNumber_card(String number_card) {
        this.number_card = number_card;
    }

    public LocalDate getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(LocalDate date_issue) {
        this.date_issue = date_issue;
    }

    public LocalDate getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(LocalDate date_expiration) {
        this.date_expiration = date_expiration;
    }

    public int getCVC() {
        return CVC;
    }


    @Override
    public String toString() {
        return "Банковская карта{" +
                "клиент: " + client +
                ", номер карты: '" + number_card + '\'' +
                ", дата выпуска: " + date_issue +
                ", дата окончание: " + date_expiration +
                ", CVC: " + CVC +
                '}';
    }


    /**
     * Рандомная генерация номера карты
     * @return
     */
    private String generateNumberCard() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int d = random.nextInt(10);
            sb.append(d);
        }
        return sb.toString();
    }

    /**
     * Отправка уведомления клиенту
     * @param recipientEmail почта получателя
     */
    private void SendMessage(String recipientEmail) {
        String senderEmail = "java.card4@gmail.com";
        String senderPassword = "qgxv xwbq boly fbsy";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Уведомление об окончании срока действия карты.");
            String fullname = client.getFIO();
            message.setText("Здравствуйте, "+ nameClient(fullname)+ "! Срок действия вашей карты заканчивается через месяц.\n" +
                    "Для перевыпуска карты оставьте заявку в личном кабинете или обратитесь  в любое отделение банка.   ");

            Transport.send(message);
            System.out.println("Письмо успешно отправлено: '"+ fullname+"'");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке письма: " + e.getMessage());
        }
    }

    /**
     * Проверка срока действия карты
     * @param now текущий день
     */
    public String notification_expiration_date(LocalDate now) {
        String s;
        if (((date_expiration.getMonthValue() - now.getMonthValue() <= 1) && (now.getMonthValue() != 12) && (now.getDayOfMonth() >= date_expiration.getDayOfMonth()) && (now.getYear() == date_expiration.getYear()))
                || ((now.getMonthValue() == 12) && (date_expiration.getMonthValue() == 1) && (date_expiration.getYear() - now.getYear() == 1) &&(now.getDayOfMonth() >= date_expiration.getDayOfMonth()))) {
            s = "У клиента '" + client.getFIO()+"' заканчивается срок действия карты." ;
            SendMessage(client.getMail());
        }
        else if (now.isBefore(date_issue) || now.isAfter(date_expiration)) {
            s = "У клиента '"+ client.getFIO()+"' карта не активна.";
        }
        else {
            s = "У клиента '" + client.getFIO() + "' срок действия карты больше месяца.";

        }
        return s;
    }








}
