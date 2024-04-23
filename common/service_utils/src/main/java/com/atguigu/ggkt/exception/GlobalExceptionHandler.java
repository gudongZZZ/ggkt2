package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail("执行了全局异常");

    }

    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.fail("执行了特定异常");
    }

    @ExceptionHandler(GgktException.class)
    public Result error(GgktException e){
        e.printStackTrace();
        return Result.fail().message(e.getMsg()).code(e.getCode());
    }
}
