import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Visitor {
    private String full_name = "";
    private String date_of_visit;
    private String time_of_visit;
    private String comments;
    private String name_of_the_person_who_assisted_the_visitor;
    private String fileName = "";
    private int age;
    static String finaleData = "";


    Logger logger = LogManager.getLogger(Visitor.class);
    //assigning values...
    Visitor(String name, String date, String time, String comment, String assistance, int ageOf){
        full_name = name;
        fileName = "visitor_"+ full_name.replaceAll(" ", "_").toLowerCase() + ".txt";
        date_of_visit = date;
        time_of_visit = time;
        comments = comment;
        name_of_the_person_who_assisted_the_visitor = assistance;
        age = ageOf;
    }
    //default constructor
    public Visitor() {
    }


    //
    //creating a file and saving visitors data to it.
    boolean save() throws IOException {
        File visitorData = new File(fileName);
        if(fileName.equals("visitor_.txt")){
            throw new IOException("File needs a name");
        }

        if (visitorData.createNewFile()) {
            finaleData += full_name + " Age: " + age + " | Date: " + date_of_visit +
                    " | Time: " + time_of_visit + " | comment: " + comments + " | Assisted by : " +
                    name_of_the_person_who_assisted_the_visitor;
            logger.info("\nFile created: " + visitorData.getName());
        }
        else {
            finaleData += "\n Date: "+ date_of_visit +
                    " | Time: "+ time_of_visit +" | comment: "+ comments + " | Assisted by : "+
                    name_of_the_person_who_assisted_the_visitor;
            logger.info("\nFile already exist and new information was added");
        }
        Files.write(Paths.get(fileName), finaleData.getBytes(), StandardOpenOption.APPEND);
        return visitorData.exists();
    }

    //retrieving saved data
    boolean load(String full_name) throws IOException {
        String retrieve = full_name.replaceAll(" ", "_").toLowerCase();
        BufferedReader file = new BufferedReader(new FileReader("visitor_"+ retrieve +".txt"));
        String line;
        while ((line = file.readLine()) !=null){
            System.out.println(line);
        }
        logger.info("\nRead was successful.");
    return true;
    }

}
