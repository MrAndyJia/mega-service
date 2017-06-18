package com.mega.service.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.mega.service.common.Constant;

/**
 * Socket多线程处理类 用来处理服务端接收到的客户端请求（处理Socket对象）
 */
public class SocketThread extends Thread {

	private ServerSocket serverSocket = null;

	public SocketThread(ServerSocket serverSocket) {
		if(null == serverSocket){
			try {
				this.serverSocket = new ServerSocket(Constant.SOCKET_PORT);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		while(!this.isInterrupted()){
			try {
				Socket socket = serverSocket.accept();
				//处理接收的数据
				if(null != socket && !socket.isClosed()){
					new SocketOperate(socket).start();
				}
				socket.setSoTimeout(30000);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
	}

	public void closeSocket() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}