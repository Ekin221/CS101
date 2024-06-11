import java.util.Scanner;

public class Question1 {
    private static int[] arrival_times = {9,5,8,7,9,7,8};
    private static int[] departure_times = {12,7,11,12,10,9,10};
    private static String[] names = {"Ela","Eren","Alona","Jen","Mark","Mel","Ender"};
    private static int size = names.length;
    
    public static int[] friendsAttending() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter time interval you are available: ");
        int arrival = in.nextInt();
        int departure = in.nextInt();
        int[] array = new int[departure - arrival];
        /*
         * At 6pm, 1 friends will be at the party
        At 7pm, 2 friends will be at the party
        At 8pm, 4 friends will be at the party
         */
        int count = 0;
        int max = 0;
        int max_time = 0;
        for(int i = 0; i<array.length; i++){
            for(int j=0; j<size; j++){
                if(i + arrival>=arrival_times[j] && i+arrival<departure_times[j]){
                    count++;
                }
            }
            array[i] = count;
            if(count > max){
                max = count;
                max_time = i + arrival;
            }
            count = 0;
        }
        int time = arrival; 
        if(time<departure){
            for(int m = 0; m<array.length; m++){
                System.out.println("At " + time + "pm, " + array[m] + " friends will be at the party");
                time++;
            }
        }
        System.out.println("Best time to attend is " + max_time);
        return array;
    }
    public static int bestTimeToAttend() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter friend you wish to avoid: ");
        String avoid = in.next();
        System.out.print("Enter time interval you are available: ");
        int arrival = in.nextInt();
        int departure = in.nextInt();
        int avoid_index = 0;
        for(int i = 0; i<size; i++){
            if(names[i].equals(avoid)){
                avoid_index = i;
            }
        }
        int[] avoid_array = new int[departure_times[avoid_index] - arrival_times[avoid_index]];
        for(int i = 0; i<departure_times[avoid_index] - arrival_times[avoid_index]; i++){
            avoid_array[i] = i + arrival_times[avoid_index];
        }
        int count = 0;
        int max = 0;
        int max_time = 0;
        int[] array = new int[departure - arrival];
        for(int i = 0; i<array.length; i++){
            for(int j=0; j<size; j++){
                if(i + arrival>=arrival_times[j] && i+arrival<departure_times[j]){
                    for(int m = 0; m<avoid_array.length; m++){
                        if(i+arrival != avoid_array[m]){
                            count++;
                        }
                    }
                }
            }
            array[i] = count;
            if(count > max){
                max = count;
                max_time = i + arrival;
            }
            count = 0;
        }
        return max_time;
        
        

    }
    public static void main(String[] args) {
        int[] array = friendsAttending();
        //System.out.println("Best time to attend to avoid Ela and to see the most friends is "+bestTimeToAttend());        
    }

}
