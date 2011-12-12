import java.net.*;
import java.util.*;
import java.io.*;

class Server extends Thread
{
	int port;
	String IP;
	String closeIP;
	String details;
	ServerSocket socket;
	String LSP;
	String active="";
	Socket s;
	StringTokenizer st;
	ServerManage sm;
	boolean flag;
	Client client;
	String add;
	String newdata;
	StringTokenizer stn;
	MakeLog mk;
	Hashtable<String,Integer> table;
	String destinationIP;
	String cost;
	String line= System.getProperty("line.separator");
	
	
	public Server(int port, ServerManage sm,MakeLog mk)
	{
		super();
		this.sm=sm;
		this.mk=mk;
		
		this.port=port;
		this.start();
	}
	
	public synchronized void run()
	{
		try
		{
			System.out.println("Server started:");
			socket= new ServerSocket(port);
			socket.setReuseAddress(true);
			while(true)
			{
				s= socket.accept();
				System.out.println(s.isClosed());
				System.out.println("Client accepted");
				InputStream is= s.getInputStream();
				BufferedReader br= new BufferedReader(new InputStreamReader(is));
				PrintWriter pw= new PrintWriter(s.getOutputStream(),true);
				
				LSP= br.readLine();
				pw.println("send");
				System.out.println("Server LSP:"+LSP);
				mk.attach("Server LSP:"+LSP+" ");
			    active=""+ br.readLine();
				System.out.println(active);
				String flag;
				flag= br.readLine();
				System.out.println("Flag"+flag);
				if(flag.equals("true"))
				{
					newdata= br.readLine();
					System.out.println(newdata);
					System.out.println("Received new data");
					
				}
			
				st= new StringTokenizer(LSP);
				
				String IPdata= LSP.substring(7);
				//System.out.println("IPdata"+IPdata);
				
				sm.serverAdd(LSP);
				LSP= sm.returnLSP();
				mk.attach("Received Updated data:"+LSP+" ");
				//System.out.println("Returned LSP:"+LSP);
				System.out.println("Back to server");
				
					//System.out.println(LSP);
					System.out.println(st.hasMoreTokens());
					details= st.nextToken()+" "+st.nextToken();
					System.out.println(st.hasMoreTokens());
					System.out.println(details);
					while(st.hasMoreTokens())
					{
						add= st.nextToken();
						IP=IP+" "+add;
					}
						//System.out.println(IP);
						System.out.println("IPDATA:"+IPdata);
						//System.out.println(LSP);
					if(flag.equals("true"))
					{	
						StringTokenizer stn;
					
						stn= new StringTokenizer(newdata);
						String sourceIP;
						sourceIP= stn.nextToken();
						
						table= (Hashtable<String,Integer>)sm.hash.get(sourceIP);
						System.out.println("tabletest");
						Enumeration e= table.keys();
						destinationIP= stn.nextToken();
						cost= stn.nextToken();
						if(destinationIP.equals(e.nextElement()))
						{
							table.put(destinationIP,new Integer(cost));
							sm.hash.put(sourceIP,table);
						}
						System.out.println(table);
						mk.attach("Updated LSP contents:"+table+" ");
					}
				
				
				
				System.out.println("Server works");
		
				
				//s.close();
				
				//socket.close();
				//System.out.println("Client is closed:"+s.isClosed());
				//System.out.println("Sever is Closed:"+socket.isClosed());
				
				if(client!=null)
				{
					System.out.println("Client not null:"+client);
					client.resend(LSP);
				}	
					sm.min();			
				
				
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Server is already started");
		}	
	}
	
	public void setClient(Client client)
	{
		this.client=client;
	}	
	
	
	
	
	
}