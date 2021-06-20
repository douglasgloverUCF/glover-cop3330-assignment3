package ex46;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.*;

public class Sol46 {
    static Sol46 app = new Sol46();
    static class WordData {
        String word;
        int wordCount;
    }
    public static void main(String[] args) {
        //get input as string
        String input = app.getInput();
        //count words in string
        ArrayList<WordData> wordList = app.countWords(input);
        //organize as histogram
        String output = app.getHistogram(wordList);
        //output histogram
        app.output(output);
    }
    String getInput()
    {
        String input = null;
        File inputFile = new File("input/exercise46_input.txt");
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
    ArrayList<WordData> countWords(String input)
    {
        ArrayList<WordData> wordList = new ArrayList<>();
        Scanner in = new Scanner(input);
        WordData newWord;
        while(in.hasNext()) {
            newWord = new WordData();
            newWord.word = in.next();
            newWord.wordCount = 0;
            while (input.contains(newWord.word)) {
                input = input.replaceFirst(newWord.word, "");
                newWord.wordCount++;
            }
            wordList.add(newWord);
            in = new Scanner(input);
        }
        in.close();
        return wordList;
    }
    String getHistogram(ArrayList<WordData> wordList)
    {
        //sort array first
        Comparator<WordData> comparator = (o1, o2) -> o2.wordCount -  o1.wordCount;
        wordList.sort(comparator);
        String histogram = "";
        for(WordData wordElement : wordList) {
            String message = String.format("%-10s ", wordElement.word + ":");
            while (wordElement.wordCount > 0) {
                message = message.concat("*");
                wordElement.wordCount--;
            }
            histogram = histogram.concat(message + "\n");
        }
        return histogram;
    }
    void output(String message)
    {
        System.out.print(message);
    }
}
