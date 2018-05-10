package com.stream.demo.news.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.stream.demo.news.entity.News;
public class NewsManager2 implements NewsFunction {
	// 问题1：路径中文乱码问题，未解决
	// 如果路径有中文，路径会有乱码
	public static final String PATH_STR = NewsManager2.class.getResource("/")
			.getPath() + "/newsData.txt";
	// 没有乱码但编译不过去
	// public static final String
	// PATH_STR=NewsManager2.class.getResource("/").toURI().getPath()+
	// "/newsData.txt";
	List<News> newsList = null;
	{
		try {
			System.out.println(PATH_STR);
			File file = new File(PATH_STR);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				if (fis.available() != 0) {
					ObjectInputStream in = new ObjectInputStream(fis);
					Object o = in.readObject();
					if (o instanceof List<?>) {
						newsList = (List<News>) o;
					} else {
						file.delete();
						file.createNewFile();
					}
					in.close();
				} else {
					newsList = new LinkedList<News>();
					System.out.println("为null");
				}
				fis.close();
			} else {
				System.out.println(file.createNewFile() ? "创建成功" : "创建失败");
				newsList = new LinkedList<News>();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 更新数据
	 */
	private void saveNews() {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(
					new FileOutputStream(new File(PATH_STR)));
			os.writeObject(newsList);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int AddNews(News news) {
		news.setId(newsList.size() + 1);
		newsList.add(news);
		saveNews();
		System.out.println("添加了一条数据");
		return 1;
	}
/**
 * 返回0，失败
 * 返回1，成功
 */
	@Override
	public int deleteNews(int Id) {
		// TODO Auto-generated method stub
		int index = -1;
		for (News news : newsList) {
			if (news.getId().intValue() == Id) {
				index = newsList.indexOf(news);
				break;
			}
		}
		if (index != -1) {
			newsList.remove(index);
			saveNews();
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int updateNews(News n) {
		// TODO Auto-generated method stub
		if (n != null) {
			for (News news : newsList) {
				if (n.getId() == n.getId()) {
					news.setBiaoTi(n.getBiaoTi());
					news.setCreateDate(n.getCreateDate());
					news.setNeiRong(n.getNeiRong());
					news.setZuoZhe(n.getZuoZhe());
					break;
				}
			}
			saveNews();
			return 1;
		}
		return 0;
	}

	@Override
	public News queryById(int Id) {
		for (News news : newsList) {
			if(news.getId().intValue()==Id){
				return news;
			}
		}
		return null;
	}

	@Override
	public void queryNews() {
		System.out.println("Id\t\t作者\t\t新闻标题\t\t新闻时间\t\t新闻内容");
		for (News news : newsList) {
			System.out.println(news.getId()+"\t\t"+news.getZuoZhe()+"\t\t"+news.getBiaoTi()+"\t\t"+new SimpleDateFormat("yyyy-MM-dd HH:ss").format(news.getCreateDate())+"\t\t"+news.getNeiRong() );
		}
	}

	
}
