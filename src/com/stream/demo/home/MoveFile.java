package com.stream.demo.home;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MoveFile {
	/**
	 * 目标文件目录
	 */
	private static String destPath;
	/**
	 * 要移动的文件目录
	 */
	private static String movePath;

	public static void main(String[] args) {
		try {
System.out.println("此程序流程是：\n\r1： 获取系统盘符，在系统的第二个盘符上新建 目标文件a2,和要移动的文件a\n\r 2： 在a目录自动新建多级子目录，并写入文件，写入文件使用多线程 \n\r 3: 移动a目录下的文件到a2目录。程序结束  ");
			lookView();
			createDirectory();// 创建目录
			MoveFile mf = new MoveFile();
			mf.createMoveFile();
			System.out.println("初建目录及文件成功，是否开始移动a目录下的文件：移动 yes 不移动 no");
			Scanner scanner=new Scanner(System.in);
			if( scanner.next().equals("yes")){
			moveFileHome(movePath, destPath);}
			scanner.close();
			System.out.println(movePath);
			System.out.println(destPath);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void moveFileHome(String moverPath2, String destPath2) {
		File strFile = new File(moverPath2);
		File[] files = strFile.listFiles();
		if (files != null && files.length > 0) {
			for (File file :files) {
				String targetPath = file.getAbsolutePath().replace(
						movePath, destPath);
				File file1 = new File(targetPath);
				if (file.isDirectory()) {
					if (!file1.exists()) {
						file1.mkdirs();
					}
					moveFileHome(file.getAbsolutePath(), destPath);
				} else {
					copyFile(file.getPath(), file1.getPath());
				}
				System.out.println("要删除的目录是："+file.getPath());
				file.delete();
			}
			strFile.delete();
		}
	}
/**
 * 
 * @param descFile  
 * @param moveFile1
 */
	public static void copyFile(String descFile, String moveFile1) {

		File strFile = new File(descFile);
		// System.out.println("要删除的文件："+descFile.getPath()+";"+descFile.delete());

		try (BufferedInputStream read = new BufferedInputStream(
				new FileInputStream(strFile));
				BufferedOutputStream write = new BufferedOutputStream(
						new FileOutputStream(moveFile1));) {
			byte[] data = new byte[1024];
			int len = 0;
			while ((len = read.read(data)) != -1) {
				write.write(data, 0, len);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 是否存在 目标文件目录和要移动的文件目录，如果不存在则创建
	 */
	public static void createDirectory() {
		if (destPath != null && movePath != null) {
			File destFile = new File(destPath);
			File moveFile = new File(movePath + "/b/C");
			File moveFile2 = new File(movePath + "/b2/C2");
			boolean isDestPath = true;
			boolean isMovePaht = true;
			if (!destFile.exists()) {
				destFile.mkdirs();
				if (destFile.exists()) {
					System.out.println("目标文件：" + destFile.getPath() + "创建成功");
				} else {
					isDestPath = false;
				}
			}
			if (!moveFile.exists()) {
				moveFile.mkdirs();
				if (moveFile.exists()) {
					System.out.println("要移动的文件目录：" + moveFile.getPath()
							+ "创建成功");
				} else {
					isMovePaht = false;
				}
			}
			if (!moveFile2.exists()) {
				moveFile2.mkdirs();
				if (moveFile2.exists()) {
					System.out.println("要移动的文件目录：" + moveFile2.getPath()
							+ "创建成功");
				} else {
					isMovePaht = false;
				}
			}
			if (isDestPath && isMovePaht) {
			}
		}
	}

	/**
	 * 多线程创建文件
	 */
	public void createMoveFile() {
		File file = new File(movePath);
		System.out.println(file.getPath());
		if (file.isDirectory()) {
			File file2 = new File(file.getPath() + "/第一层.txt");

			File file3 = new File(file.getPath() + "/b/第二层.txt");
			File file5 = new File(file.getPath() + "/b/第二层2.txt");

			File file4 = new File(file.getPath() + "/b/c/第三层.txt");
			Thread t1 = new Thread(new MyRunnable(file2));
			Thread t2 = new Thread(new MyRunnable(file3));
			Thread t3 = new Thread(new MyRunnable(file4));
			Thread t5 = new Thread(new MyRunnable(file5));
			t1.start();
			t2.start();
			t3.start();
			t5.start();
			try {
				t1.join();
				t2.join();
				t3.join();
				t5.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("文件创建成功" + movePath);
		} else {
			System.out.println("不是文件夹" + movePath);
		}
	}

	/**
	 * 查看系统盘符，并将系统的第二个盘符作为创建目标文件夹和要移动的文件夹的路径，并赋值
	 * 
	 * @return
	 */
	public static boolean lookView() {
		File[] roots = File.listRoots();
		for (int i = 0; i < roots.length; i++) {
			System.out.println("系统盘符有：" + roots[i]);
		}
		if (roots.length >= 2) {
			destPath = roots[1].getPath() + "a2";
			movePath = roots[1].getPath() + "a";
			System.out.println("目标文件目录destPath：" + destPath
					+ ",要移动的文件目录movePath：" + movePath);
			return true;
		} else {
			System.out.println("没有第二个盘符");
			return false;
		}
	}

	public class MyRunnable implements Runnable {
		private File file;

		public MyRunnable(File file) {
			this.file = file;
		}

		@Override
		public void run() {
			OutputStreamWriter write = null;
			// TODO Auto-generated method stub
			try {
				System.out.println(file.getPath());
				write = new OutputStreamWriter(new FileOutputStream(file));
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 2; j++) {
						write.write(Thread.currentThread().getId()
								+ "使用OutputStringWrite插入数据,i=" + i + ";j=" + j
								+ "\t\n");
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					write.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
