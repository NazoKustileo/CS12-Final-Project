import java.lang.Math;

public class Operations {


    // gives result of baseNumber raised to the power
    public double raiseToPower(double baseNumber, double power){

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
    public int calcFactorial(int n){

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
    public double square(double baseNumber) {

        return baseNumber * baseNumber;
    }

    public double calcAreaOfACircle(double radius) {
        return Math.PI * radius * radius;
    }

    


}

