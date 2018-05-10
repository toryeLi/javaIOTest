package com.stream.demo.news.ui;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        System.out.println(scanner.next().equals("1"));
        System.out.println(scanner.next()=="1");
	}
   private static String getPathMethod01(){
	   String p=System.getProperty("user.dir");
	   System.out.println("方法一路径"+p);
	   return p;
   }
   private static void getPathMethod02(){
	   URL url=Test01.class.getResource("");
	   String p=url.getPath();
	   System.out.println("方法二"+p);
	   try{
		   System.out.println("方法二解码路径："+URLDecoder.decode(p,"UTF-8"));
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
   private static void getPathMethod03(){
	   URL url=Test01.class.getResource("/");
	   String p=url.getPath();
	   System.out.println("方法三路径"+p);
	   try{
		   System.out.println("方法三解码路径："+URLDecoder.decode(p,"UTF-8"));
	   }catch(Exception  ex){
		   ex.printStackTrace();
	   }
   }
   private static void getPathMethod04(){
	   try{
		   URI uri=Test01.class.getResource("/").toURI();
		   String p=uri.getPath();
		   System.out.println("方法四路径"+p);
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
}

