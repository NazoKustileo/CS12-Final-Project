import java.util.Scanner;

public class UserInteraction {
    

    Scanner keyboard;
    Display display;

    public UserInteraction() {

        keyboard = new Scanner(System.in);
        display = new Display();

    }

    public int getOption() {

        while(true){

            String userInput = keyboard.nextLine();

            try {
                int userInt = Integer.parseInt(userInput);

                // if 0 <= userInt <= 10
                if (userInt >= 0 && userInt <= 10) {
                    return userInt; //returns double of Price
                } else {
                    System.out.println("Invalid Input. Please input a POSITIVE INTEGER, E.g '4','3'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please input an INTEGER, E.g '4','3' ");
            }
        }
    }

    // Get the variables
    public double[] getVariables() {

        display.askForVariable("A"); //Asks for the A equations
        String AVariableString = keyboard.nextLine();
        AVariableString = AVariableString.trim(); // Remove space from front and back
        double AVariableDouble = convertStringToDouble(AVariableString); // Convert from String to Double

        display.askForVariable("B"); //Asks for the B equations
        String BVariableString = keyboard.nextLine();
        BVariableString = BVariableString.trim();
        double BVariableDouble = convertStringToDouble(AVariableString);


        // Return both variables in the form of {A, B}
        double[] twoVariables = {AVariableDouble, BVariableDouble};
        return twoVariables;

    }


    // Convert String to Double with no exceptions (Returns with negative and stuff)
    private double convertStringToDouble(String userInput) {

         //runs the code under "try" and if it can't run it then it refers to catch
         try {

            double variableDouble = Double.parseDouble(userInput);
            
            return variableDouble ; //returns double

            //"NumberFormatExcpetion" is the excpetion that is caught from converting String to num error occurs
            //"e" is the the variable that represents the exception
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please input a number, E.g '4','4.24' ");
        }

        return -1; // Outlier SHOULD NEVER HAPPEN

    }


    
}

