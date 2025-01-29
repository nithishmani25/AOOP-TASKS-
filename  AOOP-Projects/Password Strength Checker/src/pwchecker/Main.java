package pwchecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Password Strength Checker!");
        System.out.print("Enter a password to check its strength: ");
        
        String password = scanner.nextLine();
        PasswordStrengthChecker.Strength strength = PasswordStrengthChecker.checkStrength(password);
        
        System.out.println("Password Strength: " + strength);
        
        scanner.close();
    }
}
