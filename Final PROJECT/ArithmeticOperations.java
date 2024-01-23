import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.BiFunction;

public class ArithmeticOperations {

    private Map<String, BiFunction<Double, Double, Double>> twoVariableMap;
    private Map<String, Function<Double, Double>> oneVariableMap;

    // Constructor
    public ArithmeticOperations() {
        oneVariableMap = new HashMap<>();
        twoVariableMap = new HashMap<>();
        initializeMap();
    }

    // Initiliaizes the Maps so they are able to be called upon
    private void initializeMap() {

        twoVariableMap.put("Addition", this::add);
        twoVariableMap.put("Subtraction", this::subtract);
        twoVariableMap.put("Multiplication", this::multiply);
        twoVariableMap.put("Division", this::divide);
        twoVariableMap.put("Raise to Power", this:: raiseToPower);

        oneVariableMap.put("Square", this::square);
        oneVariableMap.put("Factorial", this::calcFactorial);
        oneVariableMap.put("Calc Area of Circle", this::calcAreaOfACircle);

        // Add more operations as needed
    }
    


    /////////////////////////////////////////////////
    ////      Checks the type of Arithemetic
    /////////////////////////////////////////////////

    // Check if it is a two Variable Arithmetic Opertion
    public boolean isTwoVariableArithmetic(String operationName) {

        //If they can find the name in the map then it is a two variable operation
        if (twoVariableMap.containsKey(operationName)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check if it is a single Variable Arithmetic Opertion
    public boolean isOneVariableArithmetic(String operationName) {

        //If they can find the name in the map then it is single variable operation
        if (oneVariableMap.containsKey(operationName)) {
            return true;
        }
        else {
            return false;
        }
    }



    /////////////////////////////////////////////////
    ////        Performs the Desired operation
    /////////////////////////////////////////////////

    // Performs the two Variable Opertion
    public double performTwoVariableOperation(String operationName, double a, double b) {

        double result = twoVariableMap.get(operationName).apply(a, b);
        return result; 

    }

    // Performs the one Variable Operation
    public double performOneVariableOperation(String operationName, double a) {

        double result = oneVariableMap.get(operationName).apply(a);
        return result;
    }
    

  
    /////////////////////////////////////////////////
    ////              TWO VARIABLE OPERATIONS
    /////////////////////////////////////////////////

    // Addition
    private double add(double x, double y) {
        return x + y;
    }

    // Subtraction
    private double subtract(double x, double y) {
        return x - y;
    }

    // Multiplication
    private double multiply(double x, double y) {
        return x * y;
    }

    // Division
    private double divide(double x, double y) {
        return x / y;
    }

    // Raises number to the power
    private double raiseToPower(double baseNumber, double power){

        if (power == 0){
            return 1;
        }
        else{
            return baseNumber * raiseToPower(baseNumber, power - 1);
            // Decreasing the power by 1 since the power is the amount of times it needs to multiply
            // After power is 0, it unwinds multipying n by n 
            // until we are at the first call of this method, returning the result
        }
    }



    /////////////////////////////////////////////////
    ////        SINGLE VARIABLE OPERATIONS
    /////////////////////////////////////////////////

    // Gives Factorial of n (Recursion)
    private double calcFactorial(double n) {

        // If it is a negative or 0 then returns NaN
        if(n <= 0){
            return Double.NaN;
        }

        // Actual Factorial part
        if(n == 1) {
            return 1;
        }
        else { 
            return n * calcFactorial(n - 1); 
            // Does the recursion of Q2 with n - 1 and 
            // unwinding to multiply each n - 1 with the previous 
            // until we are at  the first call of this method, returning the factorial
        }
    }

    // Squares the number
    private double square(double baseNumber) {
        return baseNumber * baseNumber;
    }

    // Calculate area of Circle
    private double calcAreaOfACircle(double radius) {
        return Math.PI * radius * radius;
    }
}