package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Logininfo extends BaseEntity{
	//创建静态常量
		/**正常状态*/
		public static  final int  STATE_NORMAL = 0; 
		/**锁定状态*/
		public static  final int  STATE_LOCK = 1;
		/**已删除状态*/
		public static  final int  STATE_DELETE = -1;
		
		/**前台用户*/
		public static  final int  USERTYPE_NORMAL = 0;
		/**后台用户*/
		public static  final int  USERTYPE_SYSTEM = 1;
		
		private String username;
		private String password;
		private Integer state;
		private Integer usertype;
}
