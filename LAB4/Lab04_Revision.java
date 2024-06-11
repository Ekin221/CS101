import java.util.Scanner;

public class Lab04_Revision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter word to convert: ");
        String word = in.next();
        boolean isLowerCase = true;
        for(int i = 0; i<word.length() && isLowerCase; i++){
            if(!Character.isLowerCase(word.charAt(i)))
            {
                System.out.println("Invalid input! Only enter lowercase letters.");
                isLowerCase = false;
            }
        }
       
        char special = ' ';
        if(isLowerCase)
        {
            System.out.println("Length: " + word.length());
            if(word.length() % 2 == 0)
            {
                special = word.charAt(0);
                for(int i = 0; i<word.length(); i++){
                    if(word.charAt(i) == special)
                    {
                        word = word.substring(0, i) + "(" + word.substring(i+1, word.length());
                    }
                }
            }
            else if(word.length() % 2 == 1)
            {
                special = word.charAt(word.length()/2);
                for(int i = 0; i<word.length(); i++){
                    if(word.charAt(i) == special)
                    {
                        word = word.substring(0, i) + "(" + word.substring(i+1, word.length());
                    }
                }
            }
            System.out.println("Special letter: " + special);
        }
        int difference = special - 'a';
        int new_char;
        for(int i = 0; isLowerCase && i<word.length(); i++){
            if(Character.isLetter(word.charAt(i)))
            {
                new_char = word.charAt(i) + difference;
                char character = (char) new_char;
                word = word.substring(0, i) + character + word.substring(i+1, word.length());
            }
        }
        if(isLowerCase){
        System.out.println("Converted word: " + word);
        }

        
        
        /*String converted_word = "";
        for(int i = 0; isLowerCase&& i<word.length(); i++){
            converted_word += String.valueOf((word.charAt(i)-'a'));
        }
        System.out.println("Converted word: " + converted_word);
        */
        
    }
    
}
