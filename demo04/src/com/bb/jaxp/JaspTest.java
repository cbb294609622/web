package com.bb.jaxp;

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

/**
 * JAXP 测试
 * @author bb
 *	
 *	快速入门的步骤
 *	1.先获取解析工厂类
 *		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 *	2.获取DOM解析对象
 *		DocumentBuilder builder = factory.newDocumentBuilder();
 *	3.解析xml文档，返货Document对象
 *		Document document = builder.parse("src/book.xml");
 *	4.通过Document对象的API来完成CRUD操作
 *
 *
 */
public class JaspTest {
	
	//操作的xml文件
	public final static String files = "src/book.xml";
	
	public static void main(String[] args) {
		try {
			//查询子节点
//			bookName();
			
			//增加子节点
//			bookAdd();
			
			//删除团购价节点
//			bookDelete();
			
			//修改子节点
//			bookUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改子节点
	 * 
	 * @throws Exception 
	 */
	public static void bookUpdate() throws Exception{
		Document document = onWork(files);
		//获取第二个作者
		Node author = document.getElementsByTagName("作者").item(1);
		//设置文本内容
		author.setTextContent("王大锤");
		
		//回写
		writeBack(document, files);
		System.out.println("修改成功");
	}
	
	
	/**
	 * 删除团购价节点
	 * @throws Exception 
	 */
	public static void bookDelete() throws Exception{
		Document document = onWork(files);
		//先获取团购价的节点
		Node node = document.getElementsByTagName("团购价").item(0);
		//获取团购价父节点
		Node bookOne = node.getParentNode();
		//使用书的节点删除团购价节点
		bookOne.removeChild(node);
		//回写
		writeBack(document, files);
		System.out.println("删除成功");
	}
	
	
	/**
	 * 添加子节点
	 * @throws Exception 
	 * 
	 */
	public static void bookAdd() throws Exception{
		/**
		 * 省略3步骤
		 * 	1.创建元素对象(团购价)
		 * 	2.设置文本内容。
		 * 	3.元素对象添加到书的节点下面
		 * 		3.1.获取第一本书
		 */
		Document document = onWork(files);
		//创建元素	团购价
		Element element = document.createElement("团购价");
		//设置文本内容
		element.setTextContent("99元");
		//获取第一本书
		Node bookOne = document.getElementsByTagName("书").item(0);
		//把团购价添加到第一本书上面
		bookOne.appendChild(element);
		
		//回写
		writeBack(document,files);
		System.out.println("添加成功");
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
		Document document = onWork(files);
		//获取作者的节点
		NodeList nodeList = document.getElementsByTagName("作者");
		//循环遍历nodeList
		for (int i = 0; i < nodeList.getLength(); i++) {
			//循环一次 获取了作者的标签
			Node node = nodeList.item(i);
			//打印节点的文本内容
			System.out.println(node.getTextContent());
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
