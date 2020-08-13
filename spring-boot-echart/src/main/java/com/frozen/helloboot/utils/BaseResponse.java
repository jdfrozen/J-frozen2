package com.frozen.helloboot.utils;

public class BaseResponse<T> {

    private int    code ;

    private String msg;

    private T result;

    public BaseResponse() {
    }

	public BaseResponse(int code, String msg, T result) {
		this.code = code;
		this.msg = msg;
		this.result = result;
	}

	public static <T> BaseResponse<T> createSuccess(){
		return new BaseResponse<T>(StatusEnum.SUCCESS.getCode(),  StatusEnum.SUCCESS.getMsg(),null);
	}

	public static <T> BaseResponse<T> createSuccess(T t){
		return new BaseResponse<T>(StatusEnum.SUCCESS.getCode(),null,t);
	}

	public static <T> BaseResponse<T> createFail(){
		return new BaseResponse<T>(StatusEnum.FAIL.getCode(),  StatusEnum.FAIL.getMsg(),null);
	}

	public static <T> BaseResponse<T> createFail(String msg){
		return new BaseResponse<T>(StatusEnum.FAIL.getCode(), msg,null);
	}

	public static <T> BaseResponse<T> createFail(int code,String msg,T t){
		return new BaseResponse<T>(code,msg,t);
	}

	public  boolean isSuccess(){
		return StatusEnum.SUCCESS.getCode() ==this.code;
	}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return "BaseResponse{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", result=" + result +
				'}';
	}
}
