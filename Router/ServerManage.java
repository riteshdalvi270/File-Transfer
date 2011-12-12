import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import Dijkstras.*;

class ServerManage
{
	Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
	Hashtable<String,Integer>table= new Hashtable<String,Integer>();
	Hashtable<String,Hashtable>hash= new Hashtable<String,Hashtable>();
	LinkedList<String> list= new LinkedList();
	LinkedList<String> list1= new LinkedList();
	StringTokenizer st;
	StringTokenizer st1;
	String TTL;
	Integer cost;
	Integer value;
	int counter;
	String sourceIP;
	String line= System.getProperty("line.separator");
	String DestinationIP;
	String data="";
	Server server;
	String serverLSP="";
	MakeLog mk;
	String LSP;
	
	private List<Vertex> nodes = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	private Graph graph = new Graph(nodes, edges);
	
	public ServerManage(MakeLog mk)
	{
		this.mk= mk;
	}
	public void setServer(Server server)
	{
		this.server=server;
	}
	public void min() {
		DijkstraAlgorithm d = new DijkstraAlgorithm(graph);
		d.execute(nodes.get(0));
		Enumeration an3= table.keys();
		while(an3.hasMoreElements()) {
			LinkedList<Vertex> path = d.getPath(nodes.get(nodes.indexOf(new Vertex(an3.nextElement().toString()))));
			Iterator e = list.iterator();
			while(e.hasNext())
			{
				System.out.println("Lowest Cost:"+e.next());
			}	
		}
	}
	public void serverAdd(String LSP)
	{
		try
		{
				
				System.out.println("ServerManage started");
				mk.create("Server started"+" ");
				mk.attach(line);
				mk.attach("Received LSP"+" ");
				System.out.println("Server LSP:"+LSP);
				mk.attach("LSP:"+LSP+" ");
				st= new StringTokenizer(LSP);
			
				TTL= st.nextToken();
				System.out.println("SERVER TTL:"+TTL);
				mk.attach("Server TTL:"+TTL+" ");
				counter=new Integer(st.nextToken()).intValue();
				counter= counter-1;
				value= new Integer(counter);
				if(counter==0)
				{
					remove();
				
				}	
				else
				{
					System.out.println("SERVER VALUE:"+value);
					mk.attach("Server value:"+value+" ");
					ht.put(TTL,value);
					sourceIP= st.nextToken();
					System.out.println("SERVER SOURCEIP:"+sourceIP);
					mk.attach("Server SourceIP:"+sourceIP+" ");
					while(st.hasMoreTokens())
					{
						data=data+" "+st.nextToken();
						System.out.println("LOOP DATA:"+data);
						data= data+" "+ st.nextToken();
						System.out.println("Concatinated Data:"+data);
					}
					System.out.println("Server data:"+data);
					st1= new StringTokenizer(data);
				
					Pattern p = Pattern.compile("\\d*\\.\\d*\\.\\d*\\.\\d*");
					System.out.println(st1.hasMoreTokens());
				
					while(st1.hasMoreTokens())
					{
						DestinationIP= st1.nextToken();
						Matcher m = p.matcher(DestinationIP);
						System.out.println(m.matches());
						if(m.matches())
						{
				
				list.add(DestinationIP);
						}
						else
							list1.add(DestinationIP);
					}		
					Iterator e=list.iterator();
					Iterator en= list1.iterator();
					while(e.hasNext())
					{
						DestinationIP=e.next().toString();
						if(en.hasNext())
						{
							cost= new Integer(en.next().toString());
						}
							
							table.put(DestinationIP,cost);
					}		
					
					hash.put(sourceIP,table);
				}	
				
					display();
				
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void display()
	{
		try
		{
			Iterator e= list.iterator();
			Iterator en= list1.iterator();
			while(e.hasNext())
			{
				System.out.println("DestinationIP in server table:"+e.next());
			}
			while(en.hasNext())
			{
				System.out.println("Cost in server table:"+en.next());
			}
			
			Enumeration e1= table.keys();
			while(e1.hasMoreElements())
			{
				String destinationIP= e1.nextElement().toString();
				System.out.println("DestinationIP in hashServer:"+destinationIP);// this will gv you the destination
				if (!nodes.contains(new Vertex(destinationIP))) {
					nodes.add(new Vertex(destinationIP));
					graph = new Graph(nodes, edges);
				}
			}

			Enumeration en1= table.elements();
			while(en1.hasMoreElements())
			{
				System.out.println("Cost in hash ServerIP:"+en1.nextElement()); //this will gv you the cost
			}
			
			Enumeration enumerate= hash.keys();
			while(enumerate.hasMoreElements())
			{
				String source=enumerate.nextElement().toString();
				//System.out.println("SourceIP in server hash:"+enumerate.nextElement());
				if (!nodes.contains(new Vertex(source))) {
					nodes.add(new Vertex(source));
					graph = new Graph(nodes, edges);
				}
			}
			Enumeration enumerate1= hash.elements();
			while(enumerate1.hasMoreElements())
			{
				String LSPcontents= enumerate1.nextElement().toString();
				System.out.println("LSP contents in server has:"+LSPcontents);
				mk.attach("LSP Contents:"+LSPcontents+" ");
			
			}	
			
			Enumeration an= hash.keys();
			Enumeration an1= table.keys();
			Enumeration an2= table.elements();
			while(an.hasMoreElements())
			{
				String IP1= an.nextElement().toString();
				String IP2;
				int cost;
				while(an1.hasMoreElements())
				{
					IP2= an1.nextElement().toString();
					if(an2.hasMoreElements())
					{
						cost= new Integer(an2.nextElement().toString()).intValue();
						if (!edges.contains(new Edge(nodes.get(nodes.indexOf(IP1)), nodes.get(nodes.indexOf(IP2)), cost))) {
							edges.add(new Edge(nodes.get(nodes.indexOf(IP1)), nodes.get(nodes.indexOf(IP2)), cost));
						}
						
					}
				}
				graph = new Graph(nodes, edges);
			}	
			
			
		}
		catch(Exception e)
		{
			System.out.println("ServerManage calculating lowest cost");
		}
	}	

	public void remove()
	{
		try
		{
			Hashtable<String,Integer> tab= hash.remove(sourceIP);
		}
		catch(Exception e)
		{
			System.out.println("The LSP contents has been removed");
		}
	}	
	
	public String returnLSP()
	{
		LSP= TTL+value+sourceIP+data;
		return LSP;
	}	
		
}	