import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Main extends Frame {

	public static final int BOARD_WIDTH = 540;
    public static final int BOARD_HEIGHT = 570;
    public static final int X_LOCATION = 100;
    public static final int Y_LOCATION = 50;
    private static final int port = 9800;
    //把节目分为上中三个Panel
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    //按钮
    JButton startButton = new JButton("开始服务");
    ArrayList<Client> c = new ArrayList<Client>();
	ServerSocket ss;
	Socket client;
	 
    public void launchFrame() throws Exception{        
        //界面初始化
        this.setLocation(X_LOCATION, Y_LOCATION);
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new GridLayout(3,1)); //总体为三行一列布局
        this.add(northPanel);
        this.add(centerPanel);
        this.add(southPanel);
        
        centerPanel.setLayout(new FlowLayout());
        southPanel.setLayout(new FlowLayout());
        southPanel.add(startButton);
        ss = new ServerSocket(port);
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new Thread(new Server()).start();
            }
        });
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing (WindowEvent e){
            	for(int i = 0 ; i < c.size(); i++){
            		Client client = c.get(i);
            		client.shutdown();
            	}
            	c.clear();
                System.exit(0);
            }
        });    
    }
    
    class Server implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					Thread.sleep(100);
					try{
                		client = ss.accept();
                		//System.out.println("有敌情");
                		c.add(new Client(client,Main.this));
                		//new Thread(new Handle(client)).start();
	            	}catch(Exception ex){
	            		break;
	            	}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
		}
    	
    }
    
    public static void main(String[] args)throws Exception {
         new Main().launchFrame();
    }

}
