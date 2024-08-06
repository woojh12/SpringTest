package com.dnjh.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notice {
	private String title;
	private String user;
	private String content;
	
	private Map<String, String> map = new HashMap<>();
	
	public Notice(String title, String user, String content)
	{
		this.title = title;
		this.user = user;
		this.content = content;
		
		map.put("title", title);
		map.put("user", user);
		map.put("content", content);
		
		map = new HashMap<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	
	
}
