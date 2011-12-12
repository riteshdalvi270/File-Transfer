import java.util.Scanner;
import java.util.regex.*;
import java.io.*;
public class FileTransfer implements CQListener{
	ChunkQueue cq;
	IPReceiver ipr;
	int port1;
	public static void main (String[] sa) throws Exception{
		FileTransfer ft = new FileTransfer(sa);
		
	}
	public FileTransfer(String sa[]) throws Exception{
		MakeLog mk = new MakeLog();
		System.out.println("Enter Port number:");
		int n;
		Scanner scan = new Scanner(System.in);
		port1= scan.nextInt();
		Scanner s = new Scanner(System.in);
		cq = new ChunkQueue();
		cq.addCQListener(this);
		ipr = new IPReceiver(port1, cq);
		String command = s.nextLine();
		while (!command.equals("quit")) {
			Pattern p = Pattern.compile("(.*?)\\s(.*?)\\s(.*?)");
			Matcher m = p.matcher(command);
			if(m.matches()) {
				if(m.group(1).equals("send")) {
					mk.attach(command);
					File file = new File(m.group(2));
					byte[] ba = new byte[(int) file.length()];
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
					bis.read(ba, 0, ba.length);
					IPForwarder ipf = new IPForwarder(m.group(3), Integer.parseInt(sa[0]), ba, file.getName());
				} else {
					System.out.println("Wrong Command Try Again " + m.group(1));
				}
			}
			command = s.nextLine();
		}
	}
	public void CQActionPerformed() {
			try {
				if (ipr.getCQ().size() > 0) {
					byte[] ba = (byte[])cq.poll();
					String fn = cq.pollName();
					FileOutputStream fos = new FileOutputStream("Received\\" + fn);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bos.write(ba, 0, ba.length);
					bos.close();
					System.out.println("File \'" + fn + "\' Received Successfully");
				}
			} catch (Exception e) {
				
			}
	}
}