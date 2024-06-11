import java.util.Scanner;
public class Lab01_Q2 {
    public static void main(String[] args) {
        /*
         * Enter date and time: 08:10/Saturday-April-01,2023
        10 minutes past 08 on 01 April 2023 (Saturday)
         */
        Scanner in = new Scanner(System.in);
        String dateTime = in.next();
        int ind1 = dateTime.indexOf(":");
        int ind2 = dateTime.indexOf("/");
        int ind3 = dateTime.indexOf("-");
        int ind4 = dateTime.indexOf("-",ind3+1);
        int ind5 = dateTime.indexOf(",");
        System.out.println(dateTime.substring(ind1+1,ind1+3) + " minutes past " + dateTime.substring(0,ind1) + " on "+dateTime.substring(ind4+1,ind4+3) + " " + dateTime.substring(ind3+1, ind4) + " " + dateTime.substring(ind5+1, dateTime.length()) + " (" + dateTime.substring(ind2 + 1, ind3) + ")");        
        

        in.close();
    }

    
}
