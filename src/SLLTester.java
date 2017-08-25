import java.util.Iterator;
public class SLLTester
{
    public static void main(String[] args)
    {
        MySinglyLinkedList a = new MySinglyLinkedList();
        System.out.println("Size of A: " + a.size());
        String[] input = {"Adam", "Betsy", "Caroline", "David"};
        MySinglyLinkedList b = new MySinglyLinkedList(input);
        System.out.println("Size of B: " + b.size());
        
        System.out.println(a);
        System.out.println(b);
        System.out.println();
      
        
        System.out.println("Does List A contain the word \"Caroline\"? " + a.contains("Caroline") + " in the " + a.indexOf("Caroline") + " index.");
        System.out.println("Does List B contain the word \"Caroline\"? " + b.contains("Caroline") + " in the " + b.indexOf("Caroline") + " index.\n");
        
        System.out.println(a.add("Zoe") + "  " + b.add("Eddie"));
        System.out.println("Size of A: " + a.size());
        System.out.println("Size of B: " + b.size());
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        System.out.println(a.remove("Zoe") + "  " + a.remove("Zoe") + "  " + b.remove("Adam"));
        System.out.println("Size of A: " + a.size());
        System.out.println("Size of B: " + b.size());
        
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        
        try 
        {
            System.out.println(a.get(2));
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.get(2)\"");
        }
        System.out.println(b.get(2));
        
        try 
        {
            System.out.println(a.set(2, "Fritz"));
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.set(2, \"Fritz\")\"");
        }        
        System.out.println(b.set(2, "Fritz")+ "\n");
        
        System.out.println(a);
        System.out.println(b + "\n");
        
        try 
        {
            a.add(2, "Gina");
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.add(2, \"Gina\")\"");
        }
        System.out.println("Size of A: " + a.size());
        b.add(2, "Gina");
        System.out.println("Size of B: " + b.size());
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        
        try 
        {
            System.out.println(a.remove(2));
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.remove(2)\"");
        }
        System.out.println("Size of A: " + a.size());
        System.out.println(a);
        System.out.println(b);
        System.out.println(b.remove(2));
        System.out.println("Size of B: " + b.size());
        System.out.println(a);
        System.out.println(b);
        
        MySinglyLinkedList longList = new MySinglyLinkedList();
        long startTime = System.currentTimeMillis();
        for (int x = 0; x < 3000; x++)
            longList.add("C");
        longList.add(0,"B");
        for (int x = 0; x < 3000; x++)
            longList.add(0, "A");
        longList.add("D");
        System.out.println("Index of \"B\": " + longList.indexOf("B"));
        System.out.println("Index of \"D\": " + longList.indexOf("D"));
        longList.add(longList.size()-5, "E");
        longList.set(longList.size()-4, "F");
        System.out.println("Should be E: " + longList.get(longList.size()-6));
        System.out.println("Should be F: " + longList.get(longList.size()-4));
        System.out.println("Should be F: " + longList.remove(longList.size()-4));
        System.out.println("Should be true: " + longList.remove("E"));
        System.out.println("Methods are working: " + !longList.contains("E"));
        System.out.println("Methods are working: " + (longList.indexOf("F") == -1));
        System.out.println("Index of B: " + longList.indexOf("B"));
        System.out.println("THIS WILL TAKE ABOUT 10 SECONDS ... PLEASE BE PATIENT.");
        for (int iteration = 0; iteration < 100000; iteration++)
        {
            longList.isEmpty();
            longList.add("Z");
            longList.indexOf("Z");
            longList.add(0,"G");
            longList.contains("Z");
            longList.set(5000, "H");
            longList.remove("Z");
            longList.remove(5000);
            longList.get(longList.size()-1);
        }        
        long endTime = System.currentTimeMillis();
        System.out.println("YOUR SCORE: " + (15000 - (endTime - startTime)));

        //testSLLWithIterator();
    }
    
    public static void testSLLWithIterator()
    {
        MySinglyLinkedList a = new MySinglyLinkedList();
        for (int x = 0; x < 10000; x++)
            a.add(new Integer(x));
        Iterator iter = a.iterator();
        Integer i = (Integer)iter.next();
        long start = System.currentTimeMillis();
        while(iter.hasNext()) {
            if (i.intValue() % 100 == 0)
                System.out.print(i + ", ");
            if (i.intValue() % 1000 == 900)
                System.out.println();
            i = (Integer)iter.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken with iterator: " + (end - start));
        start = System.currentTimeMillis();
        for (int x = 0; x < a.size(); x++) {
            i = (Integer)a.get(x);
            if (i.intValue() % 100 == 0)
                System.out.print(i + ", ");
            if (i.intValue() % 1000 == 900)
                System.out.println();
        }
        end = System.currentTimeMillis();
        System.out.println("Time taken without iterator: " + (end - start));
    }
    public static ListNode merge(ListNode head1, ListNode head2)
    {
       if (head1==null)
       {
    	   return head2;
       }
       if (head2==null)
       {
    	   return head1;
       }
  	   if ((Integer)head1.getValue()>(Integer)head1.getValue())
  	   {
  		   ListNode hi = new ListNode (head2.getValue(), merge(head1, head2.getNext() ));
  		   return hi;
  	   }
  	   else
  	   {
  		    ListNode hi = new ListNode (head1.getValue(), merge(head1.getNext(), head2 ));
  		   return hi;
  	   }
    }
    public ListNode reverseList (ListNode head)
    {
    	ListNode newHead = null;
    	
    	for (ListNode list= head; list!=null;list=list.getNext())
    	{
    		ListNode previous = list;
    		while (prevoius!=next)
    		{
    			previous=previous.getNext();
    		}
    		
    			
    	}
    	return newHead;
    }
    public ListNode rotate (ListNode head)
    {
    	for (ListNode list = head; list!=null;list=list.getNext())
    	{
    		if (list.getNext()==null)
    		{
    			list.setNext(head);
    			
    		}
    	}
    	ListNode newhead=head.getNext();
    	head.setNext(null);
    	return newhead;
    
    }
    public ListNode insertInOrder (ListNode head, String s)
    {
    	for (ListNode list = head; list!=null;list=list.getNext())
    	{
   
    		if ((String)list.getNext().getValue().compareTo(s)>0)
    		{
    			list.setNext(new ListNode(s, list.getNext()));
    			return head;
    		}
    		else if ((String)list.getValue().compareTo(s)==0)
    		{
    			return head;
    		}
    	}
    	
    }
}
