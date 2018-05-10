package com.stream.demo.low;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
/**
 * 字节流 测试
 * @author Torey
 *
 */
public class BytestreamDemo {
	/**
	 * 测试字节输出流写入文件内容
	 */
	@Test 
	public void fileOutstreamTest() {
		//创建一个文件
		File file = new File("D:\\a2\\t.txt");
		//只有目录存在，即时文件不存在，文件流会自动创建这个文件
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			//使用write方法把内存中内容写入文件
			os.write("我爱我家".getBytes());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//关闭流
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
/**
 * 测试字节输出流写入文件内容
 */
	@Test
	public void fileInstreamTest() {
		
		File file = new File("D:\\a2\\t.txt");
		//创建文件输入流
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			//读取文件内容字节数
			System.out.println("File.length="+file.length());
			System.out.println("可以用的字节数是：" + is.available());
			//定义读取内容缓冲区
			byte[] data = new byte[is.available()];
			is.read(data, 0, data.length);
			//把字节数组转换为一个字符串
			String str = new String(data);
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				is.close();//关闭流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
