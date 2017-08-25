// Implements a singly-linked list 
import java.util.Iterator;


public class MySinglyLinkedList implements Iterable<Object>
{
  private ListNode head;
  private int nodeCount;

  // Constructor: creates an empty list
  public MySinglyLinkedList()
  {
    head = null;
    nodeCount = 0;
  }

  // Constructor: creates a list that contains
  // all elements from the array values, in the same order
  public MySinglyLinkedList(Object[] values)
  {
    ListNode tail = null;
    for (Object value : values) // for each value to insert
    {
      ListNode node = new ListNode(value, null);
      if (head == null)
        head = node;
      else
        tail.setNext(node);
      tail = node;    // update tail
    }

    nodeCount = values.length;
  }

  // Returns true if this list is empty; otherwise returns false.
  public boolean isEmpty()
  {
    return (head==null);
  }

  // Returns the number of elements in this list.
  public int size()
  {
    return this.nodeCount; 
  }

  // Returns true if this list contains an element equal to obj;
  // otherwise returns false.
  public boolean contains(Object obj)
  {
     if(indexOf(obj)>-1)
     {
    	 return true;
     }
     return false;
  }

  // Returns the index of the first element in equal to obj;
  // if not found, retunrs -1.
  public int indexOf(Object obj)
  {
	 int x=-1;
	 for (ListNode list = head; list!=null; list=list.getNext())
	 {
		 x++;
		 if (list.getValue()==obj)
		 {
			 return x;
		 }
	 }
	 return -1;
	 
  }

  // Adds obj to this collection.  Returns true if successful;
  // otherwise returns false.
  //for (ListNOde list = head; list !=null; list = list.getnext())
  //for (ListNode list = head; list!=null; list= list.getNext())
  public boolean add(Object obj)
  {
//	  ListNode one = new ListNode (obj, null);
//	  if (head==null)
//	  {
//		  
//		  head=one;
//		  nodeCount++;
//		  return true;
//	  }
//	  for (ListNode list = head; list!=null; list=list.getNext())
//	  {
//		  if (list.getNext()==null)
//		  {
//			  list.setNext(one);
//			  nodeCount++;
//			  return true;
//		  }
//	  }
//	  
//	  return false;
	  add(nodeCount,obj);
	  return true;
  
  }

  // Removes the first element that is equal to obj, if any.
  // Returns true if successful; otherwise returns false.
  public boolean remove(Object obj)
  {
	  if (head==null)
	  {
		  return false;
	  }
	  if (head.getValue()==obj)
	  {
		  head=head.getNext();
		  nodeCount--;
		  return true;
	  }
		 

	  for (ListNode list = head; list!=null; list=list.getNext())
	  {
		  if (list.getNext().getValue()==obj)
		  {
			  list.setNext(list.getNext().getNext());
			  nodeCount--;
			  return true;
		  }
	  }
	
	  return false;
  }

  // Returns the i-th element.
  // Throws IndexOutOfBoundsException if i is out of bounds.               
  public Object get(int i)
  {
	  if (i>=nodeCount)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  int x=-1;
	  for (ListNode list = head; list!=null; list=list.getNext())
	  {
		  x++;
		  if (x==i)
		  {
			  return list.getValue();
		  }
	  }
	  return null;
  }

  // Replaces the i-th element with obj and returns the old value.
  // Throws IndexOutOfBoundsException if i is out of bounds.
  public Object set(int i, Object obj)
  {
	  if (i>=nodeCount)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  int x=-1;
	  for (ListNode list = head; list!=null; list=list.getNext())
	  {
		  x++;
		  if (x==i)
		  {
			 Object one = list.getValue();
			 list.setValue(obj);
			 return one;
			 
		  }
	  }
	  return null;
  }

  // Inserts obj to become the i-th element. Increments the size
  // of the list by one.
  // Throws IndexOutOfBoundsException if i is out of bounds.
  public void add(int i, Object obj)
  {
	  if (i ==0)
	  {
		  ListNode one = new ListNode (obj, head) ;
		  head = one;
		  nodeCount++;
		  return;
		
	  }
	  if (i>nodeCount)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  int x=-1;
	  for (ListNode list = head; list!=null; list=list.getNext())
	  {
		  x++;
		  if (x==i-1&&list.getNext()!=null)
		  {
			  ListNode one = new ListNode (obj, list.getNext()) ;
			  list.setNext(one);
			  nodeCount++;
			  break;
			  
		  }
		  else if (x==i-1)
		  {
			  ListNode one = new ListNode (obj, list.getNext()) ;
			  list.setNext(one);
			  nodeCount++;
			  break;
		  }
		  
	  }
  } 

  // Removes the i-th element and returns its value.
  // Decrements the size of the list by one.
  // Throws IndexOutOfBoundsException if i is out of bounds.
  public Object remove(int i)
  {
	  if (i>=nodeCount)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  int y = -1; 
	  for (ListNode list = head; list!=null; list=list.getNext())
	  {
		  y++; 
		  if ((y == (i-1)) && list.getNext().getNext() != null)
		  {
			  ListNode value = list.getNext();
			  list.setNext(list.getNext().getNext());
			  nodeCount--; 
			  return value.getValue();
			  
		  }
		  else if (( y == (i-1)) && list.getNext() != null && list.getNext().getNext() == null)
		  {
			  ListNode value = list.getNext();
			  list.setNext(null);
			  nodeCount--; 
			  return value.getValue();
		  }
	  }
	 
	  return null; 
  }
  
  private void recursivePrintForward(ListNode startNode)
  {
	  if (startNode!=null)
	  {
		  System.out.print(startNode.getValue());
		  recursivePrintForward(startNode.getNext());
	  }
	  
  }
  
  private void recursivePrintBackward(ListNode startNode)
  {
	  if (startNode!=null)
	  {
		  recursivePrintBackward(startNode.getNext());
		  System.out.print(startNode.getValue());
		 
	  }
	  
  }
  
  
  
  private static ListNode setUpCharList(int num)
  {
	  ListNode one= new ListNode((char)('A'+num-1), null);
	  for (int x=num-1;x>=0; x--)
	  {
		  ListNode two = new ListNode ((char)('A'+x), one);
		  one=two;
	  }
	  return one;
  }
  
  private int indexOf(Object obj, ListNode start)
  {
	  if (obj==start.getValue())
	  {
		  return -1*nodeCount-1;
	  }
	  if (start==null)
	  {
		  return -1;
	  }
	  
	  return 1+indexOf(obj,start.getNext());
  }
  
  private static ListNode recursiveFindAndInsert(Object obj1, Object obj2, ListNode head)
  {
	  if (head==null)
		  return new ListNode(obj2,null);
	  if (head.getValue().equals(obj1))
	  {
		  head.setNext(new ListNode(obj2,head.getNext()));
		  return head;
	  }
	  recursiveFindAndInsert(obj1,obj2,head.getNext());
	  return head;
		
  }


  // Returns a string representation of this list.
  public String toString()
  {
	  StringBuffer s = new StringBuffer("{ ");
      for (ListNode list = head; list!=null; list=list.getNext()) {
          s.append(list.getValue() + " ");
      }
      s.append("}");
      return s.toString();
  }

  //Returns an iterator for this collection.
  public Iterator<Object> iterator()
  {
    return new SinglyLinkedListIterator(head);
    
  }
 
}
//worked with Casey Crosson, Matt Henricks, Eddy Mack