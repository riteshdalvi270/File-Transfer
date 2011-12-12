import java.net.*;
import java.io.*;
import java.util.*;

public class MakeLog
{
	

	String path= System.getProperty("user.dir")+"/";
	String line= System.getProperty("line.separator");

	File f1 =new File(path+"log.txt");
	FileOutputStream fos;
	String command;
	String s;

	public void create(String command)
	{
		try
		{
			this.command=command;
			fos= new FileOutputStream(f1,true);
			this.command=command;
			fos.write(command.getBytes());
			fos.write(line.getBytes());
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void attach(String s)
	{	
		try
		{
			this.s=s;

			if(f1.exists())
			{
				fos= new FileOutputStream(f1,true);

				fos.write(s.getBytes());
				fos.write(line.getBytes());

			}
			else
				create(this.s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
