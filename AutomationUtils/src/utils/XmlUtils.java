package utils;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlUtils {

	public static String readXmlNode(String filePath, String xpathElement, String nodeName ) {
		
		String result = "";
		    try {

//		            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//		            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//		            Document doc = docBuilder.parse (new File(filePath));
//
//		            // normalize text representation
//		            doc.getDocumentElement ().normalize ();
//		            System.out.println ("Root element of the doc is " + 
//		                 doc.getDocumentElement().getNodeName());
//
//
//		            NodeList listOfNodes = doc.getElementsByTagName(parentNode);
//		            int totalNodes = listOfNodes.getLength();
//		            System.out.println("Total no of nodes found : " + totalNodes);
//
//		            for(int s=0; s<listOfNodes.getLength() ; s++){
//
//
//		                Node firstNode = listOfNodes.item(s);
//		                if(firstNode.getNodeType() == Node.ELEMENT_NODE){
//
//
//		                    Element firstChildNode = (Element)firstNode;
//
//		                    //-------
//		                    NodeList firstChildNodeList = firstChildNode.getElementsByTagName(childNode);
//		                    Element firstChildElement = (Element)firstChildNodeList.item(0);
//
//		                    NodeList textFNList = firstChildElement.getChildNodes();
//		                    System.out.println("First Name : " + 
//		                           ((Node)textFNList.item(0)).getNodeValue().trim());
//
//		                   
//
//
//		                }//end of if clause
//
//
//		            }//end of for loop with s var
//
//
//		        }catch (SAXParseException err) {
//		        System.out.println ("** Parsing error" + ", line " 
//		             + err.getLineNumber () + ", uri " + err.getSystemId ());
//		        System.out.println(" " + err.getMessage ());
//
//		        }catch (SAXException e) {
//		        Exception x = e.getException ();
//		        ((x == null) ? e : x).printStackTrace ();
//
//		        }catch (Throwable t) {
//		        t.printStackTrace ();
//		        }
		        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document document = db.parse(new FileInputStream(new File(filePath)));// same xml comments as above.

	            XPathFactory xpf = XPathFactory.newInstance();
	            XPath xpath = xpf.newXPath();
	            Element userElement = (Element) xpath.evaluate(xpathElement, document,
	                XPathConstants.NODE);
	            NodeList nodes = userElement.getChildNodes();
	            if(nodes.getLength() > 0) {
	            	for(int i = 0; i < nodes.getLength(); i++) {
	            		Node node = nodes.item(i);
	            		System.out.println("Node name: " +node.getNodeName() +" value: " + node.getTextContent());
	            		if(node.getNodeName().trim().equalsIgnoreCase(nodeName.trim())) {
	            			result = node.getTextContent();
	            			break;
	            		}
	            			
	            	}
	            }
	            
	           
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		    if(result == "")
		    	System.out.println("Node value not found");
		     return result;

	}
}
