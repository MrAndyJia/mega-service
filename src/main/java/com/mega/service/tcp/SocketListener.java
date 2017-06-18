package com.mega.service.tcp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 设置监听，让tcpSocket配置随服务启动
 * @author Andy
 *
 */
public class SocketListener implements ServletContextListener {

	private SocketThread socketThread = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if(null == socketThread){
			socketThread = new SocketThread(null);
			socketThread.start();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if(null!=socketThread && !socketThread.isInterrupted()){
			socketThread.closeSocket();
			socketThread.interrupt();
		}
	} 
	
	
}
