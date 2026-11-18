package net.zoungrana.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {

    Logger logger=Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(net.zoungrana.aspects.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1=System.currentTimeMillis();
        logger.info("------------------------------------------------------------------------");
        logger.info("From logging aspects... Before "+proceedingJoinPoint.getSignature());
        Object result=proceedingJoinPoint.proceed();
        logger.info("From logging aspects... After "+proceedingJoinPoint.getSignature());
        long t2=System.currentTimeMillis();
        logger.info("Duration: "+(t2-t1)+" ms");
        logger.info("------------------------------------------------------------------------");
        return result;

    }

}
