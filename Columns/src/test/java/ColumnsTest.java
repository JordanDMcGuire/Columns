import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColumnsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() throws IOException {
        System.in.close();
    }

    @Test
    void testIt1() throws IOException {

        InputStream backup1 = System.in;

        System.setIn(new ByteArrayInputStream("src/main/resources/Input2.txt"
                        .getBytes(StandardCharsets.UTF_8)));
        Columns.main(new String[] {"arg1", "arg2", "arg3"});
        System.setIn(backup1);

        assertEquals("[One, Two, Three, Four, Five, Six, " +
                "Seven, Eight, Nine, Ten, Eleven, Twelve, Thirteen, " +
                "Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen, " +
                "Twenty, Twenty one, Twenty two, Twenty three, Twenty four, Twenty five]",
                Columns.inputFile.toString(), "The program failed to load the file.");

    }

    @Test
    void testIt2() throws IOException {

        InputStream backup2 = System.in;

        System.setIn(new ByteArrayInputStream("src/main/resources/Inpu.txt"
                .getBytes(StandardCharsets.UTF_8)));

        Columns.fileExists = true;

        Columns.getFile();
        System.setIn(backup2);

        assertEquals("File not found. Please enter a valid file path.",
                Columns.errorMessage, "Incorrect Input is not being handled correctly.");

    }

    @Test
    void testIt3() throws IOException {

        InputStream backup1 = System.in;

        System.setIn(new ByteArrayInputStream("src/main/resources/Input3.txt"
                .getBytes(StandardCharsets.UTF_8)));
        Columns.main(new String[] {"arg1", "arg2", "arg3"});
        System.setIn(backup1);

        assertEquals("[One, Two, Three, Four, Five]",
                Columns.inputFile.toString(), "The program failed to load the file.");

    }

    @Test
    void testIt4() throws IOException {

        InputStream backup1 = System.in;

        System.setIn(new ByteArrayInputStream("src/main/resources/Input4.txt"
                .getBytes(StandardCharsets.UTF_8)));
        Columns.main(new String[] {"arg1", "arg2", "arg3"});
        System.setIn(backup1);

        assertEquals("[One, Two, Three, Four, Five, Six, " +
                        "Seven, Eight, Nine, Ten]",
                Columns.inputFile.toString(), "The program failed to load the file.");

    }

}