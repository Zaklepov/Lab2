;import org.junit.jupiter.api.Test;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.*;

class XorTest {

    @Test
    void encryption() throws IOException {
        String[] arguments = new String[5];
        arguments[0] = "-c";
        arguments[1] = "1";
        arguments[2] = "input/Test1In";
        arguments[3] = "-o";
        arguments[4] = "outp";
        XorLauncher.main(arguments);
        assertEquals(-1, Files.mismatch(Path.of(arguments[4]), Path.of("output/Test1Out")));
        File file = new File(Path.of(arguments[4]).toUri());
        file.delete();
    }

    @Test
    void encryption2() throws IOException {
        String[] arguments = new String[5];
        arguments[0] = "-d";
        arguments[1] = "1";
        arguments[2] = "input/Test2In";
        arguments[3] = "-o";
        arguments[4] = "outp";
        XorLauncher.main(arguments);
        assertEquals(-1, Files.mismatch(Path.of(arguments[4]), Path.of("output/Test2Out")));
        File file = new File(Path.of(arguments[4]).toUri());
        file.delete();
    }


    @Test
    void Xor() {
        Xor Test = new Xor();
        assertEquals("Boffe*]exfn", Test.xor("Hello World", "a"));
        assertEquals("Hello World", Test.xor("Boffe*]exfn", "a"));
        assertEquals("", Test.xor("", "a"));
    }
}