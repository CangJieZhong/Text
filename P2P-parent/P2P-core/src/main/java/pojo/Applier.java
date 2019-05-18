package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**审核页面需要的数据类*/
@Setter
@Getter
@ToString
public class Applier extends Realauth {
	private static final long serialVersionUID = 1L;
	/**申请人用户名*/
	private String applierName;
	/**审核人用户名*/
	private String auditorName;
}
