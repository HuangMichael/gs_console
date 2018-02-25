package com.huangbin.gsarts.asyn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by huangbin on 2017/9/8.
 */

@Component
@Slf4j
public class AsyncDataTransformLog {
    /**
     * @Async 所修饰的函数不要定义为static类型，否则异步调用不会生效
     * 这里通过返回Future<T>来返回异步调用的结果，实现异步回调
     */
//    @Autowired
//    DataTransformLogService dataTransformLogService;

//    @Async
//    public Future<String> writeDataTransformLog(DataTransformLog dataTransformLog) throws InterruptedException {
//        //将用户查询日志写入数据库
//        dataTransformLog = dataTransformLogService.save(dataTransformLog);
//        return new AsyncResult("save dataTransform log ?" + (dataTransformLog != null));
//    }
}