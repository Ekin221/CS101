import java.util.Scanner;

public interface Lab04_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the minimum and maximum number of people: ");
        int min_group_size = in.nextInt();
        int max_group_size = in.nextInt();
        if(max_group_size<=min_group_size)
        {
            do{
                if(max_group_size<min_group_size || max_group_size == min_group_size)
                {
                    System.out.println("Invalid input - minimum must be less than maximum...");
                }
                System.out.print("Enter the minimum and maximum number of people: ");
                min_group_size = in.nextInt();
                max_group_size = in.nextInt();
            }while(!(max_group_size>min_group_size));
        }
        String space = " ";
        System.out.println("NUMBER OF PEOPLE" + space.repeat(5) + "PROBABILITY");

        double d = 365; //number of days in the year
        double probability = 0;
        double total = 1;
        for(int r = min_group_size; r<= max_group_size; r++){
            System.out.print(r + space.repeat(19));
            for(int i = 0; i<r; i++){
                total = total * (d-i)/d;
                probability = 1 - total;
            }
            System.out.printf("%.3f %n", probability);
            total = 1;
            probability = 0;
        }

    }
}
