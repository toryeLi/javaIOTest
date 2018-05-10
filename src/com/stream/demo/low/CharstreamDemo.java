package com.stream.demo.low;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
/**
 * 字符流 测试
 * @author Torey
 *
 */
public class CharstreamDemo {
	/**
	 * 字符 输出流
	 */
	@Test
    public void testFileWrite(){
    	FileWriter fileWrite=null;
    	try {
    		//创建字符输出流，追加写入的内容
    		 fileWrite=new FileWriter("D:\\a2\\t.txt",true);
    		 fileWrite.write("|我是FileWrite字符流");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				//关闭流
				fileWrite.flush();
				fileWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	/**
	 * 字节输入流
	 */
	@Test
	public void testFileRead(){
		//创建字符输入流
		FileReader read2=null;
		File file=new File("D:\\a2\\t.txt");
		try {
          read2=new FileReader(file);
          //操作流
          char[] data=new char[(int)file.length()];
          read2.read(data, 0, data.length);
          String str=new String(data);
          System.out.println(str.trim());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				//关闭流
				read2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
