import java.util.Scanner;

public class UserInteraction {
    

    Scanner keyboard;
    Display display;

    public UserInteraction() {

        keyboard = new Scanner(System.in);
        display = new Display();

    }

    public int getOption() {

        while(true) {

            
            // Get input from user
            String userInput = keyboard.nextLine();
            userInput = userInput.trim();

            try {
                int userInt = Integer.parseInt(userInput);

                // if 0 <= userInt <= 10
                if (userInt >= 0 && userInt <= 10) {
                    return userInt; //returns double
                } else {
                    System.out.println("Invalid Input. Please input a POSITIVE INTEGER, E.g '4','3'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please input an INTEGER, E.g '4','3' "); // PUT THIS INTO DISPLAY ANDIWIDAWDWA REMINDR REMINDER
            }
        }
    }

    // Get a variable //Do checking
    public double getVariable() {

        while(true) {

            // Get input from user
            String variableString = keyboard.nextLine();
            variableString = variableString.trim(); // Remove space from front and back

            try {
                double variableDouble = Double.parseDouble(variableString);

                // if 0 <= userInt <= 10
                if (variableDouble >= 0 && variableDouble <= 10) {
                    return convertStringToDouble(variableString); // Return converted String to Double
                } else {
                    System.out.println("Invalid Input. Please input a POSITIVE INTEGER, E.g '4','3'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please input an INTEGER, E.g '4','3' "); // PUT THIS INTO DISPLAY ANDIWIDAWDWA REMINDR REMINDER
            }
        }

        
    }

    // Get an array
    public String[] getArray(){

        while(true) {

            // Get input from user
            String userListString = keyboard.nextLine();
            userListString = userListString.trim(); // Remove space from front and back

            String[] userListArray = userListString.split(" ");

            boolean numberFound = false;

            for (String element: userListArray) {

                // Checks if the element isnt a letter
                if (!element.contains("[a-zA-Z]+")) {
                    System.out.println("Invalid Input. Please input an Array of Strings, E.g 'Thing','Thing1' "); // PUT THIS INTO DISPLAY ANDIWIDAWDWA REMINDR REMINDER
                    break; // Don't need to check the rest if there is a number
                } 
                else {
                    numberFound = false;
                }
            }

            // Return list if there is no numbers
            if (!numberFound) {
                return userListArray; //return Array
            }
        }
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

    
    /* 
          // User chooses BINARY SEARCH
        if(choice == 1) {

            // Get the array
            System.out.println("Enter Array: ");
            Scanner array = new Scanner(System.in);
            int size = array.nextInt();
            double[] searchArr = new double[size];

            // Get the item to search
            System.out.println("Enter Item to Search: ");
            Scanner item = new Scanner(System.in);
            double searchItem = item.nextDouble();

            // Checks if the array is sorted to continue
            boolean isSorted = true;
            for(int i = 0; i < size - 1; i++){
                if(searchArr[i] > searchArr[i + 1]){
                    isSorted = false;
                    System.out.println("Error; The array you've provided is not sorted");
                    return ;
                }
            }
            // Performs the binary search
            operation.binarySearch(searchArr, searchItem);
        }


        // User chooses MERGE SORT
        if(choice == 2){
            System.out.println("Enter array to sort: "); // array elements are separated by (,)
            Scanner getArray = new Scanner(System.in);
            String arrInput = getArray.nextLine();
            String[] array = arrInput.split(",");
            // Performs the merge sort
            operation.mergeSort(array);
        }

     */


    
}

