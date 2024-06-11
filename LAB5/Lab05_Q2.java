import java.util.Scanner;

public class Lab05_Q2 {
    //converts a given string using the key given below.
    static final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";
    /*
     * Text you entered: 'Funniest Game'
    After conversion: 'Fuuu!e5+ 6@we'
     */
    /*
     * Write a method, convertChar, which takes a character as a parameter and returns the converted 
    version using the key. 
    The black characters are converted to the following red characters. For 
    instance, if the character 'a' is passed as a parameter, the function returns the '@' character, for 'b', 
    it will return 'p'. 
    Note: the character 'p' WILL NOT be converted to the character 'd'. If the character 
    is not found in the key it should be returned without conversion
     */
    public static char convertChar(char ch) {
        char converted_char = ' ';
        for(int i = 0; i<KEY.length()-1; i++){
            if(ch == KEY.charAt(i))
            {
                if(i % 2 == 0)
                {
                    converted_char = KEY.charAt(i+1);
                    return converted_char;
                }
                else
                {
                    converted_char = KEY.charAt(i);
                }
            }
            else
            {
                converted_char = ch;
            }
        }
        return converted_char;
    }
    /*
     * Write a method, convertText, which takes a string as a parameter and, using the 
    convertChar function, converts the given string. For instance, 'Trials' should be converted to 
    'Tr!@15' as the return value.
     */
    public static String convertText(String text) {
        String converted_string = "";
        for(int i = 0; i<text.length(); i++){
            converted_string += convertChar(text.charAt(i));
        }
        return converted_string;
    }
    /*
     * Write a method, countNumbers, which takes a string as a parameter and returns the count of 
    numeric characters in it. E.g. For the text 'Tr!@15', it should return 2
     */
    public static int countNumbers(String str) {
        int count = 0; 
        for(int i = 0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i)))
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a phrase for conversion: ");
        String phrase = in.nextLine();
        if(phrase.length() > 0)
        {
            System.out.println();
            System.out.print("Text you entered: " + "'" + phrase + "'");
            System.out.println();
            System.out.print("After conversion: " + "'" + convertText(phrase) + "'");
            if(countNumbers(convertText(phrase)) == 0)
            {
                System.out.println();
                System.out.println("!! Attention !! There is no number in this text");
            }
            if(phrase.equals(convertText(phrase)))
            {
                System.out.println();
                System.out.println("No conversion happened");
            }
        }
        else
        {
            System.out.println("No phrase entered.");
        }
        // 'R2D2 & C3PO'

    }
}
