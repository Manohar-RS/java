package java_practice;
import java.util.*;

public class slip2_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashSet<String> fname=new HashSet<String>();
		System.out.println("Enter the no.of Freinds Names :");
		int n=sc.nextInt();
		System.out.println("Enter the Freinds Names :");
		for(int i=0;i<=n;i++)
		{
			String name=sc.nextLine();
			fname.add(name);
		}
		TreeSet<String> StoredName = new TreeSet<String>(fname);
		
		System.out.println("The Sorted Freind Names is :\n");
		
		for(String friend : StoredName)
		System.out.println(friend);
		//System.out.println(StoredName);
		
		sc.close();
	}

}
