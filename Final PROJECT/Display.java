import java.lang.StringBuilder;

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
        numberOfOptions = options.length - 1;
  
    }






    private void displayOptions() {

        //Using this to just add onto the exisiting string instead
        //of having multiple instances of new Strings
        StringBuilder optionsStringBuilder = new StringBuilder();

        for (int i = 0; i < options.length; i++){

            optionsStringBuilder.append((i + 1) + "-" + options[i]);

            // Used so the last instance doesnt have a space under it
            // It's up to us if we want there to be a space or not
            if (i < options.length - 1) {
                optionsStringBuilder.append("\n");
            }
        }

        System.out.println(optionsStringBuilder.toString());
        System.out.println(line);
       

    }

    public void introduction() {
        
        displayOptions();
        System.out.println("Input a integer from 1 to " + numberOfOptions + ":");
    }

    

    
}