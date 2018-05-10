package com.stream.demo.sup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.stream.demo.sup.entity.Cat;

/**
 * 串行化流/对象流操作实例
 * @author Administrator
 *
 */
public class ObjectStreamDemo {
	
	@Test
	public void objectOutputStream() {
		// java.io.NotSerializableException: java.lang.Object
		// 异常就是被序列化的对象没有实现Serializable接口
		try {
			// 创建一个对象流程
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("D:/a/b/c/d/object.txt")));
			// 创建一个Cat对象
			Cat cat = new Cat();
			cat.setAge(4);
			cat.setName("咖啡猫");
			cat.setSex("母");
			
			// 序列化一个对象到文件中
			os.writeObject(cat);
			
			// 释放流
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void objectInputStream() { // 反序列化出来
		// java.io.NotSerializableException: java.lang.Object
		// 异常就是被序列化的对象没有实现Serializable接口
		try {
			// 创建一个对象流程
			ObjectInputStream os = new ObjectInputStream(new FileInputStream(new File("D:/a/b/c/d/object.txt")));
			
			// 反序列化文件内容
			try {
				//System.out.println(os.readObject());
				Object obj = os.readObject();
				
				if (obj instanceof Cat) {
					Cat cat = (Cat) obj;
					System.out.println(cat.getName());
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			// 释放流
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
