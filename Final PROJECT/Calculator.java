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

      String[] options = display.getOptions(); // could maybe be initilized

      selectedOperation = options[actionNumber - 1]; // Get name of operation

  
      // Checks if it is an Arithmetic Operation
      if (arithmeticOperations.isArithmetic(selectedOperation)) {
        
        double result = getResult(actionNumber);
        display.printDouble(result);
      } 

      else if (arrayOperations.isSortOperation(selectedOperation))
      {
        double[] resultArray = getSortedArray(actionNumber);
        display.printArray(resultArray);
      }

      else if (arrayOperations.isSearchOperation(selectedOperation)){
        double index = getElementFromSortedArray(actionNumber);
        display.printIndex(index);
      }
      else {
        stopProgram();
      }
    
   }



   private double getResult (int actionNumber) {

     //Get Variables 
     double a = userInput.getVariable("A");

     double b = userInput.getVariable("B");

     // Should return the answer
      return arithmeticOperations.performArithmeticOperation(selectedOperation, a, b);
    }



    
    private double[] getSortedArray(int actionNumber) {

      display.askForVariable("Array");

      double[] arr = userInput.getDoubleArray(false);

      return arrayOperations.performSortOperation(selectedOperation, arr);
    }

    private double getElementFromSortedArray(int actionNumber) {

      display.askForVariable("Array");

      double[] arr = userInput.getDoubleArray(true);

      arr = arrayOperations.performSortOperation("Sort Array", arr);

      display.printArray(arr);

      double searchItem = userInput.getVariable("Element: ");

      return arrayOperations.performSearchArray(selectedOperation, arr, searchItem);
    }

       
    private void stopProgram() {
      System.out.println("Program Stopping...");
      System.exit(0);  // Exit the program if 'stop' is entered
  }
}


