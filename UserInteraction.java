import java.util.Scanner;
import java.awt.event.KeyEvent;

public class UserInteraction {
    

    Scanner keyboard;
    Display display;

    public UserInteraction() {

        keyboard = new Scanner(System.in);
        display = new Display();

    }

    public void runStop(KeyEvent keyPressed) {

        if (keyPressed.getKeyCode() == KeyEvent.VK_A) {
            if (keyPressed.isControlDown()) {
                System.out.println("Ctrl+A is pressed.");
                System.out.println("Program Stopping...");
            }
        }

    }


    public int getOption() {

        while(true) {

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
                System.out.println("Invalid Input. Please input an INTEGER, E.g '4','3' "); // PUT THIS INTO DISPLAY ANDIWIDAWDWA REMINDR REMINDER
            }
        }
    }

    // Get a variable //Do checking
    public double getVariable() {

        String variableString; // Get Variable
        variableString = keyboard.nextLine();
        variableString = variableString.trim(); // Remove space from front and back

        return convertStringToDouble(variableString); // Return converted String to Double
    }

    /*public String[] getArray(){

        String arrayString = keyboard.nextLine();
        arrayString = arrayString.trim(" ");

        return arrayString.split(",");
    }*/


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

