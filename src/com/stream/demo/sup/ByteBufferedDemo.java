package com.stream.demo.sup;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 高级 字节缓存流
 * @author Torey
 *
 */
public class ByteBufferedDemo {
	/**
	 * 测试字节缓存输出流
	 */
	@Test
  public void testBufferedOutputStream(){
		//创建缓存输出流
		BufferedOutputStream os=null;
	  try {
		  File file=new File("D:\\a2\\buffered.txt");
		 os=new BufferedOutputStream(new FileOutputStream(file));
		 //向文件中写入数据
		 os.write("使用BufferedOutputStream(缓存输出流)写入的文件内容".getBytes());
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
     try {
    	 //释放资源
		os.flush();
		os.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
  }
	/**
	 * 测试 字节缓存输入流
	 */
	@Test
	public void testBufferedInputStream(){
		//创建缓存输入流
		BufferedInputStream in=null;
		try {
			in=new BufferedInputStream(new FileInputStream(new File("D:\\a2\\buffered.txt")));
			byte[] buffer=new byte[1024];
			//存储每次读取的字节
			int len=0;		
			while((len=in.read(buffer))!=-1){
				System.out.println(len);
				String content=new String(buffer,0,len);
				System.out.println(content);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
