package framework.core;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.BindException;

/**
 * @Author: CS-WYZ
 * @Date: Created in 13:29  2020/8/9
 * @Description:
 */
public class EAOSServer {
    /**
     *监听端口 缺省8080
     */
    private int port = 8080;

    /**
     *上下文
     */
    private String webContext = "/";


    public void setPort(int pport){
        this.port = pport;
    }

    public void setWebContext(String pwebContext){
        this.webContext = pwebContext;
    }

    public EAOSServer(){

    }

    /**
     *有参构造器
     */
    public EAOSServer(String pwebContext,int pport){
        setPort(pport);
        setWebContext(pwebContext);
    }

    public void start() throws Exception{
//        long start =  System.currentTimeMillis();
        final String  webRoot = System.getProperty("user.dir")+"/web";
        Server server = new Server();
        //JVM退出时关闭Jetty hook
        server.setStopAtShutdown(true);
        NetworkTrafficSelectChannelConnector connector = new NetworkTrafficSelectChannelConnector(server);

        connector.setReuseAddress(false);
        connector.setPort(this.port);
        server.setConnectors(new Connector[]{connector});
        WebAppContext context = new WebAppContext();
        context.setResourceBase(webRoot);
        context.setContextPath(webContext);
//        表单提交大小
        context.setMaxFormContentSize(10000000);
        context.setParentLoaderPriority(true);
        server.setHandler(context);

        try {
            server.start();
        }catch (BindException e){
            e.printStackTrace();
        }

    }

}
