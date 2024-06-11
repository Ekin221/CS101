import java.util.Scanner;

public class Lab02_Revision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = in.nextLine();
        if(str.length()>=4)
        {
            if(str.length() % 2 == 0)
            {
                int length_str = str.length();
                char first = str.charAt(0);
                char last = str.charAt(str.length()-1);
                char middle2 = str.charAt(length_str/2);
                char middle1 = str.charAt(length_str/2-1);
                int value_first = first;
                int value_middle1 = middle1;
                int value_middle2 = middle2;
                int value_last = last;
                if(Character.isLowerCase(first) && Character.isLowerCase(middle1) && Character.isLowerCase(middle2) && Character.isLowerCase(last))
                {
                    System.out.println("first:" + first + " middle1:" + middle1 + " middle2:" + middle2+ " last:" + last);
                    if(Math.abs(value_first-value_last)<=1 && Math.abs(value_first-value_middle1)>=2 && Math.abs(value_first-value_middle2)>=2 && Math.abs(value_middle1-value_last)>=2&&Math.abs(value_middle2-value_last)>=2 && Math.abs(value_middle1-value_middle2) >=2)
                    {
                        System.out.println("String is special: true");
    
                    }
                    else if(Math.abs(value_first-value_middle1)<=1 && Math.abs(value_first-value_middle2)>=2 && Math.abs(value_first-value_last)>=2 && Math.abs(value_last-value_middle1)>=2 && Math.abs(value_last-value_middle2) >=2&& Math.abs(value_middle1-value_middle2)>=2)
                    {
                        System.out.println("String is special: true");
                    }
                    else if(Math.abs(value_first-value_middle2)<=1 && Math.abs(value_first-value_middle1)>=2 && Math.abs(value_first-value_last)>=2 && Math.abs(value_last-value_middle1)>=2 && Math.abs(value_last-value_middle2)>=2 && Math.abs(value_middle1-value_middle2)>=2)
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
                System.out.println("You entered odd length");
            }
            
        }
        else
        {
            System.out.println("Length of string not sufficient");
        }
    }
}
