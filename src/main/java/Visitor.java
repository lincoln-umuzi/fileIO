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
    private String fileName;
    private int age;
    static String finaleData = "";

    Logger logger = LogManager.getLogger(Visitor.class);

    Visitor(String name, String date, String time, String comment, String assistance, int ageOf){
        full_name = name;
        fileName = full_name.replaceAll(" ", "_").toLowerCase();
        date_of_visit = date;
        time_of_visit = time;
        comments = comment;
        name_of_the_person_who_assisted_the_visitor = assistance;
        age = ageOf;
    }

    public Visitor() {
    }

    void save() {

        try {
            File visitorData = new File("visitor_"+fileName+".txt");

            if (visitorData.createNewFile()) {
                finaleData += full_name + " Age: "+age + " Date: "+ date_of_visit +
                        " Time: "+ time_of_visit +" comment: "+ comments + " Assisted by : "+
                        name_of_the_person_who_assisted_the_visitor;
                logger.info("\nFile created: "+ visitorData.getName());
            } else {
                finaleData += "\n Date: "+ date_of_visit +
                        " Time: "+ time_of_visit +" comment: "+ comments + " Assisted by : "+
                        name_of_the_person_who_assisted_the_visitor;
                logger.info("\nFile already exist and new information was added");
            }
            Files.write(Paths.get("visitor_"+fileName+".txt"), finaleData.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            logger.error("An error occurred"+ e);
        }
    }

    void load(String full_name) throws IOException {
        String retrieve = full_name.replaceAll(" ", "_").toLowerCase();
        try {
            BufferedReader file = new BufferedReader(new FileReader("visitor_"+ retrieve +".txt"));
            System.out.println(file);
            String line;
            while ((line = file.readLine()) !=null){
                System.out.println(line);
            }
            logger.info("\nRead was successful.");
        } catch (FileNotFoundException err){
            logger.error("\n"+err);
        }

    }
}
