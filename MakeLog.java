import java.net.*;
import java.io.*;
import java.util.*;

public class MakeLog{


String path= System.getProperty("user.dir")+"/";

File f1 =new File(path+"log.txt");
FileOutputStream fos;
String command;
String s;

public void create(String command)
{
try
{
this.command=command;
System.out.println("This is command:"+command);
fos= new FileOutputStream(f1,true);
this.command=command;
fos.write(command.getBytes());

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
System.out.println("This is s:"+s);

if(f1.exists())
{
fos= new FileOutputStream(f1,true);
fos.write(s.getBytes());
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
