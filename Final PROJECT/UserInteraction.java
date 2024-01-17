import java.util.Scanner;

public class UserInteraction {
    

    Scanner keyboard;

    public UserInteraction() {

        keyboard = new Scanner(System.in);
    }

    public int getOption() {

        while(true){

            String userInput = keyboard.nextLine();

            try {
                int userInt = Integer.parseInt(userInput);

                // if 0 <= userInt <= 10
                if (userInt >= 0 && userInt <= 10) {
                    return userInt; //returns double of Price
                } else {
                    System.out.println("Invalid Input. Please input a POSITIVE INTEGER, E.g '4','3'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please input an INTEGER, E.g '4','3' ");
            }
        }
    }



    



}

