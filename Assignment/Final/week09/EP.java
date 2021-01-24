package week09;

import java.util.*;
import java.io.*;


public class EP implements ExamPile{

    /**The internal representation of the pile of exams.*/
    private LinkedList<Integer> exams;
    /**The depth at which the pile is searched per step.*/
    private int depth = 1;


    /**
     * The starting point of the program. Main method contains a loops that
     * while there is input, reads one line at a time of integer values which
     * it adds to a List, and then loads it into an instance of <code>EP</code>
     * where sorting steps are perfored.
     *
     * @param args takes input from the command line to set <code>depth</code>
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            List<Integer> list1 = new ArrayList<Integer>();
            Scanner s = new Scanner(scanner.nextLine());
            while(s.hasNext()){
                list1.add(s.nextInt());
            }
            EP test1 = new EP();
            if(args.length >  0){
                test1.setDepth(Integer.parseInt(args[0]));
            }else{
                test1.setDepth(1);
            }
            test1.load(list1);
            System.out.println(test1.sortingSteps());
        }
    }

    /**
     * A mutator method for setting the depth.
     *
     * @param depth input to be set
     */
    public void setDepth(int depth){
        this.depth = depth;
    }


    /**
     * Initialises the pile of exams to consist of
     * the contents of the list <code>items</code>.
     *
     * @param items a list of type Integer containg  of exams.
     */
    @Override
    public void load(List<Integer> items){
        exams = new LinkedList<Integer>();
        exams.addAll(items);
    }

    /**
     * Checks whether the exams data field is empty and returns its size.
     * <p>
     * Uses the <code>java.util.Collection</code> method <code>isEmpty()</code>
     * on the exams data field which returns a boolean true or false.
     * <p>
     * Uses the <code>java.util.Collection</code> method <code>size()</code>
     * on the exams data field which returns the number of elements in the
     * collection.
     *
     * @return the size of the exam pile
     */
    public int size(){
        if(exams.isEmpty()){
            return 0;
        }else{
            return exams.size();
        }
    }

    /**
     * Uses the <code>java.util.LinkedLis</code>t class method
     * <code>getFirst()</code> to return the first element in
     * the exam pile.
     *
     * @return the first element in the exam pile
     */
    @Override
    public int peek(){
        try{
            return exams.getFirst();
        }catch(EmptyPileException e){
            throw new EmptyPileException("The exam pile is empty");
        }
    }

    /**
     * Looks throught the pile to a specified <code>depth</code>, if
     * the <code>value</code> is found within this depth it is returned
     * else -1 is returned.
     *
     * @param depth specifies how deep to look within the pile.
     * @param value specifies which value to look for.
     * @return the given value paramerter if found in the pile.
     */
    @Override
    public int mark(int depth, int value){
        try{
            int currentNode = peek();
            for(int index = 1; index<=depth; index++){
                if(currentNode == value){
                    exams.remove(index-1);
                    return value;
                }else{
                    currentNode = exams.get(index);
                }
            }
            return -1;
        }catch(EmptyPileException e){
            throw new EmptyPileException("The exam pile is empty");
        }
    }

    /**
     * Constructs a string if 'M' and 'S' characters that represent
     * steps taken to mark a pile of exams.
     * <p>
     * The method uses a loop iterate over the  exam pile by calling the
     * method <code>mark()</code> and searching for a <code>currExam</code>.
     * <p>
     * If the value is found, an 'M' is added to the string, else a 'D' is
     * added and the exam goes to the bottom of the pile by calling
     * <code>delay()</code> method.
     *
     * @return the steps taken, represented by M's and D's to mark the pile.
     */
    public String sortingSteps(){
        StringBuilder marks = new StringBuilder();
        int currExam = 0;

        while(size() != 0){
            if(mark(depth,currExam)== currExam){
                marks.append("M");
                currExam++;
            }else{
                delay(depth);
                marks.append("D");
            }
        }
        return marks.toString();
    }

    /**
     * Moves a number of exams defined by <code>count</code> from the
     * top of the pile to the bottom.
     *
     * @param count the number of exams to go to the bottom
     */
    @Override
    public void delay(int count){
        try{
            int examToBottom=1;
            while(examToBottom <= count){
                int temp = exams.getFirst();
                exams.add(temp);
                exams.remove(exams.getFirst());
                examToBottom++;
            }
        }catch(EmptyPileException e){
            throw new EmptyPileException("The exam pile is empty");
        }
 }

    /**
     * Inner class that extends <code>NoSuchElementException</code>
     * and is used called if speicifc method call is used on en
     * empty exam pile.
     */
    @SuppressWarnings("serial")
    private class EmptyPileException extends NoSuchElementException{
        /**
         * Takes a string <code>message</code> and uses it as input
         * to its parent class to be printed to screen.
         *
         * @param message from the thrwon instance to be output
         */
        public EmptyPileException(String message){
            super(message);
        }
    }
}//end class
