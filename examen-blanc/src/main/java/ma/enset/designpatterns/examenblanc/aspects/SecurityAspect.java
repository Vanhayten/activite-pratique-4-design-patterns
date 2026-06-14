package ma.enset.designpatterns.examenblanc.aspects;

import ma.enset.designpatterns.examenblanc.security.SecuredBy;
import ma.enset.designpatterns.examenblanc.security.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityAspect {

    @Around("@annotation(securedBy)")
    public Object secureAccess(ProceedingJoinPoint joinPoint, SecuredBy securedBy) throws Throwable {
        String[] requiredRoles = securedBy.roles();
        String currentRole = SecurityContext.getCurrentUserRole();
        
        boolean authorized = false;
        for (String role : requiredRoles) {
            if (role.equals(currentRole)) {
                authorized = true;
                break;
            }
        }
        
        if (authorized) {
            return joinPoint.proceed();
        } else {
            System.err.println("[SECURITY-AOP] Accès refusé à la méthode " + joinPoint.getSignature().getName() + " pour le rôle " + currentRole);
            return null;
        }
    }
}
