package com.huangbin.gsarts.aop;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 用户日志aop
 */
@Component
@Aspect
@Order(2)
public class UserOperationAop {
//    @Autowired
//    UserLogService userLogService;
    protected Log log = LogFactory.getLog(this.getClass());

    /**
     * @param joinPoint 结合点
     * @param object    操作结果
     *                  执行save delete时执行
     */
    @AfterReturning(value = "execution(* com.huangbin.gsarts.service.*.save(..))|| execution(* com.huangbin.gsarts.service.*.delete(..))", returning = "object")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object object) {



//        String userName = (String) joinPoint.getArgs()[1];
//        ReturnObject returnObject = (ReturnObject) object;
//        boolean result = returnObject.getResult();
//        Object[] args = joinPoint.getArgs();
//        HttpServletRequest request = (HttpServletRequest) args[0];
//        String ip = request.getRemoteHost();
//        UserLog userLog = new UserLog();
//        userLog.setUserName(userName);
//        userLog.setLoginIp(ip);
//        userLog.setOperation("数据操作");
//        userLog.setOperationTime(new Date());
//        userLog.setStatus(result ? "操作成功" : "操作失败");
//        userLogService.createUserLog(userLog);
    }
}
