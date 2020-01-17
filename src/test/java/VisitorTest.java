import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

    //Saving Visitor info
    @Test
    void save() throws IOException {
        DateTimeFormatter dtfMonth = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern( "hh:mm");
        LocalDateTime time = LocalDateTime.now();
        Visitor saveVisitor = new Visitor("Thabile Ngoma",dtfMonth.format(date),
                dtfTime.format(time),"No comment",
                "Musa Mgijima",42);
        assertTrue(saveVisitor.save(),"File should be created successful and data be saved");
    }
    //Creating a file with an empty name
    @Test
    void saveEmpty(){
        Visitor testPathExist = new Visitor();
        assertThrows(IOException.class, testPathExist::save,"The file cannot be created with an empty name");
    }
    //Loading data from old file
    @Test
    void load() throws IOException {
        Visitor fetch = new Visitor();
        assertTrue(fetch.load("Alice Cooper"),"Before you test make sure visitor_alice_cooper.txt exit in the root directory");
    }
    //Reading non-existing file
    @Test
    void loadFailing(){
        Visitor testFile = new Visitor();
        assertThrows(FileNotFoundException.class, () -> testFile.load("Musa Mgijiam"), "Should throw since file not found");
    }
}