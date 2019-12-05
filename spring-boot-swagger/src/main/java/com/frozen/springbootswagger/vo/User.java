package com.frozen.springbootswagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: Frozen
 * @create: 2019-12-04 10:14
 * @description:
 **/
@Data
@ToString
@ApiModel
public class User implements Serializable {

	private static final long serialVersionUID = 8655851615465363473L;

	private Long id;
	@ApiModelProperty("用户名")
	private String username;
	@ApiModelProperty("密码")
	private String password;
	public User() {}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
