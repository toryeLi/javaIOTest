package com.stream.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件操作工具类
 * @author Administrator
 *
 */
public class FileUtils {
	
	public static void main(String[] args) {
		String srcFile = "D:/vip/java02/javavip02_12_20180420(LinkedList模拟Stack，Queue)/javavip02_12_20180420(LinkedList模拟Stack，Queue).wmv";
		String destFile = "C:/copy_back.wmv";
		copyBigFile(srcFile, destFile);
	}

	/**
	 * 拷贝大文件的方法
	 * @param srcFile 源文件
	 * @param desFile 目标文件
	 */
	private static void copyBigFile(String srcFile, String destFile) {
		
		try {
			File srcFiles = new File(srcFile);
			File destFiles = new File(destFile);
			destFiles.setLastModified(srcFiles.lastModified());
			
			
			// 创建文件输入流
			FileInputStream in = new FileInputStream(srcFiles);
			// 创建文件输出流
			FileOutputStream out = new FileOutputStream(destFiles);
			// 定义读取内容的缓存区
			byte[] buffer = new byte[1024];
			// 定义记录长度的变量
			int len = 0;
			
			while((len = in.read(buffer)) != -1) {
				System.out.println(len);
				// 把循环读取到缓冲区中数据写入到目标文件中
				out.write(buffer, 0, len);
			}
			
			// 关闭流(谁最后使用就先关闭谁)
			out.flush();
			out.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
