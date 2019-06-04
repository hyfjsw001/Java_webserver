package ctthyf.字节流;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class BitServer {
public static void main(String[] args) throws IOException {
	ServerSocket ss=new ServerSocket(65501);
	while(true) {
	Socket s =ss.accept();
	new Thread(new BitUserThread(s)).start();
	
	}
	
}
}
