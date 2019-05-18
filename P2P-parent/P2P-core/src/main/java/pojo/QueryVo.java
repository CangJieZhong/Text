package pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class QueryVo {
	private Integer state;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date beginDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date endDate;
}
