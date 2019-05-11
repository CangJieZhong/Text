package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据字典分类明细
 * @author Administrator
 */
@Getter
@Setter
@ToString
public class SystemDictionaryItem extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/**属于哪个分类*/
	private Long parentId;
	/**分类明细的内容*/
	private String title;
	/**数据字典明细在该分类中的排序*/
	private Integer sequence;
	

}
