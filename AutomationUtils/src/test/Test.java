package test;

import utils.XmlUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String author = XmlUtils.readXmlNode("C:\\Users\\Jorge\\Documents\\books.xml", "/catalog/book[@id='bk102']", "author");
		System.out.println(author);
	}

}
