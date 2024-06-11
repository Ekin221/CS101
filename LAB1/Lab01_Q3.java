import java.util.Scanner;
public class Lab01_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter kilograms to lose: ");
        int kilograms = in.nextInt();
        System.out.println();
        System.out.print("Enter days to lose " + kilograms + " kilograms: ");
        int days = in.nextInt();
        System.out.println();
        final int MAINTAINING = 2000;
        final int LOSING = 7700; //deficit
        int deficit_eachDay = (LOSING*kilograms) / days;
        System.out.println("*".repeat(105));
        System.out.println("To lose " + kilograms + " kilograms in " + days + " days you will need a daily deficit of " + deficit_eachDay + " calories");
        System.out.println("*".repeat(105));
        int daily_calories_recommended = MAINTAINING-deficit_eachDay;
        System.out.println("RECOMMENDED DAILY CALORIES TO LOSE " + kilograms + " KILOS IN " + days + ": " + daily_calories_recommended);
        System.out.println("*".repeat(105));
        
        //Recommended Percent
        final double CARBOHYDRATE = 50;
        final double FAT = 30;
        final double PROTEIN = 20;
        //Calories Per Gram
        final double CARBOHYDRATE_CALORIES = 4;
        final double FAT_CALORIES = 9;
        final double PROTEIN_CALORIES = 4;
        //Recommended Calories
        double carbohydrate = daily_calories_recommended * CARBOHYDRATE / 100;
        double fat = daily_calories_recommended * FAT / 100;
        double protein = daily_calories_recommended *PROTEIN / 100;
        
        //Grams
        double carbohydrate_gram = carbohydrate / CARBOHYDRATE_CALORIES;
        double fat_gram = fat / FAT_CALORIES;
        double protein_gram = protein / PROTEIN_CALORIES;
       // System.out.println(CARBOHYDRATE + " " + CARBOHYDRATE_CALORIES + " " + carbohydrate_Rounded + " " + carbohydrate_gram);
        System.out.println("MACRO" + " ".repeat(16) + "RECOMMENDED PERCENT" + " ".repeat(3) + "CALORIES PER GRAM" + " ".repeat(5) + "RECOMMENDED CALORIES" + " ".repeat(15) + "GRAMS");
        System.out.printf("CARBOHYDRATE %26.0f%s %19.0f %24.0f %19.1f\n", CARBOHYDRATE,"%",CARBOHYDRATE_CALORIES, carbohydrate,carbohydrate_gram);
        System.out.printf("FAT %35.0f%s %19.0f %24.0f %19.1f\n", FAT,"%",FAT_CALORIES, fat,fat_gram);
        System.out.printf("PROTEIN %31.0f%s %19.0f %24.0f %19.1f\n", PROTEIN,"%",PROTEIN_CALORIES, protein,protein_gram);
        System.out.println("*".repeat(105));



      

    }
    
}
