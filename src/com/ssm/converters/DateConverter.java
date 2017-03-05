package com.ssm.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class DateConverter implements Converter<String, Date>{
	DateFormat[] dateFormat=new SimpleDateFormat[]{
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yyyy年MM月dd日"),
			new SimpleDateFormat("yyyy.MM.dd")
	};

	@Override
	public Date convert(String str) {
		Date date=null;
		if(StringUtils.hasLength(str)){
			for (DateFormat dateFormat2 : dateFormat) {
				try {
					date = dateFormat2.parse(str);
				} catch (ParseException e) {
					continue;
				}
			}
			return date;
		}
		return null;
	}
	
}
