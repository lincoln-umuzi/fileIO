import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    String name;


    public static void main(String[] args) throws IOException {
       Main retr = new Main();

       retr.retrieveData();
       Visitor.save();
//        System.out.println(time);





    }
    void retrieveData(){
        Visitor setData = new Visitor();
        Scanner userData = new Scanner(System.in);

        System.out.println("Enter your full name");
        name = userData.nextLine();
        setData.setFull_name(name);

        System.out.println("Any comment");
        setData.setComments(userData.nextLine());

        System.out.println("Name of the helper");
        setData.setName_of_the_person_who_assisted_the_visitor(userData.nextLine());

        System.out.println("Enter age");
        setData.setAge(userData.nextInt());


//


        DateTimeFormatter dtfMonth = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date = LocalDateTime.now();
        setData.setDate_of_visit(dtfMonth.format(date));
//
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern( "hh:mm");
        LocalDateTime time = LocalDateTime.now();
        setData.setTime_of_visit(dtfTime.format(time));
    }
}
