package framework;

import framework.core.EAOSServer;

/**
 * @Author: CS-WYZ
 * @Date: Created in 15:58  2020/8/9
 * @Description: Jetty启动器
 */
public class EAOS {

    /**
     * 启动Jetty容器
     * @param args
     */
    public static void main(String[] args) throws Exception {
        EAOSServer server = new EAOSServer("/eaos",8080);
        server.start();
    }
}
