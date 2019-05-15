import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class testDom4j {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Test
	public void test(){
		
		try {
			//1.获取解析器
			SAXReader saxReader=new SAXReader();
			//2.获取document文档对象
			Document doc=saxReader.read("src/cn/itcast/b_dtd/web.xml");
			//3.获取根元素
			Element root=doc.getRootElement();
			//System.out.println(root.getName());
			//4.获取根元素下的子元素
			List<Element> childElement=root.elements();
			//5.遍历子元素
			for(Element element: childElement){
				if("servlet".equals(element.getName())){
					Element serName=element.element("servlet-name");
					System.out.println(serName.getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
