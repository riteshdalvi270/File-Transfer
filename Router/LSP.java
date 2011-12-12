import java.net.*;
import java.io.*;
import java.util.*;
class LSP
{
	String packet;
	StringTokenizer st;
	DataManage dm;
	String SourceIP;
	String DestinationIP;
	Hashtable<String,Integer> table;
	Integer value;
	
		
	public LSP(String SIP, int port,DataManage dm)
	{
		try
		{
			this.dm=dm;
			File f = new File("Configuration.text");
			FileReader in = new FileReader(f);
			BufferedReader br= new BufferedReader(in);
			if(f.exists())
			{
				
				
						packet= br.readLine();
						st= new StringTokenizer(packet);
						String data;
						data= st.nextToken();
						dm.add(data);
						data = st.nextToken();
						dm.add(data);
						while(br.read()!=-1)
						{
							packet= br.readLine();
							//System.out.println("LSP:"+packet);
							st= new StringTokenizer(packet);
						
							while(st.hasMoreTokens())
							{
								SourceIP=st.nextToken();
								DestinationIP=st.nextToken();
								value= new Integer(st.nextToken());
								table=dm.hashAdd(DestinationIP,value);
								dm.hashAdd1(SourceIP,table);
							}
				
						}
			}
			//System.out.println("SIP:"+SIP);
			dm.send(SIP,port);
			
			
			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	
	
}
	