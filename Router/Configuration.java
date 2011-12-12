import java.net.*;
import java.io.*;
import java.util.*;

class Configuration
{
	
	int port;
	Configuration(int port)
	{
		
	
		try
		{
			
				this.port=port;
				String path;
				System.out.println("Enter the details of Configuration file");
				String separator;
				separator= System.getProperty("line.separator");
				path= System.getProperty("user.dir")+"/"+"Configuration.text";
				File f= new File(path);
				FileOutputStream fos= new FileOutputStream(f);
				String write;
				Scanner scan = new Scanner(System.in);
				write= scan.nextLine();
				do
				{
				
					fos.write(write.getBytes());
					fos.write(separator.getBytes());
					write= scan.nextLine();
					System.out.println(write);
				}while((!(write.equals("-1"))));
				fos.close();
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}	