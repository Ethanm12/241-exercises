package week02;

import java.util.Random;

public class Coins{

    /**Data field for the HEADS face of a coin.*/
    public static final boolean HEADS = true;
    /**Data field for the TAILS face of a coin.*/
    public static final boolean TAILS = false;
    /**Data field holds the boolean values of the
       HEADS and TAILS data fields.*/
    private boolean[] coins;

    /**
     * Creates new instances of the Coin class
     * sending different types of data to the multiple
     * constructors.
     *
     * @param args takes arguments from the command line
     */
    public static void main(String [] args){
    }//end main

    /**Default constructor for Coins class.*/
    public Coins(){}
    
    /**
     *  Constructor creates an instance of Coins class
     *  taking a boolean array a parameter.
     * <p>
     * Constructor  assigns the value of the boolean array
     * to the objects coins data field.
     *
     * @param coins array of coin values
    */
    public Coins(boolean[] coins){
        this.coins = coins;
    }

    /**
     * Constructor creates a new instance of the Coins class
     * taking a String as a parameter.
     * <p>
     * Constructor loops over the input String assigning relavent
     * values to the Coins data field.
     *
     *@param c a string input from the user containing H's and T's
     */
    public Coins(String c){
        int position = 0;
        boolean [] b = new boolean[c.length()];
        
        while(position < c.length()){
            if(c.charAt(position) == 'H'){
                b[position] = HEADS;
                position++;
            }else{
                b[position] = TAILS;
                position++;
            } 
        }
        this.coins = b;
    }
    
    /**
     * Constuctor creates a new instance of the Coins class
     * taking a int as a parameter.
     * <p>
     * Uses a random number generator and a loop to add random coin flips
     * to an array that is the length of the int parameter.
     *
     *@param length faces of the coins
     */
    public Coins(int length){
        Random randomNum = new Random();
        boolean [] b = new boolean[length];
        
        for(int i = 0; i<length; i++){
            int coinFace = randomNum.nextInt(2);
            if(coinFace == 0){
                b[i] = HEADS;
            }else{
                b[i] = TAILS;
            }
        }
        this.coins = b;
    }

    /**
     * Counts the number of times the face of a coin(Heads or tails)
     * is followed by a different face to itself.
     * <p> 
     * Loops through the coins data field and adds an H and T to the
     * sides variable for each occurance of HEADS and TAILS respectively.
     * <p>
     * Loops through the sides variable and counts each time a different
     * character to the previous appears and then returns the runs.
     *
     * @return the number of runs
     */
    public int countRuns(){
        int position = 0;
        int runs = 0;
        String sides = "";
        char previous = ' ';
        
        for(boolean toss: coins){
            if(toss){
                sides+="H";
            }else{
                sides+="T";
            }
        }
        while(position < sides.length()){
            if (sides.charAt(position)==previous){
                position++;
            }else{
                previous = sides.charAt(position);
                runs++;
                position++;
                
            }
        }
        return  runs;
    }

    /**
     * Counts the number of times the HEAD face appears in
     * the objects coins data field.
     *
     * @return the number of head coin sides counted
     */
    public int countHeads(){

        int heads = 0;
        for(boolean toss :coins){
            if(toss){
                heads++;
            }
        }
        return heads;
    }

    /**
     * The string representation of the HEADS and TAILS values
     * of the object's coins data field.
     *
     *@return a list of the sides of the coin
     */
    public String toString(){
        String sides = "";
        for(boolean toss: coins){
            if(toss){
                sides+="H";
            }else{
                sides+="T";
            }
        }
        return(sides);
    }
}//end class
