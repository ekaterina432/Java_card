import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.UUID;


public class Client {

    private String id;

    private String FIO;
    private LocalDate birthday;
    private  String mail;
    private String number_password;

    public Client(){
        this.id = null;
        this.FIO = "Неизвестно";
        this.birthday = LocalDate.ofEpochDay(0);
    }

    public Client(String FIO, LocalDate birthday, String mail) {
        this.id = UUID.randomUUID().toString();
        this.birthday = birthday;
        if (isValidFIO(FIO)) {
            this.FIO = FIO;
        } else {
            throw new IllegalArgumentException("Некорректное ФИО");
        }
        if (isValidMail(mail)) {
            this.mail = mail;
        } else {
            throw new IllegalArgumentException("Некорректный адрес электронной почты");
        }
    }

    public Client(String FIO, LocalDate birthday, String mail, String number_password) {
        this.id = UUID.randomUUID().toString();
        if (isValidFIO(FIO)) {
            this.FIO = FIO;
        } else {
            throw new IllegalArgumentException("Некорректное ФИО");
        }
        this.birthday = birthday;
        if (isValidMail(mail)) {
            this.mail = mail;
        } else {
            throw new IllegalArgumentException("Некорректный адрес электронной почты");
        }
        if (isValidNumderPassword(number_password)) {
            this.number_password = number_password;
        } else {
            throw new IllegalArgumentException("Некорректные паспортный номер");
        }
    }

    private boolean isValidMail(String email) {
        String emailRegex = "^\s*[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z]+\\.)+(com|ru)\s*$";
        return email.matches(emailRegex);
    }
    private boolean isValidFIO(String FIO) {
        String regex = "^\s*[А-Яа-яЁё]+(?:\\s[А-Яа-яЁё]+){2}\s*$";

        return FIO.matches(regex);
    }

    private boolean isValidNumderPassword(String number_password) {
        String regex = "^\\d{10}$";

        return number_password.matches(regex);
    }
    public String getFIO() {
        return FIO;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getMail() { return mail;}

    public String getNumber_password() {
        return number_password;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumber_password(long String) {
        this.number_password = number_password;
    }


    public String nameClient(String fullName){
        String[] parts = fullName.split(" ");
        return (parts[1]);
    }

    @Override
    public String toString() {
        return "Клиент{" +
                "id: '" + id + '\'' +
                ", ФИО:'" + FIO + '\'' +
                ", день рождения: " + birthday +
                ", mail: '" + mail + '\'' +
                ", номер паспорта: " + number_password +
                '}';
    }



}
