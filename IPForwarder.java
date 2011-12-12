import java.net.*;
import java.io.*;
public class IPForwarder extends Socket {
	byte[] ba;
	public IPForwarder(String ip, int port, byte[] ba, String fn) throws Exception{
		super(ip, port);
		this.ba = ba;
		OutputStream out = getOutputStream();
		PrintWriter pw = new PrintWriter(out, true);
		pw.println(fn + " " + ba.length);
		out.write(ba, 0, ba.length);
		out.flush();
		close();
		System.out.println("File \'" + fn + "\' Sent Successfully");
	}
}