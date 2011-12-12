import java.net.*;
import java.util.regex.*;
import java.io.*;
public class IPReceiver extends Thread {
	private ChunkQueue cq;
	private int port;
	public IPReceiver(int port, ChunkQueue cq) throws Exception {
		super();
		this.port = port;
		this.cq = cq;
		start();
	}
	public void addChunk(byte[] ba, String name) {
		cq.addChunk(ba, name);
	}
	public ChunkQueue getCQ() {
		return this.cq;
	}
	public void run() {
		try {
		Pattern p = Pattern.compile("(.*?)\\s(.*?)");
		cq = this.getCQ();
		MakeLog mk= new MakeLog();
		Matcher m;
		ServerSocket ss = new ServerSocket(port);
		while (true) {
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = br.readLine();
			mk.attach("Received:"+line);
			m = p.matcher(line);
			if (m.matches()) {
				String fn = m.group(1);
				int size = Integer.parseInt(m.group(2));
				byte[] ba = new byte[size];
				int r = is.read(ba, 0, ba.length);
				addChunk(ba, fn);
			}
			s.close();
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}