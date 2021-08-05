import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;
import java.util.Scanner;

public class SentimentAnalysis {
	
	

	


public static void main(String args[]) throws IOException
{
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
	            String parts[] = line.split(",");
	            map.put(parts[0], parts[1]);
	            count++;
	        }
	        in.close();
	     //   System.out.printlnln(map.toString());
	   
		
		//hostel
		Scanner inputStream= new Scanner(new FileReader("G:\\3rd yr\\categorised sentiment\\Data\\samplecheck"));
		while(inputStream.hasNextLine())
		{
			float tweetscore=0;
			int flag=0;
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
				if(i>1&&(word[i-1].equalsIgnoreCase("not")||word[i-2].equalsIgnoreCase("not")))
				{
					tweetscore=(float) tweetscore + (-1)*Integer.parseInt(wordscore);
					
				}
				else
					tweetscore=(float) tweetscore + Integer.parseInt(wordscore);
			}}}
			Map<String, Float> sentiment= new HashMap<String, Float>();
			sentiment.put(tweet, tweetscore);
			
		    hostel.add(tweetscore);
			
					
		} 
		inputStream.close();
		System.out.println("hostel="+hostel);
		//placement
		/*inputStream= new Scanner(new FileReader("G:\\3rd yr\\categorised sentiment\\Data\\placement"));
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
		    job.add(tweetscore);
					
		} 
		inputStream.close();
		System.out.println("placement="+job);
		//faculty
		 inputStream= new Scanner(new FileReader("G:\\3rd yr\\categorised sentiment\\Data\\faculty"));
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
		    faculty.add(tweetscore);
					
		} 
		inputStream.close();
		System.out.println("faculty="+faculty);
		//infrastructure
		inputStream= new Scanner(new FileReader("G:\\3rd yr\\categorised sentiment\\Data\\infrastructure"));
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
		    infra.add(tweetscore);
					
		} 
		System.out.println("infrastructure="+infra);
		inputStream.close();
		 inputStream= new Scanner(new FileReader("G:\\3rd yr\\categorised sentiment\\Data\\iit madras"));
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
				//tweetscore=tweetscore/5.0f;
			}}}
			Map<String, Float> sentiment= new HashMap<String, Float>();
			sentiment.put(tweet, tweetscore);
			//System.out.println(sentiment.toString()); 
		    score.add(tweetscore);
		   
					
		} 
		inputStream.close();
		System.out.println("College="+score);
		 /*for(int i=0;i<score.size();i++)
		    {
			 	sum=sum+score.get(i);
		    }
		System.out.println(sum/score.size());*/
		
		

}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	
}
}}