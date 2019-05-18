package util;

import com.alibaba.fastjson.JSON;

public class ElCommons{

	/**
	 * 将对象中存在值的字段转换成为json串
	 * @param obj
	 * @return
	 */
    public static String toJsonString(Object obj){
        // 将java对象转换为json对象
    	String jsonString = JSON.toJSONString(obj); 
        return jsonString;
    }
}
