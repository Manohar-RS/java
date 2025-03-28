package java_practice;
import java.util.*;
public class slip3_2 {

	public static void main(String[] args) {
		
		LinkedList<String> list=new LinkedList<String>();
		Scanner sc=new Scanner(System.in);
		
		list.add("Manohar");
		list.add("Aditya");
		list.add("Rohan");
		list.add("Prajwal");
		list.add("Karan");
		 
		for(String name : list)
		System.out.println("List : "+name);
		
		while(true)
		{
			System.out.println("1. Enter elements at the last of the list : ");
			System.out.println("2.  Delete First elements of  the list : ");
			System.out.println("3. Display Reverse order list : ");
			System.out.println("4. Exit ");
			System.out.println("Enter your choice : ");
			int ch=sc.nextInt();
			 sc.nextLine();
			
			switch(ch)
			{
			case 1: 
				System.out.print("Enter the elemet at the end of list :");
				String a=sc.nextLine();
				list.addLast(a);
				for(String name1 : list)
				System.out.println("List : "+name1);
				break;
				
			case 2 :
				System.out.print("Delete First element of the list  :");
				list.removeFirst();
				for(String name2 : list)
				System.out.println("List : "+name2);
				break;
				
			case 3: 
				System.out.print("The Reverse Ordered list is  :");
				Collections.reverse(list);
				for(String name3 : list)
				System.out.println("List : "+name3);
				break;
				
			case 4:
				  System.out.print("Exiting program...");
                  sc.close();
                  System.exit(0);

              default:
                  System.out.println("Invalid choice! Please try again.");
			
			}
			
		}
		
		
		
	}

}

	
	
	
	
	
	
	