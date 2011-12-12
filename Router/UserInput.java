import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Hashtable;

class UserInput
{
	String destinationIP;
	String cost;
	int port;
	String input;
	Scanner scan;
	String flag;
	Client client;
	DataManage dm;
	String sourceIP;
	Server server;
	ServerManage sm;
	Hashtable<String,Integer> table;
	Hashtable<String,Integer> table1;
	String newdata;
	String closeIP;
	
	public UserInput(Client client,DataManage dm, String sourceIP, Server server,ServerManage sm, int port)
	{
		this.client= client;
		this.dm=dm;
		this.sourceIP=sourceIP;
		this.server=server;
		this.sm=sm;
		this.port=port;
	}

	
	
	
		
	public synchronized void update()
	{
		try
		{
		
			scan = new Scanner(System.in);
		
			System.out.println("Do you want to call router Updater:Y/N");
			
			input= scan.next();
			
			if(input.equals("Y"))
			{
				flag="true";
				System.out.println("The sourceIP of  this computer:"+sourceIP);
				System.out.println("Enter the destinationIP of this computer:");
				destinationIP= scan.next();
				System.out.println("Enter the new cost of the destination:");
				
				cost= scan.next();
				newdata= sourceIP+" "+destinationIP+" "+cost;
				table= (Hashtable<String,Integer>)dm.ht1.get(sourceIP);
				
				System.out.println(table);
				
				Enumeration e= table.keys();
				while(e.hasMoreElements())
				{
					if(destinationIP.equals(e.nextElement()))
					{
						table.put(destinationIP,new Integer(cost));
						dm.ht1.put(sourceIP,table);
					}
				}	
				System.out.println(table);
				
			}
			else
			flag="false";
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("UserInput"+e);
		}
	}	
		
		public synchronized void sendToServer()
		{
			try
			{
				if(flag.equals("true"))
				{
					client.pw.println(flag);
					client.pw.println(newdata);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		
		
			
	

	
	
	
}	