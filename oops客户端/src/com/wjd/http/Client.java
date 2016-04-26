package com.wjd.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.wjd.common.Common;

public class Client implements Runnable{

	DataInputStream in;
	DataOutputStream out;
	static Socket s;
	boolean live = true;
	public Client(){
		try {
			s = null;
			s = new Socket(Common.ip,9800);
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			new Thread(this).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(live){
			try {
				receive();
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
	
	public void send(String talk){
		System.out.println(talk);
		try {
			out.writeUTF(talk);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void receive(){
		String s;
		try {
			s = in.readUTF();
			new Message().decomposition(s);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			live = false;
		}
	}
	
}
