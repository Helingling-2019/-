package com.界面;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.Client.TPingClient;

public class MainJFrame extends JFrame {
	public MainJFrame() {
		setTitle("直播间");
		setBounds(400, 100, 400, 500);
		
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 System.exit(0);
			 }
		});
	}
   
	public static void main(String[] args) {
		MainJFrame jf = new MainJFrame();
		Graphics g=jf.getGraphics();
		while(true) {
			Socket client;
			try {
				client = new Socket("173.16.23.250",8080);
				System.out.println("連接上了");
				InputStream in=client.getInputStream();
				Image img=ImageIO.read(in);
				g.drawImage(img, 0, 0,jf.getWidth(),jf.getHeight(), null);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				client.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
  
// class drawIconTherad extends Thread{
//	public void run() {
//		try {
//			while(true) {
//				Socket client = new Socket("127.0.0.1",8080);
//				InputStream in =client.getInputStream();
//				Image img =ImageIO.read(in);
//				Graphics g=	getGraphics();
//				g.drawImage(img, 0, 0, getWidth(),getHeight(),null);
//				try {
//					Thread.sleep(40);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
}
	}