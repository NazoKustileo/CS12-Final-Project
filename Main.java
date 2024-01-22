import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        UserInteraction interact = new UserInteraction();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            calculator.run();

            // Check for user input
            if (scanner.hasNextLine()) {
                String userInput = scanner.nextLine();

                // Stops program on Ctrl+A
                if (userInput.equalsIgnoreCase("\u0001")) // (\u0001) is a unicode for Ctrl-A
                {
                    System.out.println("Ctrl+A is pressed.");
                    System.out.println("Program Stopping...");
                    break;  // Exit the loop to stop the program
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}
