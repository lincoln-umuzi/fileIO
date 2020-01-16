import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class Visitor {
    private String full_name;
    private static String fileName = "NoNameYet";
    private int age;
    private String date_of_visit;
    private String time_of_visit;
    private String comments;
    private String name_of_the_person_who_assisted_the_visitor;

    public void setFull_name(String full_name) {
        this.full_name = full_name;
        fileName = full_name.replaceAll(" ", "_").toLowerCase();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate_of_visit(String date_of_visit) {
        this.date_of_visit = date_of_visit;
    }

    public void setTime_of_visit(String time_of_visit) {
        this.time_of_visit = time_of_visit;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setName_of_the_person_who_assisted_the_visitor(String name_of_the_person_who_assisted_the_visitor) {
        this.name_of_the_person_who_assisted_the_visitor = name_of_the_person_who_assisted_the_visitor;
    }

    static void save(){
        try {
            File visitorData = new File("visitor_"+fileName+".txt");
            if (visitorData.createNewFile()) {
                System.out.println("File created: " + visitorData.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
