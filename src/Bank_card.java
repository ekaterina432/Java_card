import java.time.LocalDate;
import java.util.Random;

public class Bank_card extends Client{
    private Client client;
    private String number_card;
    private LocalDate date_issue;
    private LocalDate date_expiration;
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

    private String generateNumberCard() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int d = random.nextInt(10);
            sb.append(d);
        }
        return sb.toString();
    }

//
//    private boolean isValidCVC(String CVC) {
//        String regex = "^\\d{3}$";
//
//        return CVC.matches(regex);
//    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public void setCVC(int CVC) {
        this.CVC = CVC;
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
/*
    public String notification_expiration_date(LocalDate now) {
        if ((date_issue.getMonthValue() - now.getMonthValue() <= 1 && now.getMonthValue() != 12) || (now.getMonthValue() == 12 && date_expiration.getMonthValue() == 1)) {
            //
        }
    }
*/




}
