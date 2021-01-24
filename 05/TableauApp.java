package week05;

public class TableauApp {
    
    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false.
     */

    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t) && rowValuesIncrease(t)){
            if(isSetOf1toN(t) && columnValuesIncrease(t)){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Determines if a row is longer than a preceding row.
     *
     * @param t a two-dimentional array to test for tableau-ness.
     *
     * @return true if no row is longer than preceding row, otherwise false.
     */
    public static boolean rowLengthsDecrease(int[][] t){

        //If tableau is empty or has only one row/column
        if ((t.length==0) || (t.length==1 && t[0].length==1)){
            return true;
        }

        for(int i = 0; i < t.length; i++){
            if(i>0){
                if(t[i-1].length <  t[i].length){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines if from left to right in any row, the integers are increasing.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if all rows are increasing, otherwise false.
     */
    public static boolean rowValuesIncrease(int[][] t){
        
        //If tableau is empty or has only one row/column
        if ((t.length==0) || (t.length==1 && t[0].length==1)){
            return true;
        }

        for(int[] row : t){
            int previousInt = 0;
            for(int col : row){
                if (col > previousInt){
                    previousInt = col;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Determines if the values increase from top to bottom in each column.
     *
     * @param t a two-dimentional array to test for tableau-ness.
     *
     * @return true if the columns are increaseing order, otherwise false.
     */
    public static boolean columnValuesIncrease(int[][] t){
        
        if ((t.length==0) || (t.length==1 && t[0].length==1)){
            return true;
        }
        for (int r = 0; r < t.length; r++){
            for(int c = 0; c < t[r].length; c++){
                if (r > 0){
                    if(t[r-1][c]>t[r][c]){
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
    
    /**
     * Determines if the set of integers used is between 1 and n,
     * the number of cells.
     *
     * @param t a two-dimentional array to test for tableau-ness.
     *
     * @return true if the set of integers is between 1 and n.
     **/
    public static boolean isSetOf1toN(int[][] t){

        //determines the number of ints and the highest int in the set
        int totalCells = 0;
        int highestInt = 0;
        for(int r = 0; r < t.length; r++){
            for(int c = 0; c < t[r].length; c++){
                if (t[r][c] > highestInt){
                    highestInt = t[r][c];
                }
                totalCells++;
            }
        }

        //adds all numbers in the set to an array
        int [] a = new int[highestInt];
        int index = 0;
        for(int[] row: t){
            for (int col: row){
                a[index] = col;
                index++;
            }
        }

        //sorts the numbers in the array
        int count = 0;
        while(count<index){
            for (int i = index-1; i > 0; i--){
                int prev = 0;
                if(a[i] < a[i-1]){
                    prev = a[i-1];
                    a[i-1] = a[i];
                    a[i] = prev;
                }
            }
            count++;
        }
        //checks to see if the numbers in the set are of {1,2...n} 
        int current = 1;
        for(int i= 0; i <a.length; i++){
            if (a[i] == current){
                current++;
            }else{
                return false;
            }
        }
        return true;
    }
    

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    
}
