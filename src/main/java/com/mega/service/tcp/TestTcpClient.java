package com.mega.service.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.mega.service.common.Constant;

public class TestTcpClient {

	public static void main(String[] args) {
		try {
			// 创建Socket对象
			Socket socket = new Socket("127.0.0.1", Constant.SOCKET_PORT);

			// 根据输入输出流和服务端连接
			OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
			PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
			printWriter.print("201,0,1,2,3,4,5,6,7,4,3,2,24,2,3,5,2");
			printWriter.flush();
			socket.shutdownOutput();// 关闭输出流

			InputStream inputStream = socket.getInputStream();// 获取一个输入流，接收服务端的信息
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);// 包装成字符流，提高效率
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 缓冲区
			String info = "";
			String temp = null;// 临时变量
			while ((temp = bufferedReader.readLine()) != null) {
				info += temp;
				System.out.println("客户端接收服务端发送信息：" + info);
			}

			// 关闭相对应的资源
			bufferedReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}