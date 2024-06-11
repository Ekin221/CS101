import java.util.Scanner;

public class Lab04_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter char data: ");
        String heigth = in.next();
        boolean isValid = true;
        for(int i = 0; i<heigth.length() && isValid; i++){
            if(!(Character.isDigit(heigth.charAt(i))))
            {
                isValid = false;
                System.out.println("Invalid chart data!");
            }
        }
        for(int i = 0; isValid && i<heigth.length(); i++){
            System.out.print("review " + (i+1) + "  ");
        }
        System.out.println();
        int max_digit = Integer.MIN_VALUE;
        for(int i = 0; isValid &&i<heigth.length(); i++){
            if(max_digit<Integer.parseInt(String.valueOf(heigth.charAt(i))))
            {
                max_digit = Integer.parseInt(String.valueOf(heigth.charAt(i)));
            }
        }
        String space = " ";
        for(int i = max_digit; i>0; i--){
            for(int j = 0; j<heigth.length(); j++){
                if(Integer.parseInt(String.valueOf(heigth.charAt(j)))>=i)
                {
                    System.out.print(space.repeat(5)+"***" + space.repeat(2));
                }
                else
                {
                    System.out.print(space.repeat(5)+"   " + space.repeat(2));
                }
            }
            System.out.println();
        }

    
    }
    
}