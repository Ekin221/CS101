import java.util.Scanner;

public class Lab02_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print( "Enter a real number:  ");
        double result = 0;
        if(in.hasNextDouble())
        {
            double x = in.nextDouble();
            System.out.println("-----------------------------");
            if(x>15)
            {
                result = Math.sqrt(Math.pow(x,5) + 1);
            }
            else if(x<= 15 && x>=0)
            {
                result = Math.pow(Math.E,x) - 15;
            }
            else if(x<0)
            {
                result = x/(x+10);
            }
            System.out.printf("%s %6.2f ", "f (x) =", result);
        }
        else
        {
            String invalid = in.nextLine();
            System.out.println("Invalid input - value must be numeric....");
            System.out.println("You entered: " + invalid);
        }
    }
    
}
