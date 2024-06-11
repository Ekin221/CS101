import java.util.Scanner;
import java.util.Random;


public class Lab03_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Random rand = new Random(); 

        System.out.println("1) Encode Message");
        String encoded_word = "";
        System.out.println("2) Decode Message");
        System.out.println("3) Quit");
        System.out.print("Enter choice: ");
        int choice = in.nextInt();
        String result = "";
        while(choice != 3){
            if(choice != 1 && choice != 2)
            {
                System.out.println("Invalid choice - try again....");
            }
            else if(choice == 1)
            {
                System.out.print("Enter word to encode: ");
                encoded_word = in.next();
                while(encoded_word.length()<2){
                    System.out.println("Invalid length word - try again");
                    System.out.print("Enter word to encode: ");
                    encoded_word = in.next();
                }
                int number_of_digit = encoded_word.length();
                result = encoded_word + "*".repeat(number_of_digit);
                // "*" for digit 
                int index_to_split = rand.nextInt(result.length()-1);
                while(index_to_split == 0 || index_to_split == result.length()-1)
                {
                    index_to_split = rand.nextInt(result.length());
                }
                if(index_to_split<result.length())
                {
                    result = result.substring(0, index_to_split) + " " + result.substring(index_to_split,result.length());
                }

                
                int i = 0;
                int digit;
                int index_to_digit;
                int index_prev_digit = -1;
                while(i<number_of_digit){
                    index_to_digit = rand.nextInt(result.length()-1);
                    digit = rand.nextInt(9);
                    while(index_to_digit == index_to_split || index_to_digit == index_prev_digit){
                        index_to_digit = rand.nextInt(result.length()-1);
                    }
                    String str_digit = Integer.toString(digit);
                    result = result.substring(0, index_to_digit) + str_digit + result.substring(index_to_digit,result.length());
                    index_prev_digit = index_to_digit;
                    i++;
                }
                int j = 0;
                while(j<result.length()){
                    if(result.charAt(j) == '*' )
                    {
        
                        result = result.replace("*", ""); 
                    }
                    j++;
                }

                System.out.println(result);

            }
            else if(choice == 2)
            {
                if(encoded_word.equals(""))
                {
                    System.out.println("No message to decode....");
                }
                else
                {
                    //Decode should use an algorithm to convert the encoded message to the original version.
                    int m = 0;
                    String decoded_version = "";
                    while(m<result.length()){
                        if(Character.isLetter(result.charAt(m)))
                        {
                            decoded_version += result.charAt(m);
                        }
                        m++;
                    }
                    System.out.println("The decoded message: " + decoded_version);
                }
            }
            System.out.println("1) Encode Message");
            System.out.println("2) Decode Message");
            System.out.println("3) Quit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            
        }
        if(choice == 3)
        {
            System.out.println("Thank you, goodbye!");
        }
    }
    
}
