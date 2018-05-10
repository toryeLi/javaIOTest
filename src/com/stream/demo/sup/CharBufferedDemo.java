package com.stream.demo.sup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Test;

/**
 * 测试高级 字节缓存流
 * 
 * @author Torey
 *
 */
public class CharBufferedDemo {
	/**
	 * 测试高级的字节输出流
	 */
	@Test
	public void testBufferedWrite() {
		BufferedWriter bw = null;
		try {
			//bw = new BufferedWriter(
				//	new FileWriter("D:\\a2\\bufferedWriter.txt"));
			bw=new BufferedWriter(new FileWriter(new File("D:\\a2\\bufferedWriter.txt")));
			bw.write("使用高级字节输出流(BufferedWriter)写入的内容");
			bw.newLine();
			Calendar calendar=Calendar.getInstance();
			bw.write(calendar.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 使用高级的字节输入流
	 */
	@Test
	public void testBufferedRead(){
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(new File("D:\\a2\\bufferedWriter.txt")));
			String dataStr;
			while((dataStr=reader.readLine())!=null){
				System.out.println(dataStr);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
