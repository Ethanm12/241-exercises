package week07;

import java.util.*;
import java.io.*;

public class DigramGenerator implements WordGenerator {
    /**Random datafield.*/
    private Random random;

    /**
     * Constructor sets the random datafield.
     *
     * @param r is an instance of the random class
     */
    public DigramGenerator(Random r) {
        random = r;
    }

    /**
     * Method reads from a file containing letters that commonly
     * follow each letter of the alphabet.
     *
     * It then uses a random number generator and a call to first
     * letter to determine the next sequence of characters in a word.
     *
     * @param n the length of the next word
     * @return the completed word of length n
     */
    public String nextWord(int n) {
        
        int i = 0;
        String[] letters = new String["abcsefghijklmnopqrstuvwxyz".length()];
        String continuations = "continuations.txt";
        StringBuilder word = new StringBuilder();
        try{
            Scanner file2 = new Scanner(new File(continuations));
            while(file2.hasNextLine()){
                letters[i] = file2.nextLine();
                i++;
            }
        }catch(FileNotFoundException e){}

        char firstLetter = firstLetter();
        word.append(firstLetter);
        i = 1;
        while(i<n){
            int index = firstLetter - 'a';
            int nextInt = letters[index].length();
            char nextLetter = letters[index].charAt(random.nextInt(nextInt));
            word.append(nextLetter);
            i++;
            firstLetter = nextLetter;
        } 
        return word.toString();
    }

    /**
     * Method reads from a file the most common letter frequencies.
     * The method then uses a random number generator to determine
     * the first character of a word.
     *
     * @return the first character of a new word
     */
    public char firstLetter(){
        StringBuilder letters = new StringBuilder();
        int index = 0;
        String firstLetters = "first-letters.txt";

        try{
            Scanner file1 = new Scanner(new File(firstLetters));
            while(file1.hasNext()){
                letters.append(file1.nextLine());
            }   
        }catch(FileNotFoundException e){}
        
        return letters.charAt(random.nextInt(letters.length()));
    }
}//end class
