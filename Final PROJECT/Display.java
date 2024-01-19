class Display{

    private String line;
    private int numberOfOptions;
    private String[] options;

    //Constructor
    public Display() {
        
        line = "--------------------";
       
        options = new String[] { "Addition", "Subtraction", "Multiplication",
                                 "Division", "Sort List", "Search Sorted List",
                                 "Raise to Power", "Square","Factorial",
                                 "Information"};
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
        System.out.println(result);
    }
    
    public void printArray(String[] array) {
        System.out.println(array);
    }


    
}