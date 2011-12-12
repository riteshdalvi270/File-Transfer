import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.Object.*;
import java.util.Dictionary;
import java.util.Hashtable;


class DataManage
{
	LinkedList<String> list= new LinkedList();
	Hashtable<String,Integer> ht= new Hashtable<String,Integer>();
	Hashtable<String,Hashtable> ht1= new Hashtable<String,Hashtable>();
	Integer value;
	String data;
	Hashtable<String,Integer> table;
	Client client;
	String sourceIP;
	int port;
	String LSP;
	String serverIP;
	String cost;
	String clientIP;
	String IP;
	
	public DataManage(Client client)
	{
		this.client=client;
		
	}	
	public void add(String data)
	{
		try
		{
			this.data= data;
			list.add(data);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void hashAdd1(String IP, Hashtable<String,Integer> table)
	{
		try
		{
			this.data=IP;
			this.table= table;
			ht1.put(data,table);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public Hashtable hashAdd(String IP, Integer value)
	{
		try
		{
			this.data= IP;
			this.value= value;
			ht.put(IP,value);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(ht);
	}	

	
	
	public void send(String SIP,int port)
	{
		try
		{
			this.sourceIP=SIP;
			this.port=port;
			System.out.println("Send:"+this.sourceIP);
			Iterator iterate= list.iterator();
			while(iterate.hasNext())
			{
				LSP= iterate.next().toString();
				LSP= LSP+" "+iterate.next().toString();
			}
				//System.out.println("LSP contents:"+LSP);
				
			Enumeration en= ht1.keys();
			while(en.hasMoreElements())
			{
				
				clientIP= en.nextElement().toString();
				LSP= LSP+" "+clientIP;
				//System.out.println("keys:"+clientIP);
			
				IP=clientIP;
			}
			//System.out.println("LSP:"+LSP);
			
			table=(Hashtable<String,Integer>) ht1.get(sourceIP);
			//System.out.println("Table:"+table);
			Enumeration key= table.keys();
			while(key.hasMoreElements())
			{
				serverIP= key.nextElement().toString();
				while(key.hasMoreElements())
				{
					serverIP=serverIP+" "+key.nextElement().toString();
					
					
				}
			}
			IP= IP + " "+serverIP;
			LSP=LSP+" "+serverIP;
			
			Enumeration value= table.elements();
			while(value.hasMoreElements())
			{
				
				cost= value.nextElement().toString();
				LSP= LSP+" "+cost;
				//System.out.println(cost);
				
			}	
			//System.out.println("DataManage:Only IP-"+IP);
			System.out.println("LSP:"+LSP);
			
			
			client.connect(LSP,IP,this.port);
			
		}
		catch(Exception e)
		{
			System.out.println("Error in hashtable:"+e);
		}
		
		
	}
			
	
	
	
	
}