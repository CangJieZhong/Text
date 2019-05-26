package pojo;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 添加状态实体类
 * @author cangjie
 *
 */
@Setter
@Getter
@ToString
public class AddRealAuth implements Serializable{
	/**用户id*/
	private Integer userId;
	/**新的状态码*/
	private Integer newRealauthid;
	/**相对应的realauth表的id*/
	private Integer realauth_id;
	/**真实姓名*/
	private String realName;
	/**身份证号码*/
	private String idNumber;
}
