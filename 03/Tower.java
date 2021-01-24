package week03;


public class Tower{

    /** The top block. */
    private char top;
    
    /** The rest of the tower. */
    private Tower rest;

    /**
     * Main method used to create new instance of Tower object.
     *
     * @param args takes input from the command line
     */
    public static void main(String [] args){
    }
    
    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }
    
    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }
        
    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     *
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /**
     * Method returns the height of the Tower object.
     * 
     * @return the height of the Tower as an int
     */
    public int height(){
        if (isEmpty()){
            return 0;
        }else{
            return 1+ rest.height();
        }
    }

    /**
     * Method that returns the number of time a certain
     * char apperas in the tower.
     * <p>
     * Uses recursion and goes thorugh each Tower object
     * to check if they contain the char parameter.
     *
     * @param c the char to check for in the Tower objects
     * @return the number of occrances of the parameter in the tower
     */
    public int count(char c){

        int counter = 0;

        if(isEmpty()){
            return 0;
        }else if(top == c){
            counter++;
        }
        return counter + rest.count(c);
    }

}//end class
