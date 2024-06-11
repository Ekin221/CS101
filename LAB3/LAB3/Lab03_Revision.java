import java.util.Scanner;
import java.util.Random;


public class Lab03_Revision {
    /*
     * Encode2 and Decode2. The validation
    conditions for the input string are the same as the original assignment. In this new
    Encode2 option, the algorithm takes the string, circularly shifts each letter to the right
    twice, and puts * between the letters.
     */
    /*
     * Sample runs 1:
    1) Encode Message
    2) Decode Message
    3) Encode2 Message
    4) Decode2 Message
    5) Quit
    Enter choice: 3
    Enter words to encode: sunshine
    Encoded message: n*e*s*u*n*s*h*i
     */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Random rand = new Random(); 

        System.out.println("1) Encode Message");
        String encoded_word = "";
        System.out.println("2) Decode Message");
        System.out.println("3) Encode2 Message");
        String encoded_word2 = "";
        System.out.println("4) Decode2 Message");
        System.out.println("5) Quit");
        System.out.print("Enter choice: ");
        int choice = in.nextInt();
        String result = "";
        String result2 = "";
        while(choice != 5){
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4)
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
            else if(choice == 3)
            {
                result2 = "";
                System.out.print("Enter word to encode: ");
                encoded_word2 = in.next();
                while(encoded_word2.length()<2){
                    System.out.println("Invalid length word - try again");
                    System.out.print("Enter word to encode: ");
                    encoded_word2 = in.next();
                }
                int i = 0;
                String final_result2 = "";
                while(i<encoded_word2.length()-2){
                    if(i != encoded_word2.length()-3)
                    {
                        result2 += encoded_word2.charAt(i) + "*";
                    }
                    else
                    {
                        result2 += encoded_word2.charAt(i);
                    }
                    i++;
                }
                result2 = encoded_word2.charAt(encoded_word2.length()-2) + "*" + encoded_word2.charAt(encoded_word2.length()-1) + "*" + result2;
                System.out.println("Encoded message: " + result2);
            }
            else if(choice == 4)
            {
                if(encoded_word2.equals(""))
                {
                    System.out.println("No message to decode....");
                }
                else
                {
                    int m = 0;
                    String decoded_version2 = "";
                    while(m<result2.length()){
                            if(result2.charAt(m) != '*')
                            {
                                decoded_version2 += result2.charAt(m);
                            }
                        m++;
                    }
                    int i = 0;
                    String ek = "";
                    String ek2= "";
                    String final_version = "";
                    while(i<decoded_version2.length()){
                        if(i == 0)
                        {
                            ek += decoded_version2.charAt(i);
                        }
                        else if(i == 1)
                        {
                            ek += decoded_version2.charAt(i);
                        }
                        else if(i>=2)
                        {
                            ek2 += decoded_version2.charAt(i);
                        }
                        i++;
                    }
                    final_version =ek2 + ek;
                    System.out.println("The decoded message: " + final_version);
                }
            }
            System.out.println("1) Encode Message");
            System.out.println("2) Decode Message");
            System.out.println("3) Encode2 Message");
            System.out.println("4) Decode2 Message");
            System.out.println("5) Quit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            
        }
        if(choice == 5)
        {
            System.out.println("Thank you, goodbye!");
        }
    }
    
}
