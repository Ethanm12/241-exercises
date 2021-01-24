package week12;

public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if(t.length <= 1){
            return true;
        }else{
            return rowLengthsDecrease(t) && rowValuesIncrease(t) && columnValuesIncrease(t) && isSetOf1toN(t);
        }
    }

    public static boolean rowLengthsDecrease(int[][] t){
        for(int i=1; i <t.length; i++){
            if(t[i-1].length < t[i].length){
                return false;
            }
        }
        return true;
    }

    public static boolean rowValuesIncrease(int[][] t){
        for(int i=0; i < t.length; i++){
            for(int j=1; j < t[i].length; j++){
                if(t[i][j-1] > t[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean columnValuesIncrease(int[][] t){
        for(int i=1; i < t.length; i++){
            for(int j=0; j < t[i].length; j++){
                if(t[i-1][j] > t[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isSetOf1toN(int[][] t){

        int cell = 0;
        for(int[] array: t){
            cell += array.length;
        }

        boolean[] check = new boolean[cell];
        for(int i=0; i <t.length; i++){
            for(int j=0; j < t[i].length; j++){
                int value = t[i][j];
                try{
                    if(check[value-1]){
                        return false;
                    }else{
                        check[value-1] = true;
                    }
                }catch(IndexOutOfBoundsException e){
                    return false;
                }
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
