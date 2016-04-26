import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client implements Runnable{
	Socket s;
	Main main;
	DataInputStream in;
	DataOutputStream out;
	boolean live = true,receive = false;
	public Client(Socket s,Main main){
		this.s = s;
		this.main = main;
		try {
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			new Thread(this).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Receiver(){
		String str;
		try {
			if(!s.isClosed()){
				str = in.readUTF();
				new Message().decomposition(str,this);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			live = false;
		}
	}
	
	public void sendUTF(String data){
		if(!s.isClosed()){
			try {
				out.writeUTF(data);
				out.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		try {
			out.close();
			in.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(live){
			try {
				Thread.sleep(100);
				Receiver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				live = false;
				break;
			}
		}
	}
	
}
