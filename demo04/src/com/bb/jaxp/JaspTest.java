package com.bb.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import sun.print.resources.serviceui;

/**
 * JAXP 测试
 * @author bb
 *
 */
public class JaspTest {
	
	public static void main(String[] args) {
		
	}
	/**
	 * 查询book.xml中作者标签中的文本内容
	 * @throws ParserConfigurationException 
	 */
	public static void bookName() throws Exception{
		/**
		 * 0.获取解析器工厂类
		 * 1.获取DOM方式的解析器对象（DocumentBuilder）
		 * 		1.1.通过解析器的工厂类来获取解析器对象
		 * 2.解析XML的文档（parse()），返回Document对象
		 * 3.获取作者的节点,返货NodeList
		 * 4.循环遍历拿到每一个node对象
		 * 5.获取文本内容
		 */
		//获取解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析book.xml文件
		Document document = builder.parse("src/book.xml");
		
	}
	
}
