import java.util.Arrays;

class Display{

    private String line;
    private int numberOfOptions;
    private String[] options;


    //Constructor
    public Display() {
        
        line = "--------------------";
       
        options = new String[] { "Addition", "Subtraction", "Multiplication",
                                 "Division", "Sort Array", "Search Sorted Array",
                                 "Raise to Power", "Square","Factorial", 
                                 "Calc Area of Circle", "Stop",};
        numberOfOptions = options.length;
  
    }



    // Getters
    public String[] getOptions() {
        return options;
    }
    


    /////////////////////////////////////////////////
    ////              General Display
    /////////////////////////////////////////////////

    // Prints options and the number of options
    public void introduction() {
        options();
        System.out.println("Input an integer from 1 to " + numberOfOptions + ":");
    }

    // Prints options with the corresponding number
    private void options() {

        for (int i = 0; i < options.length; i++){
            System.out.println((i + 1) + "-" + options[i]);
        }

        System.out.println(line); // Print line
    }

    // Clears the Screen
    public void clearScreen(){
        System.out.print("\033[H\033[2J"); 
    }

    // Prints a breaker line
    public void printLine() {
        System.out.println(line);
    }

    // Print's press enter to Continue
    public void printEnter() {
        System.out.println("Press Enter to Continue");
    }

    // Print error for not input an option
    public void printOptionError() {
        System.out.println("Invalid Input. Please input an INTEGER from 1-" + (numberOfOptions) +
                        ", E.g '1','11' ");
    }

    // Print error for not inputing a double
    public void printDoubleError() {
        System.out.println("Invalid Input. Please input a DOUBLE, E.g '4.2','3'"); 
    }

    // Print the error for not putting the right elements in an array
    public void printArrayError(boolean isUniqueArray){

        if (isUniqueArray) { 
            System.out.println("Invalid Input. Please input an array of UNIQUE doubles.");
        }
        else {
            System.out.println("Invalid Input. Please input an array of doubles.");
        }
    }

    // Print the message when stopping the calcualtor
    public void printStopMessage(){
        System.out.println("Stopping Program...");
    }



    /////////////////////////////////////////////////
    ////                Output Display
    /////////////////////////////////////////////////

    // Grabs a variable and prints it out
    public void askForVariable(String variable) {
        System.out.println(variable + ": ");
    }

    // Prints the double
    public void printDouble(double result) {
        System.out.println("Result: " + result);
    }

    // Prints the index
    public void printIndex(double result) {
        System.out.format("Index: %.0f%n", result);
    }

    // Prints the array
    public void printArray(double[] array) {
        System.out.println("Result: " + Arrays.toString(array));
    }
}