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
        operationMap.put("Addition", this::add);
        operationMap.put("Subtraction", this::subtract);
        operationMap.put("Multiplication", this::multiply);
        operationMap.put("Divison", this::divide);
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

    private void merge(String[]result, String[]left, String[]right){
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1].compareToIgnoreCase(right[i1]) < 0)) {  //try i2 if it does not work
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }


    // Addition
    private double add(double x, double y) {
        return x + y;
    }

    // Subtraction
    public double subtract(double x, double y) {
        return x - y;
    }

    // Multiplication
    public double multiply(double x, double y) {

        if (x == 0) {
            return 0;
        }
        return x * y;
    }

    // Division
    public double divide(double x, double y) {
        if (x == 0) {
            return 1;
        }
        return x / y;
    }


    // Binary Search
    public double binarySearch(double[] searchArr, double searchItem) {

        int start = 0;
        int end = searchArr.length - 1;
        int mid = -1;
        int prevMid;

        while (true) {
            prevMid = mid;
            mid = (start + end) / 2;

            if (searchArr[mid] == searchItem) {
                return mid;
            } else if (searchItem > searchArr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (prevMid == mid) {
                return -1;
            }
        }
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

    
    // Display PI
    private void PI() {
        System.out.println("3.1415926535");   
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

