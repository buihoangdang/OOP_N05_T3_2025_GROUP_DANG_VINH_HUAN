public class testUser {
    public static void main(String[] args) {
        // Creating a User object
        User user1 = new User("John Doe", 25, "johndoe@example.com");

        // Accessing user information using getters
        System.out.println("Name: " + user1.getName());
        System.out.println("Age: " + user1.getAge());
        System.out.println("Email: " + user1.getEmail());

        // Changing user information using setters
        user1.setName("Jane Doe");
        user1.setAge(28);
        user1.setEmail("janedoe@example.com");

        // Display updated information
        System.out.println("\nUpdated User Info:");
        System.out.println("Name: " + user1.getName());
        System.out.println("Age: " + user1.getAge());
        System.out.println("Email: " + user1.getEmail());
    }
}
