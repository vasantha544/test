package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property { 

	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties property=new Properties();
		try {
			property.load(new FileInputStream(filePath));
			value=property.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
}// property class is the inbuilt class in Java there is no need to write any dependencies. 
//the use of this file is it will take the data from the properties file- any file with extension of properties it will take data.
// properties file we can store the data in the key value pair.