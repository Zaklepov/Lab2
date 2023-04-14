import org.junit.jupiter.api.Test;

import javax.management.InvalidApplicationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

class XorTest {

    @Test
    void encryption() throws IOException {
        XorLauncher test = new XorLauncher();
        String[] arguments = new String[5];
        arguments[0] = "-c";
        arguments[1] = "1";
        arguments[2] = "src/input/Test1";
        arguments[3] = "-o";
        arguments[4] = "src/output/out";
        test.main(arguments);
        assertEquals(-1, Files.mismatch(Path.of(arguments[4]), Path.of("src/output/Test1")));
        File file = new File(Path.of(arguments[4]).toUri());
        file.delete();
    }
    @Test
    void encryption2() throws IOException {
        XorLauncher test = new XorLauncher();
        String[] arguments = new String[5];
        arguments[0] = "-d";
        arguments[1] = "1";
        arguments[2] = "src/input/Test2";
        arguments[3] = "-o";
        arguments[4] = "src/output/out";
        test.main(arguments);
        assertEquals(-1, Files.mismatch(Path.of(arguments[4]), Path.of("src/output/Test2")));
        File file = new File(Path.of(arguments[4]).toUri());
        file.delete();
    }



    @Test
    void Xor() {
        Xor test = new Xor("a");
        assertEquals("Boffe*]exfn", test.xor("Hello World", "a"));
        assertEquals("Hello World", test.xor("Boffe*]exfn", "a"));
        assertEquals("", test.xor("", "a"));
    }
}