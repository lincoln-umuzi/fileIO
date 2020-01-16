import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class Visitor {
    private static String full_name;
    private static String fileName = "NoNameYet";
    private static int age;
    private static String date_of_visit;
    private static String time_of_visit;
    private static String comments;
    private static String name_of_the_person_who_assisted_the_visitor;
    static String finaleData = "";

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

    static void save() throws IOException {
        try {
            File visitorData = new File("visitor_"+fileName+".txt");

            if (visitorData.createNewFile()) {
//                BufferedWriter saver = new BufferedWriter(new FileWriter("visitor_"+fileName+".txt"));
//                saver.write(full_name);
               finaleData += full_name + " Age: "+age + " Date: "+ date_of_visit + " Time: "+ time_of_visit +" comment: "+ comments + " Assisted by : "+ name_of_the_person_who_assisted_the_visitor;


                System.out.println("File created: " + visitorData.getName());
                Logger logger = LogManager.getLogger(Visitor.class);
                logger.info("results in "+ "visitor_"+fileName+".txt" );
            } else {
                finaleData += full_name + " Age: "+age + " Date: "+ date_of_visit + " Time: "+ time_of_visit +" comment: "+ comments + " Assisted by : "+ name_of_the_person_who_assisted_the_visitor;
                System.out.println("File already exists.");
            }
            Files.write(Paths.get("visitor_"+fileName+".txt"), finaleData.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
