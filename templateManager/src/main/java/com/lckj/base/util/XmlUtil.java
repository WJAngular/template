
package com.lckj.base.util;

import java.io.File;
import java.io.InputStream;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
* @ClassName: XmlUtil 
* @Description:  xml解析工具类 
* @author: WUJING 
* @date :2016-06-10 上午11:12:09 
*
 */
public final class XmlUtil {
    
    /**
     * 构造函数
     */
    private XmlUtil() {
    }
    
    /**
     * 获取指定节点的第一个子节点值
     * 
     * @param node 指定节点对象
     * @return 指定节点的第一个子节点值，如果不存在子节点则返回<code>null</code>
     */
    public static String getTagValue(Node node) {
        Node objFirstChild = node.getFirstChild();
        if (objFirstChild == null) {
            return null;
        }
        return objFirstChild.getNodeValue();
    }
    
    /**
     * 获取Element元素中指定标签名称的节点值
     * 
     * @param element 存在指定标签的Element元素
     * @param tagName 标签名称
     * @return 标签节点值
     */
    public static String getTagValue(Element element, String tagName) {
        
        if (element == null) {
            return null;
        }
        NodeList nodes = element.getElementsByTagName(tagName.toLowerCase());
        if (nodes == null || nodes.getLength() <= 0) {
            return null;
        }
        return getTagValue(nodes.item(0));
    }
    
    /**
     * 获取Document对象中指定标签名称的节点值
     * 
     * @param document 存在指定标签的Document对象
     * @param tagName 标签名称
     * @return 标签节点值
     */
    public static String getTagValue(Document document, String tagName) {
        if (document == null) {
            return null;
        }
        return getTagValue(document.getDocumentElement(), tagName);
    }
    
    /**
     * 定位元素
     * 
     * @param nodes NodeList对象
     * @return 定位到的Element元素
     */
    private static Element locateElement(NodeList nodes) {
        if (nodes == null) {
            return null;
        }
        int iLength = nodes.getLength();
        if (iLength == 0) {
            return null;
        }
        Element element = null;
        for (int i = 0; i < iLength; i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) node;
            } else {
                continue;
            }
        }
        return element;
    }
    
    /**
     * 以指定键key从Document中定位Element元素.
     * 
     * @param key 指定键key名称.
     * @param document Document东西.
     * @return <code>Element</code> 符合的Element元素.
     */
    public static Element getElement(String key, Document document) {
        return getElement(key, document.getDocumentElement());
    }
    
    /**
     * 以指定键key从Element中定位Element元素.
     * 
     * @param key 指定键key名称.
     * @param element Element元素.
     * @return <code>Element</code> Element元素.
     */
    public static Element getElement(String key, Element element) {
        Element contentElement = element;
        StringTokenizer tokenizer = new StringTokenizer(key, ".");
        
        NodeList nodes = null;
        
        while (tokenizer.hasMoreTokens()) {
            String tagName = tokenizer.nextToken();
            nodes = contentElement.getElementsByTagName(tagName);
            contentElement = locateElement(nodes);
            if (contentElement == null) {
                return null;
            }
        }
        return contentElement;
    }
    
    /**
     * 以指定标签名称从Document获取Element数组
     * 
     * @param tagName 标签名称.
     * @param document Document对象.
     * @return <code>Element[]</code> Element数组.
     */
    public static Element[] getElements(String tagName, Document document) {
        return getElements(tagName, document.getDocumentElement());
    }
    
    /**
     * 以指定标签名称从Element中获取Element数组.
     * 
     * @param tagName 标签名称.
     * @param element Element元素.
     * @return <code>Element[]</code> Element元素数组.
     */
    public static Element[] getElements(String tagName, Element element) {
        NodeList nodes = null;
        
        nodes = element.getElementsByTagName(tagName);
        
        if (nodes == null) {
            return null;
        }
        int iLength = nodes.getLength();
        if (iLength == 0) {
            return null;
        }
        Element[] elements = new Element[iLength];
        int j = 0;
        for (int i = 0; i < iLength; i++) {
            Node n = nodes.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                elements[j] = (Element) n;
                j++;
            } else {
                continue;
            }
        }
        return elements;
    }
    
    /**
     * 从InputStream中解析创建Document对象
     * 
     * @param inputStream InputStream输入流对象
     * @return 解析后的<code>Document</code> 对象.
     */
    public static Document parse(InputStream inputStream) {
        Document objDocument = null;
        if (inputStream == null) {
            return null;
        }
        try {
            DocumentBuilderFactory objFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder objBuilder = objFactory.newDocumentBuilder();
            objDocument = objBuilder.parse(inputStream);
        } catch (Throwable th) {
            throw new IllegalArgumentException("解析XML文件输入流时发生异常", th);
        }
        return objDocument;
    }
    
    /**
     * 从xml配置文件文件中解析创建Document对象
     * 
     * @param file xml配置文件
     * @return 解析后的<code>Document</code> 对象.
     */
    public static Document parse(File file) {
        Document objDocument = null;
        if (file.exists()) {
            return null;
        }
        try {
            DocumentBuilderFactory objFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder objBuilder = objFactory.newDocumentBuilder();
            objDocument = objBuilder.parse(file);
        } catch (Throwable th) {
            throw new IllegalArgumentException("解析XML时发生异常", th);
        }
        return objDocument;
    }
    
    /**
     * 以指定xml文件路径解析创建Document对象
     * 
     * @param xmlPath xml文件路径.
     * @return 解析后的Document对象
     */
    public static Document parse(String xmlPath) {
        File objFile = new File(xmlPath);
        return parse(objFile);
    }
}
