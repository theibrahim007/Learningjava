import java.util.HashMap;
import java.util.Map;

public class MyMapExample {
    public static void main(String[] args) {

        // 1. We are making a new HashMap (one of the purple boxes)
        Map<String, Integer> myLockers = new HashMap<>();

        // 2. We put things inside the lockers
        // "Ibrahim" is the Key (the name), 9 is the Value (the thing inside)
        myLockers.put("Ibrahim", 9);
        myLockers.put("Sara", 12);

        // 3. We open a locker to see what's inside
        int myAge = myLockers.get("Ibrahim");

        System.out.println("Ibrahim's age is: " + myAge);
        // This will print: Ibrahim's age is: 9
    }
}