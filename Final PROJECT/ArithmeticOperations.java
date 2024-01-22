import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ArithmeticOperations {

    private Map<String, BiFunction<Double, Double, Double>> operationMap;


    public ArithmeticOperations() {
        operationMap = new HashMap<>();
        initializeMap();
    }


    // Initiliaizes the Maps so they are able to be called upon
    private void initializeMap() {

        operationMap.put("Addition", this::add);
        operationMap.put("Subtraction", this::subtract);
        operationMap.put("Multiplication", this::multiply);
        operationMap.put("Division", this::divide);
        operationMap.put("Raise to Power", this:: raiseToPower);

        operationMap.put("Square", this::square);
        operationMap.put("Factorial", this::calcFactorial);
        operationMap.put("CalcAreaOfCircle", this::calcAreaOfACircle);

        // Add more operations as needed
    }

    // Check if it is an Arithmetic Opertion
    public boolean isArithmetic(String operationName) {

        //If they can find the name in the map then it is arithmetic
        if (operationMap.containsKey(operationName)) {
            return true;
        }
        else {
            return false;
        }
    }

    
    // performs the Arithmetic operation that is needed
    public double performArithmeticOperation(String operationName, double... args) {

        // Check if the operation is known
        if (operationMap.containsKey(operationName)) {

            // Find out if there is two arguments or only 1
            double secondArgument;
            if (args.length > 1) { // Checks if there is more than 1 argument (meaning there is 2)
                secondArgument = args[1];
            } else { // If there is only 1 argument then its just 0
                secondArgument = 0;
            }

            // Uses the operation Name to get the method and applies the args returning the result
            return operationMap.get(operationName).apply(args[0], secondArgument);

        } else {
            // Throw an exception for unknown operations
            throw new IllegalArgumentException("Unknown operation: " + operationName);
        }
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

        if (x == 0) {
            return 0;
        }
        return x * y;
    }

    // Division
    private double divide(double x, double y) {
        if (x == 0) {
            return 1;
        }
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
    private double calcFactorial(double n, double dummy){

        if(n <= 1) { // if n is a below or equal to 1
            return 1;   
        }
        else { 
            return n * calcFactorial(n - 1, dummy); 
            // Does the recursion of Q2 with n - 1 and 
            // unwinding to multiply each n - 1 with the previous 
            // until we are at  the first call of this method, returning the factorial
        }
    }

    // Squares the number
    private double square(double baseNumber, double dummy) {
        return baseNumber * baseNumber;
    }

    // Calculate area of Circle
    private double calcAreaOfACircle(double radius, double dummy) {
        return Math.PI * radius * radius;
    }
}