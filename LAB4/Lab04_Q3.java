import java.util.Scanner;

public class Lab04_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter word to convert: ");
        String word = in.next();
        String temp = word;
        String converted_word = "";
        do{
            for(int i = 0; i<word.length(); i++){
                if(!Character.isLetter(word.charAt(i)))
                {
                    if(word.charAt(i) != ')' && word.charAt(i) != '(')
                    {
                        word = word.substring(0, i) + "*" + word.substring(i+1, word.length());
                    }
                }
                else
                {
                    if(i != word.length()-1)
                    {
                        for(int j = i+1; j<word.length(); j++){
                            if(word.charAt(i) ==  word.charAt(j))
                            {
                                word = word.substring(0, i) + ")" + word.substring(i+1, j) + ")" + word.substring(j+1, word.length());
                            }
                        }
                    }
                    else
                    {
                        word = word.substring(0, i) + "(";
                    }
                }
            }
            for(int i = 0; i<word.length(); i++){
                if(Character.isLetter(word.charAt(i)))
                {
                    word = word.substring(0, i) + "(" + word.substring(i+1, word.length());
                }
            }
            converted_word = word;
            System.out.printf("Original word: %s   Converted word: %s %n",temp,converted_word);
            System.out.print("Enter word to convert: ");
            word = in.next();
        } while((!(word.equals("exit"))));   
    }
}
