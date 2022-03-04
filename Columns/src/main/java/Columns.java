import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Columns {

    static BufferedReader input;
    static String filePath;
    static boolean fileExists = false;
    static ArrayList<String> inputFile;
    static String errorMessage;
    static int counter = 0;

    public static void main(String[] args) throws IOException {

        getFile();

        inputFile = (ArrayList<String>) Files
                .readAllLines(Path.of(filePath));

        int row = 0;
        if(inputFile.size()< 6){
            row = 3;
        }
        else if( inputFile.size() < 11){
            row = 4;
        }
        else{
            row = 9;
        }


        ArrayList<List<String>> transformedList = new ArrayList<>();

        for (int j = 0; j < inputFile.size(); j += row) {
            if (j < inputFile.size()) {
                transformedList.add(inputFile.subList(j, j + row));
            } else if (j > inputFile.size()) {
                transformedList.add(inputFile.subList(j, inputFile.size()));
            }
        }
        System.out.println(transformedList);

        do {
            transformedList.stream()
                    .forEach(l -> {
                        if (l.size() >= counter) {
                            System.out.printf("%-30.30s",l.get(counter));
                        }
                    });
            System.out.println();
            counter++;
        } while(counter < transformedList.get(0).size());
    }


    static void getFile() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the path of the file you would like to format: ");

        do {
            try {
                filePath = input.readLine();

                if (!Files.exists(Path.of(filePath)) || filePath.equals("")) {
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
