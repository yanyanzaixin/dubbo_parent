package com.itcast;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class freemarkerDemo {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration=new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("D:\\develop\\Maven_Project\\dubbo_parent\\freemarkerdemo\\src\\main\\webapp"));
        configuration.setDefaultEncoding("utf-8");
        Template template=configuration.getTemplate("text.ftl");
        Map map=new HashMap();
        map.put("name","张三");
        map.put("message","欢迎使用freemarker");
        map.put("success",false);

        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);

        map.put("today",new Date());

        map.put("point",102986865);

        Writer out=new FileWriter(new File("D:\\test.html"));
        template.process(map,out);
        out.close();
    }

}
