package com.ayp.sms.log;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerAspect {

    private static final Logger LOGGER =
        Logger.getLogger(SMSLogger.class.getName());

    @Around ("execution(public * com.ayp.sms.service ..*.*(..))")
    public Object profileServiceMethods (ProceedingJoinPoint thisJoinPoint)
        throws Throwable {
        return profileMethods(thisJoinPoint);
    }

    public Object profileMethods (ProceedingJoinPoint thisJoinPoint)
        throws Throwable {

        StringBuffer logMessage = new StringBuffer();
        logMessage.append(thisJoinPoint.getSignature().getName());

        logMessage.append(" STARTTIME: ");
        long start = System.currentTimeMillis();
        logMessage.append(start);
        logMessage.append(" ENDTIME: ");
        Object output = thisJoinPoint.proceed();
        long   end    = System.currentTimeMillis();
        logMessage.append(end);
        // Calculate method's elapsed time
        logMessage.append(" TOTALTIME: ");
        logMessage.append(end - start + "ms");
        LOGGER.info(
            "Profiling : " + thisJoinPoint.getTarget().getClass().getName() +
            "." + logMessage.toString());

        return output;
    }

}
