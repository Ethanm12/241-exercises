package week01;
import java.util.Scanner;

public class Counter{
  
    /**
     * Reads input from the user using Scanner and
     * uses a loop to count and then print the number of
     * lines and words.
     *
     * @param args takes arguments from the command line.
    */
    public static void main(String [] args){
    
        Scanner input1 = new Scanner(System.in);
      
        int lines = 0; //counter for number of lines
        int words = 0; //counter for number of words

        while(input1.hasNextLine()){
            lines++;
            Scanner input2 = new Scanner(input1.nextLine());
           
            while(input2.hasNext()){
                words++;
                input2.next();
            }
        }
        System.out.println("lines: "+lines);
        System.out.println("words: "+words);
    
    }//end main
  
}//end class
