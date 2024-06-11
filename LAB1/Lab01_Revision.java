import java.util.Scanner;
public class Lab01_Revision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter kilograms to lose: ");
        int kilograms = in.nextInt();
        System.out.println();
        System.out.print("Enter days to lose " + kilograms + " kilograms: ");
        int days = in.nextInt();
        System.out.println();
        System.out.print("Enter the percentages of carbohydrate that you want to take: ");
        double amount_carbohydrate = in.nextDouble();
        System.out.println();
        final int MAINTAINING = 2000;
        final int LOSING = 7700; //deficit
        int deficit_eachDay = (LOSING*kilograms) / days;
        System.out.println("*".repeat(135));
        System.out.println("To lose " + kilograms + " kilograms in " + days + " days you will need a daily deficit of " + deficit_eachDay + " calories");
        System.out.println("*".repeat(135));
        int daily_calories_recommended = MAINTAINING-deficit_eachDay;
        System.out.println("RECOMMENDED DAILY CALORIES TO LOSE " + kilograms + " KILOS IN " + days + ": " + daily_calories_recommended);
        System.out.println("*".repeat(135));

        //Recommended Percent
        final double recommended_carbohydrate = 50;
        final double recommended_fat = 30;
        final double recommended_protein = 20;

        //DESIRED PERCENTAGE
        final double TOTAL = 100.0;
        double remaining_percentage = TOTAL-amount_carbohydrate;
        double FAT = remaining_percentage*0.60;
        double PROTEIN = remaining_percentage*0.40;
        //Calories Per Gram
        final double CARBOHYDRATE_CALORIES = 4;
        final double FAT_CALORIES = 9;
        final double PROTEIN_CALORIES = 4;
        //Recommended Calories
        double carbohydrate = daily_calories_recommended * amount_carbohydrate / 100;
        double fat = daily_calories_recommended * FAT / 100;
        double protein = daily_calories_recommended *PROTEIN / 100;
        
        //Grams
        double carbohydrate_gram = carbohydrate / CARBOHYDRATE_CALORIES;
        double fat_gram = fat / FAT_CALORIES;
        double protein_gram = protein / PROTEIN_CALORIES;
        System.out.println("MACRO" + " ".repeat(16) + "RECOMMENDED PERCENT" + " ".repeat(3) + "CALORIES PER GRAM" + " ".repeat(5) + "RECOMMENDED CALORIES" + " ".repeat(15) + "GRAMS" + " ".repeat(15) + "DESIRED PERCENT");
        System.out.printf("CARBOHYDRATE %26.0f%s %19.0f %24.0f %19.1f %28.0f%s\n", recommended_carbohydrate,"%",CARBOHYDRATE_CALORIES, carbohydrate,carbohydrate_gram,amount_carbohydrate,"%");
        System.out.printf("FAT %35.0f%s %19.0f %24.0f %19.1f %28.0f%s\n", recommended_fat,"%",FAT_CALORIES, fat,fat_gram,FAT,"%");
        System.out.printf("PROTEIN %31.0f%s %19.0f %24.0f %19.1f %28.0f%s\n", recommended_protein,"%",PROTEIN_CALORIES, protein,protein_gram,PROTEIN,"%");
        System.out.println("*".repeat(135));



      

    }
    
}
