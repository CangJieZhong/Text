package util;

import java.math.BigDecimal;

public class SystemConst {
	// 防止丢失精度, 不要使用 new BigDecimal(double) 而使用new BigDecimal(String)
	public static final BigDecimal ZERO = new BigDecimal("0.0000");
	public static final BigDecimal INITIAL_BORROW_LIMIT = new BigDecimal(
			"2000.0000");
}
