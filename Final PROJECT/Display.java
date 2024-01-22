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
                                 "Calc Area of Circle", "Information"};
        numberOfOptions = options.length;
  
    }

    // Getter
    public String[] getOptions() {
        return options;
    }



    private void options() {

        // Print options with the corresponding number in the front
        for (int i = 0; i < options.length; i++){
            System.out.println((i + 1) + "-" + options[i]);
        }

        System.out.println(line); // Print line
    }


    // Prints introduction
    public void introduction() {
        options();
        System.out.println("Input a integer from 1 to " + numberOfOptions + ":");
    }


    public void askForVariable(String variable) {
        System.out.println(variable + ": ");
    }

    public void printDouble(double result) {
        System.out.println("Result: " + result);
    }

    public void printIndex(double result) {
        System.out.format("Index: %.0f%n", result);
    }
    
    public void printArray(double[] array) {
        System.out.println(Arrays.toString(array));
    }

    public void printLine() {
        System.out.println(line);
    }

    public void printEnter() {
        System.out.println("Press Enter to Continue");
    }
    
}