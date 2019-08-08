package com.rqy.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/6 21:23
 */
public class String2DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=sdf.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
