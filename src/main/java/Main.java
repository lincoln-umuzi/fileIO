import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws IOException {
        DateTimeFormatter dtfMonth = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern( "hh:mm");
        LocalDateTime time = LocalDateTime.now();
        Visitor data = new Visitor("Alice Cooper", dtfMonth.format(date),
                dtfTime.format(time), "No comment",
                "Musa Mgijima", 42);
        Visitor alice = new Visitor();

        data.save();
        alice.load("Alice Cooper");
    }

}
