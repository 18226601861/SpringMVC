package com.springmvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class AppTomcat {
    public static void main(String[] args) throws ServletException, LifecycleException {
        start();
    }

    public static void start() throws ServletException, LifecycleException {
        //创建tomcat容器
        Tomcat tomcatServer=new Tomcat();
        //设置tomcat端口
        tomcatServer.setPort(8080);
        //读取项目路径，加载静态资源
        StandardContext standardContext= (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());
        //是否设置自动部署
        standardContext.setReloadable(false);
        //class文件读取地址
        File file=new File("traget/classes");
        //创建webroot
        WebResourceRoot resource=new StandardRoot(standardContext);
        //tomcat内部读取class执行
        resource.addPreResources(new DirResourceSet(resource,"/WEB-INF/classes",file.getAbsolutePath(),"/"));
        tomcatServer.start();
        //异步进行接受请求
        tomcatServer.getServer().await();
    }
}
