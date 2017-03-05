package com.ssm.converters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.ssm.entity.PhoneNumber;

public class PhoneNumberConverter implements Converter<String, PhoneNumber>{

	@Override
	public PhoneNumber convert(String str) {
		Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");
		PhoneNumber phoneNumber=null;
		if(StringUtils.hasLength(str)){
			Matcher matcher=pattern.matcher(str);
			if(matcher.matches()){
				String areaNumber=matcher.group(1);
				String telNumber=matcher.group(2);
				phoneNumber=new PhoneNumber(areaNumber,telNumber);
				return phoneNumber;
			}
		}
			return null;
			
	}	
}
