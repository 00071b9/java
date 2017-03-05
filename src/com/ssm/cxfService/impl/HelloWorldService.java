package com.ssm.cxfService.impl;

import com.ssm.cxfService.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {

	@Override
	public String helloWorld(String word) {
		System.out.println("这是来自服务器的信息："+word);
		return "这是来自客户端的信息："+word;
	}

}
