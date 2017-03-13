package dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DomFourJTest {
	/**
	 * XML的解析 DOM4J的解析 导入dom4j jar包 dom4j不能越级去查询节点
	 * 
	 * 
	 */

	// 操作的xml文档
	public final static String files = "src/bookD.xml";

	public static void main(String[] args) {
		try {
			// 查询
			// bookQuery();
			// 添加
			// bookAdd();
			// 指定位置添加子节点
			// bookAddLocation();
			// 删除团购价节点
			// bookDelete();
			// 修改节点内容
			// bookUpdate();
			// XPATH测试查询
			bookXpath();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 对xpath进行测试
	 * 
	 */
	public static void bookXpath() throws Exception {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml文件
		Document document = reader.read(files);
//		获取作者
//		List<Node> nodeList = document.selectNodes("/书架/书/作者");
//		for (Node node : nodeList) {
//			System.out.println(node.getText());
//		}
//		List<Node> nodeList = document.selectNodes("//作者");
//		for (Node node : nodeList) {
//			System.out.println(node.getText());
//		}
		
		//获取一个作者
		Node authorTwo = document.selectSingleNode("/书架/书[last()]/作者");
		System.out.println(authorTwo.getText());
	}

	/**
	 * 修改节点内容
	 * 
	 * 修改第二本书的作者的文本内容
	 * 
	 * @throws Exception
	 */
	public static void bookUpdate() throws Exception {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml文件
		Document document = reader.read(files);
		// 获取根节点
		Element root = document.getRootElement();
		// 获取第二本书
		Element bookTwo = (Element) root.elements("书").get(1);
		// 获取作者的节点
		bookTwo.element("作者").setText("大天使之剑");

		// 回写
		bookSave(document, files);
	}

	/**
	 * 删除某个节点
	 * 
	 */
	public static void bookDelete() throws Exception {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml文件
		Document document = reader.read(files);
		// 获取根节点
		Element root = document.getRootElement();
		// 获取第一本书
		Element bookOne = root.element("书");
		// 获取团购价节点
		Element deleteTGJ = bookOne.element("团购价");
		// 删除
		bookOne.remove(deleteTGJ);

		// 回写
		bookSave(document, files);
	}

	/**
	 * 指定位置添加子节点
	 * 
	 * 需求 在第一本书的作者节点之前添加
	 * 
	 */
	public static void bookAddLocation() throws Exception {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析XML文件
		Document document = reader.read(files);
		// 必须先获取根节点
		Element root = document.getRootElement();
		// 获取第一本书
		Element bookOne = root.element("书");
		// 获取第一本书下所有子节点
		List<Element> bookChildList = bookOne.elements();
		// 创建元素对象
		Element addTGJ = DocumentHelper.createElement("团购价");
		addTGJ.setText("998元");
		// 添加一个节点
		bookChildList.add(1, addTGJ);

		// 回写
		bookSave(document, files);
	}

	/**
	 * 添加子节点
	 * 
	 * 需求 在第一本书的下面添加团购价节点
	 * 
	 */
	public static void bookAdd() throws Exception {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析XML文件
		Document document = reader.read(files);
		// 必须先获取根节点
		Element root = document.getRootElement();
		// 获取第一本书
		Element bookOne = root.element("书");// 默认拿到第一本
		// 直接在第一本书下添加子节点(设置文本的内容)
		bookOne.addElement("团购价").setText("1222元");
		// 回写
		bookSave(document, files);
	}

	/**
	 * 查询作者标签的文本内容
	 * 
	 * @throws Exception
	 */
	public static void bookQuery() throws Exception {
		Element root = bookSAX(files);
		// 获取书的节点
		List<Element> bookList = root.elements("书");
		// 循环遍历
		for (Element book : bookList) {
			// 循环第一次，获取第一本书
			Element author = book.element("作者");
			// 获取节点的文本内容
			String bookAuthor = author.getText();
			// 打印
			System.out.println(bookAuthor);
		}
	}

	/**
	 * 公共工厂类
	 * 
	 * @param file
	 *            解析的文件
	 * @return 返回element 根节点
	 * @throws Exception
	 */
	public static Element bookSAX(String file) throws Exception {
		// 创建解析器对象
		SAXReader reader = new SAXReader();
		// 解析XML文件
		Document document = reader.read(file);
		// 必须先获取根节点
		Element root = document.getRootElement();
		return root;
	}

	/**
	 * 公共回写类
	 * 
	 * @param file
	 *            要写入的文件
	 * @throws Exception
	 */
	public static void bookSave(Document document, String file)
			throws Exception {
		// 创建输出的格式
		OutputFormat format = OutputFormat.createPrettyPrint();

		// 回写
		XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
		// 把内存中的Document写入到xml文件中
		writer.write(document);
		// 关闭流
		writer.close();
	}

}
