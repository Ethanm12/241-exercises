package week06;

public class RecursiveApp{

    public static long digits(long n){

        if(n<0){
            return digits(-1*n);
        }else if(n<10){
            return 1;
        }else{
            return 1 + digits(n/10);
        }
    }

    public static long sumOfDigits(long n){

        if(n<0){
            return sumOfDigits(-1*n) * (-1);
        }else if(n<10){
            return n;
        }else{
            return (n%10) + sumOfDigits(n/10);
        }
    }
}
                
