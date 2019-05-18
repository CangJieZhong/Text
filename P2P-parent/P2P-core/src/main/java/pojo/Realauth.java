package pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Realauth extends BaseEntity {
	/**待审核*/
	public static  final int  STATE_APPLYED = 0; 
	/**审核通过*/
	public static  final int  STATE_TRUE = 1;
	/**审核失败*/
	public static  final int  STATE_FALSE = 2;
	/**性别男*/
	public static  final int  SEX_MAN = 0;
	/**性别女*/
	public static  final int  SEX_WOMAN = 1;
	/**真实姓名*/
	private String realname;
	/**性别*/
	private Integer sex;
	/**生日*/
	private String birthDate;
	/**身份证号码*/
	private String idNumber;
	/**住址*/
	private String address;
	/**状态*/
	private Integer state = STATE_APPLYED ;
	/**身份证正面*/
	private String image1;
	/**身份证反面*/
	private String image2;
	/**备注*/
	private String remark;
	/**审核时间*/
	private Date auditTime;
	/**申请时间*/
	private Date applyTime;
	/**审核人id*/
	private long auditor_id;
	/**申请人id*/
	private long applier_id;
}
