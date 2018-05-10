package com.stream.demo.sup;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * 数据流的简单使用
 * 可以指定写入数据类型
 * @author Administrator
 * 
 * 注意： 所有流程是否无法创建目录的
 *
 */
public class DataStreamDemo {
	
	@Test
	public void testDataOutputStream() {
		try {
			// 创建数据的输出流对象
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("D:/a/b/c/d/data.txt")));
			// 向文件写入内容
			dos.writeBoolean(false);
			dos.writeLong(1000L);
			dos.writeUTF("我学会使用DataOutputStream输出流对象写入文件内容");
			
			// 释放资源
			dos.flush();
			dos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDataInputStream() {
		try {
			// 创建数据的输入流对象
			DataInputStream dis = new DataInputStream(new FileInputStream(new File("D:/a/b/c/d/data.txt")));
			// 读取文件中内容
			System.out.println(dis.readBoolean());
			System.out.println(dis.readLong());
			System.out.println(dis.readUTF());
			
			// 释放流
			dis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
