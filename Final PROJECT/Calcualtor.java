import java.util.Scanner;

class Calculator {

   private Display display;
   private Operations operations;
   private UserInteraction userInput;

   private Scanner keyboard;
   

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

     double result = performAction(userInt);


     //Recalls from teh top if they want to

     display.printResult(result);

     

   }

   private double performAction(int actionNumber) {

     String[] options = display.getOptions();

     String selectedOperation = options[actionNumber - 1];

     // Gets variables in the form (a, b) i think you can do this?
     double a, b = userInput.getVariables();


     // Should do the operation
     double result = operationMap.getOperation(selectedOperation, a, b);

     
     }

   }







   
}