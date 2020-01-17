import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Visitor {
    private String full_name;
    private String date_of_visit;
    private String time_of_visit;
    private String comments;
    private String name_of_the_person_who_assisted_the_visitor;
    private String fileName = "Empty";
    private int age;
    static String finaleData = "";

    Logger logger = LogManager.getLogger(Visitor.class);
    //assigning values...
    Visitor(String name, String date, String time, String comment, String assistance, int ageOf){
        full_name = name;
        fileName = full_name.replaceAll(" ", "_").toLowerCase();
        date_of_visit = date;
        time_of_visit = time;
        comments = comment;
        name_of_the_person_who_assisted_the_visitor = assistance;
        age = ageOf;
    }
    //default constructor
    public Visitor() {
    }

    //creating a file and saving visitor data to it.
    void save() {

        try {
            File visitorData = new File("visitor_"+fileName+".txt");

            if (visitorData.createNewFile() && !fileName.equals("Empty")) {
                finaleData += full_name + " Age: "+age + " | Date: "+ date_of_visit +
                        " | Time: "+ time_of_visit +" | comment: "+ comments + " | Assisted by : "+
                        name_of_the_person_who_assisted_the_visitor;
                logger.info("\nFile created: "+ visitorData.getName());

            }
            else if (fileName.equals("Empty")){
                finaleData = "No data";
            }
            else {
                finaleData += "\n Date: "+ date_of_visit +
                        " | Time: "+ time_of_visit +" | comment: "+ comments + " | Assisted by : "+
                        name_of_the_person_who_assisted_the_visitor;
                logger.info("\nFile already exist and new information was added");
            }
            Files.write(Paths.get("visitor_"+fileName+".txt"), finaleData.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            logger.error("An error occurred"+ e);
        }
    }
    //retrieving saved data
    void load(String full_name) throws FileNotFoundException {
        String retrieve = full_name.replaceAll(" ", "_").toLowerCase();
        try {
            BufferedReader file = new BufferedReader(new FileReader("visitor_"+ retrieve +".txt"));
            String line;
            while ((line = file.readLine()) !=null){
                System.out.println(line);
            }
            logger.info("\nRead was successful.");
        } catch (IOException err){
            logger.error("\n"+err);
        }

    }
}
