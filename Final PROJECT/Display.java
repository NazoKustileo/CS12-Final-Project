
class Display{

    String line;
    String addition;
    String subtraction
    String multiplication;
    String division;
    String sortList;
    String searchSortedList;
    String power;
    String square;
    String factorial;
    String information;

    public display() {
        
        line = "--------------------";
        addition = "1-Addition";
        subtraction = "2-Subtraction";
        multiplcation = "3-Multiplication";
        division = "4-Division";
        sortList = "5-Sort List";
        searchSortedList = "6-Search Sorted List";
        power = "7-Raise to Power";
        square = "8-Square";
        factorial = "9-Factorial"
        information = "10-information"
  
    }


    public displayOptions() {

        System.out.println(addition + 
                           subtraction +
                           multiplcation +
                           divison +
                           sortList +
                           searchSortedList +
                           power +
                           square + 
                           factorial +
                           information)
    }

    

    
}