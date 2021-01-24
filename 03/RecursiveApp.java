package week03;

public class RecursiveApp{

    /**
     * Method takes a long as a parameter and returns the
     * number of digits given.
     *
     * @param n digits to be counted
     * @return the number of digits
     */
    public static long digits(long n){

        long input = n;
        long digits = 0;
        while(input > 0){
            digits++;
            input /= 10;
        }
        return digits;
    }

    /**
     * Method tajes a long as a parameter and returns the
     * sum of the digits.
     *
     * @param n digits to be summed up
     * @return the sum of digits
     */
    public static long sumOfDigits(long n){

        long input = Math.abs(n);
        long sum = 0;
         
        while(input > 0){
            sum += input % 10;
            input = input/10;
        }
        if(n < 0){
            return (sum *(-1));
        }else{
            return sum;
        }
    }

}//end class
