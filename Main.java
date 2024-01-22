import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            calculator.run();

            // Check for user input
            String userInput = scanner.nextLine();

            // Assuming you want to stop on 'stop'
            if (userInput.equalsIgnoreCase("stop")) {
                System.out.println("'stop' is entered.");
                System.out.println("Program Stopping...");
                break;  // Exit the loop to stop the program
            }
        }

        // Close the scanner
        scanner.close();
    }
}