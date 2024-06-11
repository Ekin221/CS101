import java.util.Scanner;

public class Lab05_Q1 {
    public static int persistence(int number){
        int count = 0;
        int digit;
        int multiplicative = 1;
        while(number>10){
            while(number!=0){
                digit = number % 10;
                multiplicative = multiplicative * digit;
                number = number / 10;
            }
            number = multiplicative;
            multiplicative = 1;
            count ++;
        }
        return count;
    }
    public static void main(String[] args) {
        /*
         * Enter a positive integer: -231
        Enter a positive integer: abc
        Enter a positive integer: 0
        Enter a positive integer: 345
        multiplicative persistence of 345 is 2
         */
        Scanner in = new Scanner(System.in);
        int number;
        do{
            System.out.print("Enter a positiv e integer: ");
            if(in.hasNextInt())
            {
                number = in.nextInt();
                if(number>0)
                {
                    System.out.println("Multiplicative persistance of " + number + " is " + persistence(number));
                }
            }
            else
            {
                in.next();
                number = -1;
            }

        }while(number<=0);
    }

}
