import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Operations {

    private Display display;
    // Maybe switch String to int depending on things
    private Map<String, DoubleBinaryOperator> operationMap;

    public Operations() {
        display = new Display();
        operationMap = new HashMap<>();
        initializeOperationsMap();
    }

    private void initializeOperationsMap() {

        // we use this::method in order to reference it, instaed of like using it? when using method()
        operationMap.put("Addition", this::addition);
        operationMap.put("Subtraction", this::subtraction);
        operationMap.put("Multiplication", this::multiplication);
    
    }

    // Getters
    

    //Should get the result?
    public double getOperation(String operationName, double aVariable, double bVariable) {

        // Check if the operation exists here for safety precossion, remove if not needed
        if (operationMap.containsKey(operationName)) {

            // Get the operation from the map and apply it to the operands
            return operationMap.get(operationName).applyAsDouble(aVariable, bVariable);
        }
        else {
            throw new IllegalArgumentException("Unknown operation: " + operationName);
        }
       
    }


    private double addition(double a, double b) {
        return a + b;
    }


    // gives result of baseNumber raised to the power
    private double raiseToPower(double baseNumber, double power){

        if (power == 0){
            return 1;
        }
        else{
            return baseNumber * raiseToPower(baseNumber, power - 1);
            // Decreasing the power by 1 since the power is the amount of times it needs to multiply
            // After power is 0, it unwinds multipying n by n 
            // until we are at the the first call of this method, returning the result
        }
    }
    

    // Gives Factorial of n (Recursion)
    private int calcFactorial(int n){

        if(n <= 1) { // if n is a below or equal to 1
            return 1;   
        }
        else { 
            return n * calcFactorial(n - 1); 
            // Does the recursion of Q2 with n - 1 and 
            // unwinding to multiply each n - 1 with the previous 
            // until we are at the the first call of this method, returning the factorial    
        }
    }

    // Retuns with the square of number
    private double square(double baseNumber) {
        return baseNumber * baseNumber;
    }

    private double calcAreaOfACircle(double radius) {
        return Math.PI * radius * radius;
    }




    


}

