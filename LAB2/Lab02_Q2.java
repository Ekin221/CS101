import java.util.Scanner;

public class Lab02_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of small and large jars available and the order size: ");
        int number_small = in.nextInt();
        int number_large = in.nextInt();
        int order_size = in.nextInt();
        if(order_size<5)
        {
            System.out.println("Order must be larger than 5 litres");
        }
        else
        {
            int small_jars_needed;
            int litre_large;
            int remain;
            if(number_large*5<=order_size)
            {
                litre_large = number_large*5;
                remain = order_size -litre_large;
                small_jars_needed = remain/1;
                if(small_jars_needed<=number_small)
                {
                    System.out.println("Order of " + order_size + " litres will contain " + small_jars_needed + " small(1 litre)jars");
                }
                else
                {
                    System.out.println("You do not have enough jars to complete the order");
                }
            }
            else
            {
                //1-2-7
                int used_large = order_size/5;
                litre_large = used_large *5;
                remain = order_size - litre_large;
                small_jars_needed = remain/1;
                if(small_jars_needed<=number_small)
                {
                    System.out.println("Order of " + order_size + " litres will contain " + small_jars_needed + " small(1 litre)jars");
                }
                else
                {
                    System.out.println("You do not have enough jars to complete the order");
                }
            }
        }
    }
    
}
