import java.util.Scanner;

public class Lab02_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = in.nextLine();
        if(str.length()>=3)
        {
            int length_str = str.length();
            char first = str.charAt(0);
            char last = str.charAt(str.length()-1);
            char middle;
            if(length_str % 2 == 0)
            {
               middle = str.charAt(str.length()/2);
            }
            else
            {
               middle = str.charAt((str.length()-1)/2);
            }
            int value_first = first;
            int value_middle = middle;
            int value_last = last;
            if(Character.isLowerCase(first) && Character.isLowerCase(middle) && Character.isLowerCase(last))
            {
                System.out.println("first:" + first + " middle:" + middle + " last:" + last);
                if(Math.abs(value_first-value_last)<=1 && Math.abs(value_first-value_middle)>=2 && Math.abs(value_middle-value_last)>=2)
                {
                    System.out.println("String is special: true");
                }
                else if(Math.abs(value_first-value_middle)<=1 && Math.abs(value_first-value_last)>=2 && Math.abs(value_middle-value_last)>=2)
                {
                    System.out.println("String is special: true");
                }
                else
                {
                    System.out.println("String is special: false");
                }
            }
            else
            {
                System.out.println("Characters not lowercase letters...");
            }
        }
        else
        {
            System.out.println("Length of string not sufficient");
        }
    }
}
