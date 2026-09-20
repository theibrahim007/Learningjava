public class array {
    public static void main(String[] args) {
        // Create an array of names
        String[] friends = {"Ali", "Sara", "Mohammad", "Ibrahim"};

        // Print all the names one by one
        System.out.println("Here are my friends:");
        for (int i = 0; i < friends.length; i++) {
            System.out.println("Friend " + i + ": " + friends[i]);
        }

        // Print a specific name (slot 2)
        System.out.println("The friend in slot 2 is: " + friends[2]);
    }
}
