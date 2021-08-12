package Day044_Return_Values;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class TC002_Return_Multiple_Values {
	
	
	
	@Test
	public void Test1()throws Exception
	{
	    
		
		Set<String> hash_Set1 = new HashSet<String>(); 
		
		
		hash_Set1=Page5();
		
		 System.out.println(" All Elements data :  " + hash_Set1);
	
		
		
		
		List<String> Li1 = new ArrayList<String>();  
	    
	    Li1=Page1();
	    
	    //Li1=Page_list1;
	    
	 System.out.println(" Element data 0  :  " + Li1.get(0));
	 System.out.println(" Element data 1  :  " + Li1.get(1));
	 System.out.println(" Element data 2  :  " + Li1.get(2));
	    
	  //  System.out.println(Arrays.toString(Li1.toArray()));
	    
	   page2(Li1);
	   // printList1(Li1);
	   // page2(Li1.get(0),Li1.get(1),Li1.get(2));
	    
	  //  printList1(Li1);
	    
	}
	
	


	
	
	public  void page2(String string1, String string2, String string3) {
		
	
		   System.out.println(" Element data 0  :  " + string1);
		   System.out.println(" Element data 1  :  " + string2);
		   System.out.println(" Element data 2  :  " + string3);
	}






	public  void page2(List<String> page_li) {
		// TODO Auto-generated method stub
		
		System.out.println("Object Data in Page2"+page_li);
		
		 System.out.println(" Element data 0  :  " + page_li.get(0));
		 System.out.println(" Element data 1  :  " + page_li.get(1));
		 System.out.println(" Element data 2  :  " + page_li.get(2));
		 
		// String Empid=page_li.get(0);
		    
		
		for(String str5:page_li){  
			 System.out.println("The value is " +str5);  
			}  
		
		
	}



	
	public Set<String> Page5() {
		
		 Set<String> hash_Set = new HashSet<String>(); 

     hash_Set.add("Geeks"); 
     hash_Set.add("For"); 
     hash_Set.add("Geeks"); 
     hash_Set.add("Example"); 
     hash_Set.add("Set"); 
     
     return hash_Set;
     
	}



	public List<String> Page1()    {
		
	    List<String> Page_list1 = new ArrayList<String>();
	    
	    Page_list1.add("Order");
	    Page_list1.add("11");
	    Page_list1.add("Indian777");
	    
	    return(Page_list1);
	   
	   }
	
	
		public void printList(List<String> list){
			    for(String elem : list){
			        System.out.println(elem+"  ");
			    }
			}
		
		
		
		public  void printList1(List<String> list)
		{
		    for (int i=0; i<list.size(); i++)
		        System.out.println(list.get(i));
		}
		
		
		
		
		
		

}
