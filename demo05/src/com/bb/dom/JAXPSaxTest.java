package com.bb.dom;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JAXPSaxTest {
	/**
	 * SAX解析 只能查询，并且只能查询
	 * SAX解析的两个概念
	 * 		解析器		
	 * 		事件处理器	
	 * 	
	 * 
	 */
	
	//操作的xml文档
	public final static String files = "src/book.xml";
	
	public static void main(String[] args) {
		try {
			//查询所有元素名称和文本内容
			bookQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有元素的名称，包含文本内容
	 * @throws Exception 
	 * @throws  
	 */
	public static void bookQuery() throws Exception{
		//解析器
		
		//先获取SAX解析器的工厂类
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//获取sax解析器对象
		SAXParser parser = factory.newSAXParser();
		//解析
		parser.parse(files,new MyHandlerTwo());
	}
	
}

class MyHandlerTwo extends DefaultHandler{

	private boolean flagAuoth = false;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("作者".equals(qName)) {
			flagAuoth = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str = new String(ch,start,length);	
		if (flagAuoth) {
			System.out.println(str);
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		flagAuoth = false;
	}

	
	
}




/**
 * 自定义的事件处理器
 * @author bb
 *
 */
class MyHandlerOne extends DefaultHandler{
	
	/**
	 * 解析开始标签 默认调用该方法
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.print("开始标签:"+qName);
	}
	/**
	 * 解析标签中文本内容，默认调用该方法
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String string = new String(ch,start,length);
		System.out.print("  "+string+"  ");
	}
	/**
	 * 解析的是结束标签，默认调用该方法
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("结束标签:"+qName);
	}


	
}

