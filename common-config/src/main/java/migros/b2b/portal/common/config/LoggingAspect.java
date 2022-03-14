package migros.b2b.portal.common.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);

    @After("execution(* migros.b2b.portal.order.repositories.*.*(..))")
    public void logGetOrder(JoinPoint point) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOG.info(point.getSignature().getName() + " called by " + auth.getName() + " at " + new Date());
    }

    @AfterThrowing(value="execution(* migros.b2b.portal.order.controllers.*.*(..))",
            throwing="e")
    public void doRecoveryActions(JoinPoint point, Exception e) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOG.info(point.getSignature().getName() + " called by " + auth.getName() + " at " + new Date() + " and threw " + e.getMessage());
    }


}
