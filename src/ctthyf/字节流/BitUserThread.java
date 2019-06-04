package ctthyf.字节流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BitUserThread implements Runnable {
	private Socket s;
	
	public BitUserThread(Socket s) {		
		this.s = s;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		BufferedInputStream bis=new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("src\\ctthyf\\字节流\\received\\hyf.jpg"));
		byte[] bys=new byte[1024];
		int len=0;
		while((len=bis.read(bys))!=-1){
			bos.write(bys,0,len);
			bos.flush();
		}
		bos.close();
		//gei反馈
		OutputStream os=s.getOutputStream();
		os.write("文件接收完毕".getBytes());
		os.close();
		s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
