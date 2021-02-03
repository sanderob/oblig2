import java.util.Scanner;

public class UserInput {


    Scanner sc = new Scanner(System.in);
    Boolean correctInput;


    public int getInteger() {
        String string;
        int integer = 0;
        correctInput = false;
        while (!correctInput) {
            string = sc.nextLine();
            correctInput = true;
            try {
                integer = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("The member number needs to be a positive number");
                correctInput = false;
            }
        }

        return integer;
    }

    public String getString() {
        String string = sc.nextLine();
        return string;
    }


}
