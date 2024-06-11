import java.util.Scanner;
public class Lab01_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = in.nextInt();
        double y;
        y = (Math.pow(x,3) + (3*Math.abs(x)) + 9)/ Math.pow(x, 2);
        //to show two decimal of y
        System.out.printf("%.2f",y);
        System.out.print(" is between " + Math.floor(y) + " and " + Math.ceil(y));
        

        
    }
    
}
