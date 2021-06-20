package ex45;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class Sol45 {
    static Sol45 app = new Sol45();
    public static void main(String[] args) {
        //get input as string
        String input = app.getInput();
        //replace utilize with use
        String output = app.replace(input, "utilize", "use");
        //output new string as file
        app.outputFile(output);
    }
    String getInput()
    {
        String input = null;
        File inputFile = new File("input/exercise45_input.txt");
        try {
            input = Files.readString(inputFile.toPath());
        }
        catch (Exception e)
        {
            System.out.print("File error.");
            System.exit(-1);
        }
        return input;
    }
    String replace(String input, String oldString, String newString)
    {
        return input.replace(oldString, newString);
    }
    void outputFile(String output)
    {
        File outputFile = new File("output/exercise45_output.txt");
        try {
            FileWriter myWriter = new FileWriter(outputFile);
            myWriter.write(output);
            myWriter.close();
        }
        catch (Exception e)
        {
            System.out.print("Output error.");
            System.exit(-1);
        }
    }
}
