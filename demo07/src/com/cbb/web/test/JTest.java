package com.cbb.web.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;
/**
 * 引入Junit测试，单元测试。
 * 被测试的方法 :公有的 无返回值 无参数
 * 
 * @author bb
 *
 */
public class JTest {
	/**
	 * 编码
	 */
	@Test
	public void testEncoder(){
		//对于URL路径如何编码
		String encoder;
		try {
			encoder = URLEncoder.encode("攻略.jpg","UTF-8");
			System.out.println(encoder);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 解码
	 */
	@Test
	public void testDecoder(){
		try {
			String decoder = URLDecoder.decode("%E6%94%BB%E7%95%A5.jpg", "UTF-8");
			System.out.println(decoder);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
