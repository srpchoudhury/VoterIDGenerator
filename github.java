//AgeLimitExceptions
class AgeLimitException extends Exception{

    AgeLimitException(){
        super();
    }
    AgeLimitException(String msg){
        super(msg);
    }
}

// Voter.java
public class Voter {
    private int age;
    private String name;

    public void setAge(int age)
            throws AgeLimitException {
        if (age < 18 || age > 120)
            throw new AgeLimitException("You are not eligible for voting");
        this.age = age;

    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

// VoterRegOffice
import java.util.Scanner;
import java.util.InputMismatchException;

public class VoterRegOffice {
    public static void main(String... args) {
        Scanner scn = new Scanner(System.in);

        while (true) {
            Voter v = new Voter();

            try {
                System.out.print("\nEnter Name: ");
                v.setName(scn.nextLine());

                System.out.print("Enter age: ");
                v.setAge(scn.nextInt());

                System.out.println("Hi " + v.getName() + " your details are saved");
                System.out.println("Please collect your voter card");
                System.out.println("from ESEVE after 30 days");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please pass only integer");
            } catch (AgeLimitException e) {
                System.out.println(e.getMessage());
            }
            scn.nextLine();

        }

    }

}/* Thank you........ */
