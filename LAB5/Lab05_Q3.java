import java.util.Scanner;

public class Lab05_Q3 {
    //displayMenu(): displays the menu shown in the sample run

    public static void displayMenu() {
        System.out.println("1 - Find Probability of Same Birthday");
        System.out.println("2 - Draw Chart");
        System.out.println("3 - Convert Word");
        System.out.println("4 - QUIT");   
    }
    //getChoice(): inputs and returns the integer menu choice.
    public static void getChoice(int choice) {
        Scanner in = new Scanner(System.in);        
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4)
            {
                System.out.println("Invalid choice");
            }
            else if(choice == 1)
            {
                System.out.print("Enter the group size: ");
                int groupSize = in.nextInt();
                sameBirthday(groupSize);
            }  
            else if(choice == 2)
            {
                System.out.print("Enter chart data: ");
                String chartData = in.next();
                displayChart(chartData);
            }
            else if(choice == 3)
            {
                System.out.print("Enter word to convert: ");
                String word = in.next();
                System.out.println("Original word: " + word + " Converted word: " + convertWord(word));
            }
            else if(choice == 4)
            {
                System.out.println("GOODBYE!");
            }
    }
    /*
     * sameBirthday(): takes an int group size as a parameter and returns the probability of a 
    same birthday in a group with the given size
     */
    public static double sameBirthday(int groupSize) {
        double d = 365; //number of days in the year
        double probability = 0;
        double total = 1;
        for(int i = 0; i<groupSize; i++){
            total = total * (d-i)/d;
            probability = 1 - total;
        }
        System.out.println("The probability of two people in a group of " + groupSize + " having the same birthday is " + Math.round(probability)); 
        return probability;     
    }
    //findMax(): takes an integer as a parameter and returns the maximum digit in the integer.
    public static int findMax(int number) {
        int max_digit = Integer.MIN_VALUE;
        int digit = 0;
        while(number>0){
            digit = number % 10;
            if(digit > max_digit)
            {
                max_digit = digit;
            }
            number = number / 10;
        }
        return max_digit;
    }
    /*
     * • displayChart(): takes a String chartData as a parameter, and displays the chart using the
    parameter data
     */
    public static void displayChart(String charData) {
        for(int i = 0; isValidNumeric(charData) && i<charData.length(); i++){
            System.out.print("review " + (i+1) + "  ");
        }
        System.out.println();
        if(isValidNumeric(charData))
        {
            int integer_version = Integer.parseInt(charData);
            int max_digit = findMax(integer_version);
            String space = " ";
            for(int i = max_digit; i>0; i--){
                for(int j = 0; j<charData.length(); j++){
                    if(Integer.parseInt(String.valueOf(charData.charAt(j)))>=i)
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
    /*
     *isValidNumeric(): takes a String as a parameter and returns true if all characters are 
    numeric, false if not
     */
    public static boolean isValidNumeric(String str){
        for(int i = 0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    /*
     * countLetter(): takes a string and an int index as parameters, and counts and returns the 
    number of times the character at the given index appears in the string
     */
    public static int countLetter(String str, int index) {
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(index))
            {
                count++;
            }
        }
        return count;
    }
    /*
     * convertWord(): takes a string word as a parameter and converts the word according to the 
     logic shown in menu choice 3 (question 3 from lab 4).
     */
    public static String convertWord(String word) {
        String converted_word = "";
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
        return converted_word;
    }
    public static void main(String[] args) {
        displayMenu();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = in.nextInt();
        if(choice != 4)
        {
            do{
                getChoice(choice);
                System.out.println();
                displayMenu();
                System.out.print("Enter choice: ");
                choice = in.nextInt();
            }while(choice != 4);
        }
        getChoice(choice);
    }
    
}
