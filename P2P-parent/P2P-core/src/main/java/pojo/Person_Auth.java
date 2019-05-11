package pojo;

import lombok.Getter;
import lombok.Setter;

/*
 * 四个认证状态类
 */
@Setter
@Getter
public class Person_Auth {
	/**
	 * 实名制认证
	 */
	private boolean real_Auth;
	/**
	 * 手机认证
	 */
	private boolean phone_Auth;
	/**
	 * 邮箱认证
	 */
	private boolean mail_Auth;
	/**
	 * VIP
	 */
	private boolean vip;
}
