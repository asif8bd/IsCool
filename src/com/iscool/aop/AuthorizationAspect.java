package com.iscool.aop;

import com.iscool.security.model.Feature;
import com.iscool.security.service.AuthenticationAndAuthorizationService;
import com.iscool.security.service.SecurityService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Aspect
public class AuthorizationAspect {
	
	@Autowired
    private SecurityService securityService;

    @Autowired
    private AuthenticationAndAuthorizationService authorizationService;
    private List<Feature> features = null;
    private boolean isAllowed = false;
    String module = null;
    String operation = null;
    String requestMapping = null;


    @Pointcut("within(@org.springframework.stereotype.Controller *) " +
			"&& !within(@org.springframework.stereotype.Controller com.iscool.security.AuthenticationController)" +
            "&& !within(@org.springframework.stereotype.Controller com.iscool.security.HomeController)")
	public void allControllers(){}

	@Pointcut("execution(* *(..))")
	public void allOperations(){}

	/*@Pointcut("execution(* updateProject*(..))")
	public void allUpdateOperations(){}

	@Pointcut("execution(* *List(..))")
	public void allListOperations(){}

	@Pointcut("execution(* delete*(..))")
	public void allDeleteOperations(){}

	@Pointcut("execution(* *Assignment(..))")
	public void allAssignmentOperations(){}
*/
    /*@MAK
	@Around("allControllers() && allOperations()")
	public Object proceedToAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");

	}
     */
	/*@Around("allControllers() && allUpdateOperations()")
	public Object proceedToUpdateAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");

	}

	@Around("allControllers() && allListOperations()")
	public Object proceedToListAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");

	}

	@Around("allControllers() && allDeleteOperations()")
	public Object proceedToDeleteAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");

	}

	@Around("allControllers() && allAssignmentOperations()")
	public Object proceedToAssignmentAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");

	}*/

}
