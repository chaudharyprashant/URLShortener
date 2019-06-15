import java.util.HashMap;
import java.util.Random;

public class ShortenUrl {

	static HashMap<String,String> keyMap;
	static HashMap<String,String> valueMap;
	char chararray[];
	Random randNumber;
	int keyLength;
	static String temp="www.tinyurl.com/";
	public static void main(String args[])
	{
	 String url="www.google.com";
	   String shortUrl=new ShortenUrl().URLShortener(url);
		 System.out.println("ShortenUrl="+shortUrl);
	  String originalUrl=new ShortenUrl().expandedUrl(shortUrl);
	 // System.out.println("Original URL="+originalUrl);
	  
	 }
	public ShortenUrl(){
		keyMap=new HashMap<String,String>();
		valueMap=new HashMap<String,String>();
		randNumber=new Random(0);
		keyLength=8;
		chararray=new char[62];
		for(int i=0;i<62;i++)
		{
			int j=0;
			if(i<10)
			{
				j=i+48;
			}
			else if(i>9&&i<=35)
			{
				j=i+55;
			}
			else
			{
				j=i+61;
			}
			chararray[i]=(char)j;
		}
	}
	
	public  String URLShortener(String longUrl)
	{
		String generatedKey="";
		String shortUrl="";
	    if(valueMap.containsKey(longUrl))
	    {
	    	shortUrl=temp+valueMap.get(longUrl);
	    }
	    else
	    {
	    	generatedKey=getKey(longUrl);
	    	shortUrl=temp+generatedKey;
	    	
	    }
		
	    keyMap.put(generatedKey,longUrl);
    	valueMap.put(longUrl,generatedKey);
		return shortUrl;
	}
	public String expandedUrl(String shortUrl)
	{
		String longUrl="";
		
		String key=shortUrl.substring(temp.length(),shortUrl.length());
		System.out.println(key);
		longUrl=keyMap.get(key);
		
		return longUrl;
	}
	public String getKey(String longUrl)
	{
		String key="";
		boolean flag=true;
		while(flag)
		{
			key="";
			for(int i=0;i<keyLength;i++)
			{
				key+=chararray[randNumber.nextInt(62)];
			
			}
			if (!keyMap.containsKey(key)) {
				flag = false;
			}
		}
		
		return key;
	}
}
