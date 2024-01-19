public class Calculator {

   private Display display;
   private Operations operations;
   private UserInteraction userInput;


   //Construcotr
   public Calculator() {
        display = new Display();
        operations = new Operations();
        userInput = new UserInteraction();
   }
   
   
   public void run() {

     // Introduction Section to display all the options

     display.introduction();

     //Takes user input and uses the desired function
     //Outputs answer

     int userInt = userInput.getOption();

     // Take the userInt and pick a corresponding method for it
    
     double result = getDouble(userInt);

     // Display result
     display.printDouble(result);
     
   }



   private double getResult (int actionNumber) {

     String[] options = display.getOptions();

     String selectedOperation = options[actionNumber - 1];

     //Get Variables 
     display.askForVariable("A"); // Ask for the Variable
     double a = userInput.getVariable();

     display.askForVariable("B"); // Ask for the Variable
     double b = userInput.getVariable();

     // Should return the answer
      return operations.getOperation(selectedOperation, a, b);
    }

    private String[] getSortedArray(int actionNumber) {

      String[] options = display.getOptions();

      String selectedOperation = options[actionNumber - 1];

      display.askForVariable("Array");

      String[] arr = userInput.getArray();

      return operations.performArrayOperation(selectedOperation, arr);
    }
}


