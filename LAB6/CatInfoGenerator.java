import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CatInfoGenerator {
    private static final int CAMPUS_RADIUS = 250;
    private static final int MAX_MONTHS = 60;
    private static String[] arrayOfNames = {"Gollum","Spiderman","Mocha","Gora","Zeytin","Spot","Pamuk","Duman","Pasha","Tickles","Kahve","Tekir","Benek","Checkers", "Karamel","Tik Tak", "Havuç", "Blizzard", "Splatter", "Sprite","Hamur","Pofuduk","Popsicle","Ash","Gofret","Latte","Aslan","Patches","Lucky","Fluffy"};
    private static ArrayList<String> catNames = new ArrayList<String>( Arrays.asList( arrayOfNames ));
    
    public static ArrayList<String> getRandomNameList( int num ){
        ArrayList<String> randomNames = new ArrayList<String>();
        Random rand = new Random();
        int index;
        if(num > catNames.size()){
            num = catNames.size();
        }
        int size = 0;
        boolean isSame = false;
        while(size < num){
            index = rand.nextInt(catNames.size());
            if(randomNames.size() == 0){
                randomNames.add(catNames.get(index));
                size++;
            }
            else{
                for(int i = 0; i<randomNames.size(); i++){
                    if(catNames.get(index).equals(randomNames.get(i))){
                        isSame = true;
                    }
                    while(isSame){
                        index = rand.nextInt(catNames.size());
                        if(!(catNames.get(index).equals(randomNames.get(i)))){
                            isSame = false;
                        }
                    }
                }
                randomNames.add(catNames.get(index));
                size++;
            }
        }
        return randomNames;
    }
	
    public static ArrayList<String> getRandomLocationList( int num ){
        ArrayList<String> randomLocations = new ArrayList<String>();
        int randX;
        int randY;

        Random rand = new Random();
        int locCount = 0; //name counter

        while (  locCount < num ){    
            randX = rand.nextInt( CAMPUS_RADIUS * 2 );
            randY = rand.nextInt( CAMPUS_RADIUS * 2 );
            //if name not already added to list
            if( Math.sqrt( Math.pow(randX,2) + Math.pow(randY,2)) <= CAMPUS_RADIUS * 2 ){
                randomLocations.add( randX + "," + randY );
                locCount++;
            }
        }
        return randomLocations;
    }
    public static ArrayList<Integer> getRandomMonthList( int num ){
        ArrayList<Integer> randomMonths = new ArrayList<Integer>();
        int month;
    
        Random rand = new Random();

        for ( int i = 0; i < num; i++ ){    
            month = rand.nextInt( MAX_MONTHS );
            randomMonths.add( month );
        }
        return randomMonths;
    }
    /*
     * double calculateDistance(): takes 2 String locations (“x,y”) as parameters and 
    returns the distance between the two locations. To calculate the distance between two points, 
    use the following formula:
     */
    public static double calculateDistance(String loc1, String loc2) {
        double distance;
        int val1_x = 0;
        int val1_y = 0;
        for(int i = 0; i<loc1.length(); i++){
            if(loc1.charAt(i) == ','){
                val1_x = Integer.parseInt(loc1.substring(0, i));
                val1_y = Integer.parseInt(loc1.substring(i+1, loc1.length()));
            }
        }
        int val2_x = 0;
        int val2_y = 0;
        for(int i = 0; i<loc2.length(); i++){
            if(loc2.charAt(i) == ','){
                val2_x = Integer.parseInt(loc2.substring(0, i));
                val2_y = Integer.parseInt(loc2.substring(i+1, loc2.length()));
            }
        }
        distance = Math.sqrt((Math.pow(val1_x-val2_x, 2)) + Math.pow(val1_y-val2_y, 2));
        return distance;        
    }
    /*
     * boolean doesIntersect(): takes 2 String locations as parameters and returns true if the circles with the given centre points intersect, false if not. 
    Two circles intersect if the distance between their centres is less than or equal to the sum of their radii.  
     */
    public static boolean doesIntersect(String loc1, String loc2) {
        if(calculateDistance(loc1, loc2)<=100)
        {
            return true;
        }
        return false;
    }
    /*
     * int countIntersecting(): takes a location and an ArrayList of locations as parameters 
     * and counts and returns the number of locations in the ArrayList that intersect with the given location
     */
    public static int countIntersecting(String location, ArrayList<String> locationList) {
        int count = 0;
        for(int i = 0; i<locationList.size(); i++){
            if(doesIntersect(location,locationList.get(i)))
            {
                count++;
            }
        }
        return count;
    }
    /*
     * displayIntersections(): takes a list of cats, locations and months as parameters, and 
     * for each cat, displays the information about the cats with intersecting home territories.
     */
    public static void displayIntersections(ArrayList<String> Cat_list, ArrayList<String> Location_list, ArrayList<Integer> Months_list) {
        /*
         * Blizzard at location 365,225 for 45 months intersects with: Patches, at location 375,244 for 49 month
         * Karamel at location 122,366 for 34 months intersects with: NO CATS
         */
        for(int i = 0; i<Cat_list.size(); i++){
            int count = 0;
            System.out.print(Cat_list.get(i) + " at location " + Location_list.get(i) + " for " + Months_list.get(i) + " months intersects with: ");
            for(int j = 0; j<Cat_list.size(); j++){
                if(i != j){
                    if(doesIntersect(Location_list.get(i), Location_list.get(j)))
                    {
                        System.out.print(Cat_list.get(j) + ", at location " + Location_list.get(j) + " for " + Months_list.get(j) + " months.");
                        count++;
                    }
                }
            }
            if(count == 0){
                System.out.print("NO CATS");
            }
            System.out.println();
        }
    }
    /*
     * findMinMonthsAtLocation(): takes a String location and an ArrayList of locations as 
    parameters, and finds all cats whose territories intersect with the given String location, and 
    returns the index of the cat who has been in their intersecting location for the minimum number of months
     */
    public static int findMinMonthsAtLocation(String location, ArrayList<String> Locations, ArrayList<Integer> Months ) {
        int min_index = 0;
        int min = MAX_MONTHS;
        for(int i = 0; i<Locations.size(); i++){
            if(doesIntersect(location, Locations.get(i))){
                if(Months.get(i) < min){
                    min = Months.get(i);
                    min_index = i;
                }
            }
        }
        return min_index;
    }
    /*
     * findRandomLocation(): returns a String location (“x,y” coordinate) within the bounds of the Bilkent campus
     */
    public static String findRandomLocation() {
        Random rand = new Random();
        //EMIN DEGILIM
        int loc_x = rand.nextInt(CAMPUS_RADIUS*2);
        int loc_y = rand.nextInt(CAMPUS_RADIUS*2);
        String location = Integer.toString(loc_x) + "," + Integer.toString(loc_y);
        return location;
    }
    /*
     * moveCats(): takes 2 lists, locations and months, and find all locations with 3 or more intersecting cats. 
     * For each location if there are 3 or more cats whose home territories intersect, 
     * move the cat who has been at the location for the minimum number of months. 
     * The territory of the new location should have no cats with intersecting home territories.
     */
    public static ArrayList<String> moveCats(ArrayList<String> locations, ArrayList<Integer> months) {        
        for(int i = 0; i<locations.size(); i++){
            int moving_index;
            String new_location = "";
            if(countIntersecting(locations.get(i),locations) >= 3) //at the intersection that will count itself
            {
                moving_index = findMinMonthsAtLocation(locations.get(i), locations, months);
                do{
                    new_location = findRandomLocation();
                }while((doesIntersect(new_location, locations.get(i))));
                locations.set(moving_index, new_location);

            }
        }
        return locations;
    }

    public static void main(String[] args) {
        int num = catNames.size();
        ArrayList<String> names = getRandomNameList(num);
        ArrayList<String> locations = getRandomLocationList(num);
        ArrayList<Integer> months = getRandomMonthList(num);

        System.out.println("Before moving the cats: ");
        displayIntersections(names, locations, months);
        System.out.println("After moving the cats: ");
        locations = moveCats(locations, months);
        displayIntersections(names, locations, months);
    }
} 
