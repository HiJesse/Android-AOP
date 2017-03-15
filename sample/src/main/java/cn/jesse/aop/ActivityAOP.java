package cn.jesse.aop;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
     * activity onCreate point cut
     */
    @Pointcut("execution(* android.app.Activity.onCreate(..))")
    public void activityOnCreate() {
        //empty method body
    }


    @Around("activityOnCreate()")
    public void activityOnCreateTrigered(ProceedingJoinPoint joinPoint) throws Throwable{
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d(TAG, targetClassName + " " + signatureName + " before");
        joinPoint.proceed();
        Log.d(TAG, targetClassName + " " + signatureName + " after");
    }

    /**
     * activity onResume point cut
     */
    @Pointcut("execution(* android.app.Activity.onResume())")
    public void activityOnResume() {
        //empty method body
    }

    @Before("activityOnResume()")
    public void activityOnResumeTrigered(JoinPoint joinPoint) {
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String signatureName = joinPoint.getSignature().getName();
        Log.d(TAG, targetClassName + " " + signatureName + " before");
    }
}
