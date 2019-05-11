package pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据字典
 * @author Administrator
 *
 */
@Getter
@Setter
public class SystemDictionary extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/**分类编码*/
	private String sn; 
	/**分类标题*/
	private String title;
	

}
