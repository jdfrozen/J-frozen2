package com.frozen.echart.utils;


public enum StatusEnum {

	SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    Uknown(-1, "未知");

    private final int code;
    private final String msg;

    StatusEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public static StatusEnum parse(int code) {
        for (StatusEnum tmp : values()) {
            if (code == tmp.code) {
                return tmp;
            }
        }
        return StatusEnum.Uknown;
    }
}
