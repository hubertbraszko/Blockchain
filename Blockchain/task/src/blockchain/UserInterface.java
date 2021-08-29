package blockchain;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    public static int getNumOfZeros(){

        System.out.print("Enter how many zeros the hash must start with: ");
        int numOfZeros = scanner.nextInt();
        System.out.println();

        return numOfZeros;

    }

}
