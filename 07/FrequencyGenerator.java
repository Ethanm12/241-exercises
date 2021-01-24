package week07;

import java.util.*;
import java.io.*;


public class FrequencyGenerator implements WordGenerator {

    /**Datafeild for random.*/
    private Random random;

    /**
     * This constructor sets the data field random.
     *
     * @param r an instance of the Random class
     */
    public FrequencyGenerator(Random r) {
        random = r;
    }

    /**
     * This method calls the chooseIndex method to build
     * a word of length n.
     *
     * @param n the length of the next word
     * @return the completed next word
     */
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++){
            result.append((char)('a' + chooseIndex()));
        }
        return result.toString();
    }

    /**
     * This method reads a file of letter frequencies and uses these
     * weights to determine the next letter char.
     *
     * @return the index of the next character for nextWord
     */
    public int chooseIndex(){

        int index = 0;
        String letterFrequencies = "letter-frequencies.txt";
        double[] weights = new double["abcdefghijklmnopqrstuvwxyz".length()];
        double r = random.nextDouble();
        try{
            Scanner file1 = new Scanner(new File(letterFrequencies));

            while(file1.hasNext()){
                weights[index] = Double.parseDouble(file1.nextLine());
                index++;
            }
            
        }catch(FileNotFoundException e){}

        index = 0;
        while(r > weights[index]){
            r = r - weights[index];
            index += 1;
        }
        return index;
    }        
}//end class
