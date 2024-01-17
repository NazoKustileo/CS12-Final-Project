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



        //Recalls from teh top if they want to

        

   }
}