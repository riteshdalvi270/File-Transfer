import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.*;

public class RouterIP
{
	String sourceIP;
	int port;
	
	public RouterIP()
	{
		try
		{
			
			
			String lsp;
			String sourceIP;
			int port;
			int no;
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter IPAddress and port:");
			System.out.println("IPAddress:");
			sourceIP= scan.next();
			System.out.println("Port:");
			port= scan.nextInt();
								
			ServerManage sm;
			Server server;
			Configuration con;
			Client client;
			DataManage dm;
			LSP sp;
			UserInput user;
					
			MakeLog mk = new MakeLog();
			
			sm = new ServerManage(mk);
								
			server = new Server(port,sm,mk);
			sm.setServer(server);
								
								
			con= new Configuration(port);
								
			client= new Client(sourceIP,mk);
								
			server.setClient(client);
								
								
								
			dm = new DataManage(client);
								
			user= new UserInput(client,dm,sourceIP,server,sm,port);
								
			client.set(dm,user);
								
			sp= new LSP(sourceIP,port,dm);
								
								
									
								
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}	
		
	}
	
}	
		
	