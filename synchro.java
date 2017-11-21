import java.util.*;

class Load extends Thread
 {
	 
	
   public void run()
   {
	   System.out.println("Loading to Carts \n");
	 
	  try { 
		Thread.sleep(1000);
		
		 
	  }catch(Exception e){System.out.println(e);}
	
	 
   }

 
}

class Unload extends Thread
 {
	 
	
   public void run()
   {
	   System.out.println("Unloading from Carts \n");
	 
	  try { 
		Thread.sleep(1000);
		
		 
	  }catch(Exception e){System.out.println(e);}
	
	 
   }

 
}


 
class TravellTo extends Thread
{
	 
	 
   public void run()
   {
	   System.out.println("Travelling from pile to incinerator \n");
	   
           try { 
		Thread.sleep(3000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }

class TravellFrom extends Thread
{
	 
	 
   public void run()
   {
	   System.out.println("Travelling back to pile from incinerator \n");
           try { 
		Thread.sleep(3000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }



class BurnBooks extends Thread
 {
	 
	 
   public void run()
   {
	  
	   System.out.println("burning books \n");
           try { 
		Thread.sleep(2000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }

public class synchro extends Thread
{
	 public static void main(String args[])
	 {
		int parallel_way = 2; 
		//int book_set=50/2;
	               while(parallel_way-- > 0)
		       {		
			synchro thread1= new synchro();
      			thread1.start();
			}
		
	 }

	public void run()
   	{
		final long startTime = System.currentTimeMillis();

		 int total=0;
		 int no_of_books=50;
		 int set;
		
		
		//int i=1;
		
		set=(no_of_books/(5*2));
		int temp=set;
		Load ob1=new Load();

		ob1.start();
		 try { 
			ob1.join();	  
	             }catch(Exception e){System.out.println(e);}
		
		
		while(set-- > 0)
		{
			
				TravellTo to=new TravellTo();
				TravellFrom from=new TravellFrom();
				
				to.start();
				from.start();

				try { 
				
				 to.join();
				 from.join();

						 	  
				 }catch(Exception e){System.out.println(e);}
				 
				 Load load=new Load();
				 Unload unload=new Unload();
				 
				 load.start();
				 unload.start();
				 try { 
				
				 load.join();
				 unload.join();  
				 }catch(Exception e){System.out.println(e);}
		}
			

		int remaining_books = temp*2;
			
	        if (remaining_books%3 == 0){
			   set=remaining_books/3;
		}
		else
		{
		   set=remaining_books/3 + 1;
    	        }
			
			while(set-- >0)
			{
			   BurnBooks ob5=new BurnBooks();
			   ob5.start();
		
				try { 
				
				 ob5.join();	  
				 }catch(Exception e){System.out.println(e);}
				 
			    
			}
	final long endTime = System.currentTimeMillis();
	System.out.println("Total execution time: " + (endTime - startTime)/100);
	 }
  }

