package com.ssm.cxfService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IHelloWorldService {
	@WebMethod
	public String helloWorld(@WebParam String word);
}
