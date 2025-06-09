public class PasswordChecker {

    public static String checkStrength(String password) {
        int length = password.length();
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        if (length < 8) return "❌ Too short (Min 8 characters)";
        if (!hasUpper) return "❌ Add at least 1 uppercase letter";
        if (!hasLower) return "❌ Add at least 1 lowercase letter";
        if (!hasDigit) return "❌ Add at least 1 number";
        if (!hasSpecial) return "❌ Add at least 1 special character";

        return "✅ Strong password!";
    }
}
