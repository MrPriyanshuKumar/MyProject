package misllenious;

import java.util.ArrayList;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

public class Stream {

	public static void main(String[] args) {
		
		//Count the number of names starting with alphabet 'a' in the list
		
		/*ArrayList<String> names = new ArrayList<String>();
		names.add("Aabhijit");
		names.add("Alekhya");
		names.add("Don");
		names.add("Adam");
		names.add("Ram");
		int count =0;
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
   */
		
		//We can print all names starting with alphabet 'A' by using 'stream'
		
	/* ArrayList<String> names = new ArrayList<String>();
		names.add("Aabhijit");
		names.add("Alekhya");
		names.add("Don");
		names.add("Adam");
		names.add("Ram");
		
		long c = names.stream().filter(s->s.startsWith("D")).count();
		System.out.println(c);
		*/
		
		//Here we no need to write all names in Array and then printing names according to filter conditions 
		
	/*	long d = java.util.stream.Stream.of("Aabhijit","Alekhya","Don","Adam","Ram").filter(s->
		
		{
			s.startsWith("A");
		}).count();
		System.out.println(d);
		*/
		
		//Print all names of ArrayList using 'stream'
		ArrayList<String> names = new ArrayList<String>();
		names.add("Aabhijit");
		names.add("Alekhya");
		names.add("Don");
		names.add("Adam");
		names.add("Ram");
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
	}

}
