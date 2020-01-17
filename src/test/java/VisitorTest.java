import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {
    Visitor alice = new Visitor();
    @Test
    void save() throws NullPointerException{
        Visitor save = new Visitor();
        save.save();

    }

    @Test
    void load() throws IOException {



    }



    @Test
    void argumentsRethrowsOriginalExceptionFromProviderAsUncheckedException() {
        ArgumentsProvider failingProvider = (context) -> {
            throw new FileNotFoundException("a message");
        };

        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> alice.save());
        assertEquals("a message", exception.getMessage());
    }



}