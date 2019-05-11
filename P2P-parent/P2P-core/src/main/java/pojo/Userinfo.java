package pojo;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Userinfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/**版本号*/
	private Integer version = 0;
	/**用户状态值*/
	private Long bitState = 0L;
	/**用户实名*/
	private String realName;
	/**用户身份证号*/
	private String idNumber;
	/**用户电话*/
	private String phoneNumber;	
	/**收入*/
	private SystemDictionaryItem incomeGrade;
	/**婚姻情况*/
	private SystemDictionaryItem marriage;
	/**子女情况*/
	private SystemDictionaryItem  kidCount;	
	/**学历*/
	private SystemDictionaryItem educationBackground;
	/**住房条件*/
	private SystemDictionaryItem houseCondition;	
	
	/**绑定的邮箱*/
	private String email;
	
	/**风控资料分数*/
	private Integer authScore = 0;
	
	/**
	 * 实名制信息
	 */
	private Long realauthid;
}
