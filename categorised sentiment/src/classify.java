import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class classify {

	public static void main(String[] args)throws IOException {
		try{
			int count=0;
			String tweet;
			float sum=0.0f;
		
			  ArrayList<String> stopwords= new ArrayList<String>();
			  ArrayList<Float> score=new ArrayList<Float>();
			  ArrayList<Float> hostel=new ArrayList<Float>(); 
			  ArrayList<Float> job=new ArrayList<Float>();
			  ArrayList<Float> faculty=new ArrayList<Float>();
			  ArrayList<Float> infra=new ArrayList<Float>();
			  BufferedReader stop = new BufferedReader(new FileReader("Data\\stopwords.txt"));
			  String line = "";
			  while ((line = stop.readLine()) != null)
			  {
				  stopwords.add(line);
			  }
			
			
			 Map<String, String> map = new HashMap<String, String>();
		        BufferedReader in = new BufferedReader(new FileReader("Data\\AFINN"));
		        
		        line="";
		        while ((line = in.readLine()) != null) {
		            String parts[] = line.split("\t");
		            map.put(parts[0], parts[1]);
		            count++;
		        }
		        in.close();
		     //   System.out.printlnln(map.toString());
		   
			
			//hostel
			Scanner inputStream= new Scanner(new FileReader("G:\\3rd yr\\categorised sentiment\\Data\\test"));
			while(inputStream.hasNextLine())
			{
				float tweetscore=0;
			tweet= inputStream.nextLine();
			String[] word=tweet.split(" ");
			
			

				for(int i=0; i<word.length;i++)
				{
					if(stopwords.contains(word[i].toLowerCase()))
					{
						
					}
					else{
						if(map.get(word[i])!=null)
						{
						String wordscore= map.get(word[i].toLowerCase());
						tweetscore=(float) tweetscore + Integer.parseInt(wordscore);
					}}}
					Map<String, Float> sentiment= new HashMap<String, Float>();
					sentiment.put(tweet, tweetscore);
					System.out.println(sentiment.toString()); 
				    hostel.add(tweetscore);
							
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		
	}

	}

}
