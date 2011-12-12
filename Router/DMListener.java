import java.net.*;
import java.util.*;
import java.io.*;

class DMListener
{
	DataManage dm;
	LinkedList<Object> listobject= new LinkedList();
	public DMListener()
	{}
	public void returnObj(Object dm)
	{
		try
		{
			this.dm=(DataManage)dm;
			listobject.add(this.dm);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
	
	public Object sendObject()
	{
			return listobject.getFirst();
			
	}
}	
