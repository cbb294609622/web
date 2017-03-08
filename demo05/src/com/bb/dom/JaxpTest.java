package com.bb.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JaxpTest {
	
	//操作的xml文档
	public final static String files = "src/book.xml";
	
	public static void main(String[] args) {
		try {
			//获取所有子节点名称
//			bookNodeAll();
			
			//获取节点中的属性值
			bookTagAttr();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取节点中属性值
	 * @throws Exception 
	 * 
	 */
	public static void bookTagAttr() throws Exception{
		Document document = onWork(files);
		//先获取第一本书
		Node book = document.getElementsByTagName("书").item(0);
		//获取属性值 
		Element book1 = (Element) book;
		System.out.println(book1.getAttribute("出版社"));
	}
	
	
	
	
	
	/**
	 * 获取所有节点的名称
	 * @throws Exception 
	 * 
	 */
	public static void bookNodeAll() throws Exception{
		Document document = onWork(files);
		int index = 2;
		if (index == 1) {
			//第一种方式:获取所有的子节点
			NodeList nodeList = document.getElementsByTagName("*");
			//循环遍历
			for (int  i = 0;  i < nodeList.getLength();  i++) {
				Node node = nodeList.item(i);
				System.out.println(node.getNodeName());
			}
		}else {
			//第二种方式 递归
			//直接调用printNodeName方法,把document对象传入进去
			printNodeName(document);
		}
	}
	
	/**
	 * 打印节点的名称
	 */
	public static void printNodeName(Node node){
		if (node.ELEMENT_NODE == node.getNodeType()) {
			System.out.println(node.getNodeName());
		}
		
		//获取子节点
		NodeList nodeList = node.getChildNodes();
		//循环遍历
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nodeChild =  nodeList.item(i);
			//调用本体
			printNodeName(nodeChild);
		}
		
	}
	
	
	
	/**
	 * 公共静态类 工厂
	 * @param files		文件路径
	 * @return	document	返回document
	 * @throws Exception
	 */
	public static Document onWork(String files) throws Exception{
		//获取解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析book.xml文件
		Document document = builder.parse(files);
		return document;
		
	}
	
	/**
	 * 1.获取TransformFactory类获取Transform类
	 * 2.Transform类中有一个方法:transform(数据源(document),目的地(xml的文档))，来进行回写操作。
	 *  
	 * @param document
	 * @param files
	 * @throws Exception
	 */
	public static void writeBack(Document document , String files) throws Exception{
		
		//先获取回写的工厂类
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//获取回写的类
		Transformer transform = transformerFactory.newTransformer();
		//调用transform(数据源,目的地)
		transform.transform(new DOMSource(document), new StreamResult(files));
		
	}
	
}
