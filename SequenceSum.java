import java.util.Scanner;

/**
 * SequenceSum
 */
public class SequenceSum {

    public static void main(String[] args) {
      System.out.println("Enter the last Sequencing Number: ");
      Scanner input = new Scanner(System.in);
      int lastSequencingNumber = input.nextInt();
      int sum = lastSequencingNumber*(lastSequencingNumber+1)/2;
      System.out.println("The sum of Numbers from 1 to " + lastSequencingNumber + " is: " + sum);
    }
}