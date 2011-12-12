import java.net.*;
import java.io.*;
import java.util.*;
import java.net.Socket.*;
import java.util.regex.*;
import java.util.StringTokenizer;

class Client extends Socket
{	
	String IP;
	int port;
	StringTokenizer st;
	String TTL;
	String TTLvalue;
	String DestinationIP;
	String connectionclose;
	String receiveLSP="";
	Scanner scan;
	boolean flag;
	boolean sendFlag=false;;
	Socket s;
	OutputStream os;
	PrintWriter pw;
	String LSP;
	DataManage dm;
	Hashtable<String,Integer> table;
	String sourceIP;
	String SourceIP;
	int counter=0;
	UserInput user;
	String routersourceIP;
	MakeLog mk;
	String line= System.getProperty("line.separator");
	
	
	
	
	String separator= System.getProperty("line.separator");
	
	
	
	
	public Client(String SourceIP,MakeLog mk) {
		super();
		this.routersourceIP= SourceIP;
		this.mk= mk;
		
	}
	
	public void connect(String LSP,String IP,int port)
	{
		try
		{
				
				this.LSP=LSP;
				this.IP=IP;
				this.port=port;
				//System.out.println("Client:"+LSP);
				//System.out.println("Only IP:"+IP);
				st= new StringTokenizer(IP);
				String sourceIP= st.nextToken();
				while(st.hasMoreTokens())
				{
					
					DestinationIP= st.nextToken();
					
					System.out.println(separator);
					//System.out.println("Client connect destinationIP:"+DestinationIP);
					mk.attach(line);
					mk.attach("Client connect destinationIP:"+DestinationIP+" ");
					mk.attach(line);
					clientwrite(DestinationIP,LSP,port);
					
					
				}	
					
				
			
				
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void clientwrite(String DestinationIP,String LSP,int port)
	{
		try
		{
			
			
				counter++;
				System.out.println("Entering in client");
				mk.attach("Entering in client"+ " ");
				mk.attach(DestinationIP+" ");
				mk.attach(line);
				//System.out.println(DestinationIP);
				s = new Socket(DestinationIP,port);
				s.setReuseAddress(true);
				//System.out.println("Client connected");
				os=s.getOutputStream();
				pw= new PrintWriter(os,true);
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
				System.out.println("Client is closed?:"+s.isClosed());
				pw.println(LSP);
				String serverdata= br.readLine();
				System.out.println("ServerData:"+serverdata);
				pw.println("Active");
				user.update();
				user.sendToServer();
				pw.println("Still active");
				s.close();
				System.out.println("Client is closed after sending active"+s.isClosed());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}	
	
	public void resend(String LSP)
	{
		
		
		sendFlag=true;
		receiveLSP=LSP;
		System.out.println("Resend LSP:"+LSP);
		mk.attach("Resend LSP:"+LSP+ " ");
		//System.out.println(DestinationIP);
		
		Enumeration en= dm.ht1.keys();
		while(en.hasMoreElements())
		{
			sourceIP=en.nextElement().toString();
		}	
		//System.out.println(sourceIP);
		table=(Hashtable<String,Integer>)dm.ht1.get(sourceIP);
		Enumeration e= table.keys();
		while(e.hasMoreElements())
		{
			DestinationIP=e.nextElement().toString();
			//System.out.println("Destination:"+DestinationIP);
			//System.out.println("ReceiveLSP:"+receiveLSP);
			//System.out.println("Port:"+port);
			clientwrite(DestinationIP,receiveLSP,port);
		}	
		
	}
	
	
	public void set(DataManage dm, UserInput user)
	{
		this.dm=dm;
		this.user=user;
	}	
	
	
	
}