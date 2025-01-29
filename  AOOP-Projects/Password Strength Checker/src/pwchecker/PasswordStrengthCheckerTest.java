package pwchecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthCheckerTest {

    @Test
    void testWeakPasswords() {
        assertEquals(PasswordStrengthChecker.Strength.WEAK, PasswordStrengthChecker.checkStrength("abc"));
        assertEquals(PasswordStrengthChecker.Strength.WEAK, PasswordStrengthChecker.checkStrength("12345"));
        assertEquals(PasswordStrengthChecker.Strength.WEAK, PasswordStrengthChecker.checkStrength("abcdef"));
    }

    @Test
    void testMediumPasswords() {
        assertEquals(PasswordStrengthChecker.Strength.MEDIUM, PasswordStrengthChecker.checkStrength("Abcdef"));
        assertEquals(PasswordStrengthChecker.Strength.MEDIUM, PasswordStrengthChecker.checkStrength("1234!@"));
        assertEquals(PasswordStrengthChecker.Strength.MEDIUM, PasswordStrengthChecker.checkStrength("AB12cd"));
    }

    @Test
    void testStrongPasswords() {
        assertEquals(PasswordStrengthChecker.Strength.STRONG, PasswordStrengthChecker.checkStrength("A1b@C3d4"));
        assertEquals(PasswordStrengthChecker.Strength.STRONG, PasswordStrengthChecker.checkStrength("Xyz!2345"));
        assertEquals(PasswordStrengthChecker.Strength.STRONG, PasswordStrengthChecker.checkStrength("Qwerty1!"));
    }

    @Test
    void testInvalidInputs() {
        assertEquals(PasswordStrengthChecker.Strength.INVALID, PasswordStrengthChecker.checkStrength(null));
        assertEquals(PasswordStrengthChecker.Strength.INVALID, PasswordStrengthChecker.checkStrength(""));
        assertEquals(PasswordStrengthChecker.Strength.INVALID, PasswordStrengthChecker.checkStrength("    "));
    }
}
