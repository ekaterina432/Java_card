import java.time.LocalDate;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("Прищепа Екатерина Григорьевна", LocalDate.of(2002, 3, 8)
                , "jhdjhjhbd@gmail.com");
        System.out.println(c1.toString());
        Client c2 = new Client("Суворова Ульяна Владимировна", LocalDate.of(2005, 7, 12),
                "hfdhbsjnf@gmail.com", "3456789036");
        Bank_card b1 = new Bank_card(c2,  LocalDate.of(2023, 3, 12) );
        System.out.println(b1.toString());

        }

    }
