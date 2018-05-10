package com.stream.demo.news.ui;


import java.util.Date;
import java.util.Scanner;

import com.stream.demo.news.entity.News;
import com.stream.demo.news.manager.NewsFunction;
import com.stream.demo.news.manager.NewsManager2;

public class NewsUi {
public static void main(String[] args) {
	NewsFunction newsFunc=new NewsManager2();
	boolean bo=true;
	Scanner scan=new Scanner(System.in);
	while(bo){
		System.out.println("欢迎使用新闻系统v2");
		System.out.println("1添加新闻");
		System.out.println("2删除新闻");
		System.out.println("3修改新闻");
		System.out.println("4查询新闻");
		System.out.println("0退出系统");
		String str= scan.next();
		switch(str){
		case"1":
			News news=new  News();
			System.out.println("请输入新闻标题");
			news.setBiaoTi(scan.next());
			System.out.println("请输入作者");
			news.setZuoZhe(scan.next());
			System.out.println("请输入内容");
			news.setNeiRong(scan.next());
			news.setCreateDate(new Date());
			newsFunc.AddNews(news);
			break;
		case"2":
			System.out.println("请输入要删除的新闻Id");
			 int isOk= newsFunc.deleteNews(Integer.parseInt(scan.next()));
		    System.out.println(isOk==0?"删除失败":"删除成功");
			break;
		case"3":
			System.out.println("请输入要修改的新闻Id");
			News news1=newsFunc.queryById(Integer.parseInt(scan.next()));
			if(news1==null){
				System.out.println("不存在该新闻");
			}else{
				boolean isUpdate=false;
				System.out.println("要修改的新闻是\r\t"+news1.toString());
				System.out.println("是否要修改新闻标题，0 否 1 是");
				if(scan.next().equals("1")){
				 System.out.println("请输入要修改的新闻标题");
				news1.setBiaoTi(scan.next());
				isUpdate=true;
				}
				System.out.println("是否要修改作者，0 否 1 是");
				if(scan.next().equals("1")){
					System.out.println("请输入要修改的作者");
				news1.setZuoZhe(scan.next());
				isUpdate=true;
				}
				System.out.println("是否要修改内容 0 否 1 是");
				if(scan.next().equals("1")){
				System.out.println("请输入要修改的内容");
				news1.setNeiRong(scan.next());
				isUpdate=true;
				}
				if(isUpdate){
				int isOk2= newsFunc.updateNews(news1);
				System.out.println(isOk2==0?"修改失败":"修改成功");}
			}
			break;
		case"4":
			newsFunc.queryNews();
			break;
		default :bo=false;  break;
		}
	}
}
}
