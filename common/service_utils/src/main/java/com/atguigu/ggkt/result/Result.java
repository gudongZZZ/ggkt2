package com.atguigu.ggkt.result;

import lombok.Data;

@Data
public class Result <T>{
    private Integer code;
    private String message;
    private T data;

    public Result(){}

    // 成功的方法
    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        if(data != null ){
            result.setData(data);
        }
        result.setCode(20000);
        result.setMessage("成功");
        return result;
    }

    public static<T> Result<T> ok(){
        return Result.ok(null);
    }

    public static<T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        if(data != null ){
            result.setData(data);
        }
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }

    public static<T> Result<T> fail(){
        return Result.fail(null);
    }

    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<T>();
        if (body != null) {
            result.setData(body);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}
