package com.stream.demo.news.manager;


import com.stream.demo.news.entity.News;

public interface NewsFunction {
	 int AddNews(News NewsList);
	  int deleteNews(int Id);
	  int updateNews(News n);
	  News queryById(int Id);
	  void queryNews();
}
