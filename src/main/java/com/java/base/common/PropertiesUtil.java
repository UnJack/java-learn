package com.java.base.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by jimjian on 15/5/9.
 */
public class PropertiesUtil {
    private static Map<String,String> map=new HashMap<String,String>();

    public Map<String,String> getProperties(){
        Properties properties=new Properties();
        InputStream inputStream= null;
        try {
//            inputStream = new FileInputStream(new File("/iWorkSpance/JavaBase/src/com/wybase/test.properties"));
            //获得跟目录
            inputStream=getClass().getResourceAsStream("/orther/test.properties");
            properties.load(inputStream);
            Enumeration enumeration=properties.propertyNames();
            while (enumeration.hasMoreElements()){
                String key= (String) enumeration.nextElement();
                String content=properties.getProperty(key);
                map.put(key,content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static void main(String[] args){
        PropertiesUtil propertiesUtil=new PropertiesUtil();
        System.out.print(propertiesUtil.getProperties());
    }
}
