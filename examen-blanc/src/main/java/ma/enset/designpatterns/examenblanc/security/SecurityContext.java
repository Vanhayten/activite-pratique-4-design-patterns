package ma.enset.designpatterns.examenblanc.security;

public class SecurityContext {
    private static String currentUserRole = "GUEST";
    private static String currentUsername = "";

    public static void authenticate(String username, String role) {
        currentUsername = username;
        currentUserRole = role;
    }

    public static boolean hasRole(String role) {
        return currentUserRole.equals(role);
    }
    
    public static String getCurrentUserRole() {
        return currentUserRole;
    }
}
