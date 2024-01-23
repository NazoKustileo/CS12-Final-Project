import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInteraction {
    
    Scanner keyboard;
    Display display;

    
    // Constructor
    public UserInteraction() {

        keyboard = new Scanner(System.in);
        display = new Display();

}



    /////////////////////////////////////////////////
    ////           Get User Input's
    /////////////////////////////////////////////////

    // If they press enter or smth then it'll go through
    public void pressEnterToContinue() {
    
        display.printEnter();
        
        try {
            System.in.read();
        } catch(Exception e) { }
    }

    // Get's the users number for options such as addition, subtraction, etc
    public int getOption() {

        int lengthOfOptions = display.getOptions().length; //Get the length of options

        while(true) {

            try {

                // Get input from user
                int userInt = keyboard.nextInt();
           
                // if 0 <= userInt <= lengthOfOptions
                if (userInt > 0 && userInt <= lengthOfOptions) {
                    return userInt; //returns double
                } else {
                    display.printOptionError(); 
                }
            } catch (java.util.InputMismatchException e) {
                
                //Eat the previous line
                keyboard.nextLine();

                display.printOptionError(); 

                display.printLine();
            }
        }
    }

    // Get's the variable
    public double getVariable(String displayVariable) {

        while(true) {

            display.askForVariable(displayVariable);
    
            try {
                double variableDouble = keyboard.nextDouble(); // Get Double

                return variableDouble; // Return the double if they put one
             
            } catch (java.util.InputMismatchException e) {

                keyboard.nextLine(); //Eat the previous line

                display.printDoubleError();

                display.printLine();
                
            }
        }

        
    }

    // Get an array of doubles
    public double[] getDoubleArray(boolean noDuplicateNumbers) {

        // Eat the previous line
        keyboard.nextLine();
    
        while (true) {

            display.askForVariable("Array"); // Ask for the array

            // Get input from the user
            String userListString = keyboard.nextLine();
            userListString = userListString.trim(); // Remove space from front and back
            
            String[] userListArray = userListString.split("[,\\s]+"); // Split by commas and/or spaces

            // Make new array so we can return double[]
            double[] resultArray = new double[userListArray.length];
            
            // Set of unique Numbers, used so we won't have duplicates if we don't want any
            Set<Double> uniqueElements = new HashSet<>();
        
            boolean validInput = true; // Set value

            // Putting each element into the new array
            for (int i = 0; i < userListArray.length; i++) {

                try {
                    // Try to parse each element as a double
                    double element = Double.parseDouble(userListArray[i]);

                    //If noDuplicateNumbers = true and this is not a unique element, then it will run
                    if (noDuplicateNumbers && !uniqueElements.add(element)) {
                        validInput = false;
                        break;
                    }

                    resultArray[i] = element; // Add it to the resultArray if everything above goes through
                    
                } catch (NumberFormatException e) {
                    // If parsing fails, set validInput to false
                    validInput = false;
                    break;
                }
            }


            // Return the array if input is valid
            if (validInput) {
                return resultArray;
            } 
            // If not valid input
            else {
                display.printArrayError(noDuplicateNumbers);

                display.printLine();
            } 
        }
    } 
}

