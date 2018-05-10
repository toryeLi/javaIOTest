package com.stream.demo.news.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String biaoTi;
	private String neiRong;
	private String zuoZhe;
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBiaoTi() {
		return biaoTi;
	}

	public void setBiaoTi(String biaoTi) {
		this.biaoTi = biaoTi;
	}

	public String getNeiRong() {
		return neiRong;
	}

	public void setNeiRong(String neiRong) {
		this.neiRong = neiRong;
	}

	public String getZuoZhe() {
		return zuoZhe;
	}

	public void setZuoZhe(String zuoZhe) {
		this.zuoZhe = zuoZhe;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "作者："+this.getZuoZhe()+"\t\t标题："+this.getBiaoTi()+"\t\t新闻创建时间："+new SimpleDateFormat("yyyy-MM-dd HH:ss").format(this.getCreateDate())+"\t\t新闻内容："+this.getNeiRong();
	}

}
