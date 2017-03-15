package cn.jesse.aop;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jesse on 14/03/2017.
 */
@Aspect
public class ActivityAOP {
    private static final String TAG = ActivityAOP.class.getSimpleName();

    /**
     * activity life circle point cut
     */
    @Pointcut("execution(* android.app.Activity.on**(..))")
    public void activityLifeCircle() {
        //unused
    }

    @Before("activityLifeCircle()")
    public void activityLifeCircleTrigered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d(TAG, targetClassName + " " + signatureName);
    }
}
