package com.orion.zzd;

import com.alibaba.fastjson.JSON;
import com.orion.zzd.constant.Constants;
import com.orion.zzd.requeat.Request;
import com.orion.zzd.response.Response;
import com.orion.zzd.util.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

	@Test
	public void contextLoads() {
	}


	//APP KEY
	private final static String APP_KEY = "24535965";
	// APP密钥
	private final static String APP_SECRET = "bcde7a6f63c4b75c1ebaf430e030aee6";
	//API域名
	private final static String HOST = "aliv3.data.moji.com";
	//自定义参与签名Header前缀（可选,默认只有"X-Ca-"开头的参与到Header签名）
	private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();

	/**
	 * HTTP POST 表单
	 *
	 * @throws Exception
	 */
	@Test
	public void postForm() throws Exception {
		//请求path
		String path = "/whapi/json/aliweather/alert";

		Map<String, String> headers = new HashMap<String, String>();
		//（必填）根据期望的Response内容类型设置
		headers.put(Constants.HTTP_HEADER_ACCEPT, "application/json");

		CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();


		Request request = new Request("POST", Constants.HTTP + HOST, path, APP_KEY, APP_SECRET, Constants.DEFAULT_TIMEOUT);
		request.setHeaders(headers);
		request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);

		//请求的query
		Map<String, String> querys = new HashMap<String, String>();
		request.setQuerys(querys);

		Map<String, String> bodys = new HashMap<String, String>();
		bodys.put("lat", "39.91488908");
		bodys.put("lon", "116.40387397");
		bodys.put("token", "2d2473e15e799be81e04ba6decae56d4");
		request.setBodys(bodys);

		//调用服务端
		Response response = Client.execute(request);

		System.out.println(JSON.toJSONString(response));
	}


}
