public class Calculator {

  private Display display;
  private ArithmeticOperations arithmeticOperations;
  private ArrayOperations arrayOperations;
  private UserInteraction userInput;
  private String selectedOperation;


  //Construcotr
  public Calculator() {
      display = new Display();
      arithmeticOperations = new ArithmeticOperations();
      arrayOperations = new ArrayOperations();
      userInput = new UserInteraction();
      selectedOperation = null;
  }
  


  ////////////////////////////////////////////////////////
  ////                  MAIN METHODS
  ////////////////////////////////////////////////////////

  // Runs the Calculator
  public void run() {

    while (true) {
      
      // Introduction Section to display all the options
      display.introduction();

      //Takes user input
      int userInt = userInput.getOption();

      // Take the userInt and perform the calculactor
      performAction(userInt);

      // Press Enter to Reset the loop
      userInput.pressEnterToContinue(); 

    }
  }


  // Determines which type of Operation to use
  private void performAction(int actionNumber) {

    String[] options = display.getOptions(); // get the list of options

    selectedOperation = options[actionNumber - 1]; // Get name of operation


    // Checks if it is a Two Variable Arithmetic
    if (arithmeticOperations.isTwoVariableArithmetic(selectedOperation)) {
      double result = getTwoVariableResult(actionNumber);
      display.printDouble(result);
    } 
    else if(arithmeticOperations.isOneVariableArithmetic(selectedOperation))
    {
      double result = getOneVariableResult(actionNumber);
      display.printDouble(result);
    }
    // Checks if it a Sort Operation
    else if (arrayOperations.isSortOperation(selectedOperation)) {
      double[] resultArray = getSortedArray(actionNumber);
      display.printArray(resultArray);
    }
    // Checks if it a Search Operation
    else if (arrayOperations.isSearchOperation(selectedOperation)){
      double index = getElementFromSortedArray(actionNumber);
      display.printIndex(index);
    }
    // Runs the stop program, since it is the last option
    else {
      stopProgram();
    }
  }



  ////////////////////////////////////////////////////////
  ////  Perform the desired action, returning the result
  ////////////////////////////////////////////////////////

  // Used for two variables
  private double getTwoVariableResult (int actionNumber) {

    //Get Variables 
    double a = userInput.getVariable("A");
    double b = userInput.getVariable("B");

    // Should return the answer
    return arithmeticOperations.performTwoVariableOperation(selectedOperation, a, b);
  }


  // Used for single variable
  private double getOneVariableResult (int actionNumber) {

    //Get Variables 
    double a = userInput.getVariable("A");

    // Should return the answer
    return arithmeticOperations.performOneVariableOperation(selectedOperation, a);
  }


  // Gets the sorted array 
  private double[] getSortedArray(int actionNumber) {

    double[] arr = userInput.getDoubleArray(false); // Get the double array

    return arrayOperations.performSortOperation(selectedOperation, arr); //return the sorted array
  }


  // Gets the element from the sorted array, returning the index of element
  private double getElementFromSortedArray(int actionNumber) {

    double[] arr = userInput.getDoubleArray(true); // Get a Double Array with no replicates

    arr = arrayOperations.performSortOperation("Sort Array", arr); // Sort the array

    display.printArray(arr); // Display the array 

    double searchItem = userInput.getVariable("Element"); // Now get the variable they want to find

    return arrayOperations.performSearchArray(selectedOperation, arr, searchItem); // return the index
  }


  // Method used to stop the program
  private void stopProgram() {
    System.out.println("Program Stopping...");
    System.exit(0);  // Exit the program if 'stop' is entered
  }
}


