package com.util.InterFaceUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.util.InterFaceUtil.Utils.GetWeather;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterFaceUtilApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		String json = GetWeather.getWeatherByCityName(GetWeather.getCityNameByIp("113.87.160.154"));
		System.out.println(json);
	}

}
