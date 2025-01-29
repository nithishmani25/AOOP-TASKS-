package pwchecker;

public class PasswordStrengthChecker {

    public enum Strength {
        WEAK, MEDIUM, STRONG, INVALID
    }

    public static Strength checkStrength(String password) {
        if (password == null || password.trim().isEmpty()) { // Fix for Java 8
            return Strength.INVALID;
        }

        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }

        if (length >= 8 && hasLower && hasUpper && hasDigit && hasSpecial) {
            return Strength.STRONG;
        } else if (length >= 6 && ((hasLower && hasUpper) || (hasDigit && hasSpecial))) {
            return Strength.MEDIUM;
        } else {
            return Strength.WEAK;
        }
    }
}
