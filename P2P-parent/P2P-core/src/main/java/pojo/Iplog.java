package pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 登录日志类
 * @author suke
 *
 */
@Getter
@Setter
@ToString
public class Iplog extends BaseEntity{
	private static final long serialVersionUID = 1L;
	/**
	 * 登录成功
	 */
	public static int  LOGINSTATE_SUCCESS = 0;
	/**
	 * 登录失败
	 */
	public static int  LOGINSTATE_FAILED = 1;
	
	private String ip;
	private Integer loginstate;
	private String username;
	private Long logininfoid;
	private Integer logintype;
	private Date logintime;
	
}
