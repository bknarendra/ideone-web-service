/*
Created by: Narendra Rajput
Contact   : bknarendra2008@gmail.com

Use the program the way you like. You have all the permission to play with it or screw it
with only one request plzz don't remove the comment from the file
*/

import java.io.*;
import java.util.*;

public class Ideone {
  public static void main(String[] argv) {
      try {
          Ideone_Service_v1ServiceLocator locator = new Ideone_Service_v1ServiceLocator();
          Ideone_Service_v1Port_PortType service = locator.getIdeone_Service_v1Port();
          int stat;
          String code="",temp="",input="";
		  if(argv.length!=2)
		  {
			  System.out.println("Usage:java Main <source file> <input file>");
			  return;
		  }
		  BufferedReader br=new BufferedReader(new FileReader(argv[0]));
		  BufferedReader in=new BufferedReader(new FileReader(argv[1]));
          while((temp=br.readLine())!=null)
			code=code+"\n"+temp;
          br.close();
		  while((temp=in.readLine())!=null)
			input=input+"\n"+temp;
          in.close();
          Object []languages=service.getLanguages("your ideone username","your ideone password");
          HashMap <String,HashMap> lang=(HashMap)languages[0];
		  System.out.println(lang);
		  DataInputStream userin=new DataInputStream(System.in);
		  System.out.println("Enter your language choice : ");
		  int ch=Integer.parseInt(userin.readLine());
          Object sub[]=service.createSubmission("geniush","geniush159zxc",code,ch,input,Boolean.TRUE,Boolean.FALSE);

          HashMap <String,String> subm=(HashMap)sub[0];
          String link="";

          if(subm.get("error").equals("OK"))
          link=subm.get("link");
int result=0,memory=0;
float time=0;
String output="",cmpinfo="",stderr="";
while(result!=15)
{
	Thread.sleep(20);
          Object subdet[]=service.getSubmissionDetails("geniush","geniush159zxc",link,Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
          HashMap <String,Object> subdetls=(HashMap)subdet[0];
          result=((Integer)subdetls.get("result")).intValue();
          time=((Float)subdetls.get("time")).floatValue();
          output=(String)subdetls.get("output");
          cmpinfo=(String)subdetls.get("cmpinfo");
          memory=((Integer)subdetls.get("memory")).intValue();
          stderr=(String)subdetls.get("stderr");
}
          if(result==15)
              System.out.println("memory="+memory+" time="+time+" output="+output);
          else
              System.out.println(cmpinfo+"\nerror:"+stderr);
      } 
      catch(Exception e){e.printStackTrace();}
  }
}