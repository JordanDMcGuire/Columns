import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Columns {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String filePath;
    static boolean fileExists = false;
    static ArrayList<String> inputFile;
    static String errorMessage;

    public static void main(String[] args) throws IOException {

        getFile();

        inputFile = (ArrayList<String>) Files
                .readAllLines(Path.of(filePath));

        System.out.println(inputFile);

    }

    static void getFile() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the path of the file you would like to format: ");

        do {
            try {
                filePath = input.readLine();

                if (!Files.exists(Path.of(filePath))) {
                    throw new InputMismatchException();
                }
                else {
                    fileExists = true;
                }
            } catch (InputMismatchException e) {
                errorMessage = "File not found. Please enter a valid file path.";
                System.out.println(errorMessage);
            }

        } while (!fileExists);
    }

}
