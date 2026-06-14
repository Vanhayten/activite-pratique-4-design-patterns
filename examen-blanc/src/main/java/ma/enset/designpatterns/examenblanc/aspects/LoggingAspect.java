package ma.enset.designpatterns.examenblanc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    // On intercepte toutes les méthodes des classes du package model
    @Pointcut("execution(* ma.enset.designpatterns.examenblanc.model..*(..))")
    public void methodesModel() {}

    @Around("methodesModel()")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("[LOG-AOP] Entrée dans la méthode : " + joinPoint.getSignature().toShortString());
        
        Object result = joinPoint.proceed();
        
        long end = System.currentTimeMillis();
        System.out.println("[LOG-AOP] Sortie de la méthode : " + joinPoint.getSignature().toShortString() + " | Durée: " + (end - start) + "ms");
        return result;
    }
}
