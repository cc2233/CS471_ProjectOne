package restaurantvendor2;

/**
 * LinkedList generics

 * @param <T> 
 */


public class LinkedList <T> implements LinkedListInterface <T>{

    public LinkedListNode <T> list;
    public String name;
    public int count=0;

    public LinkedList() 
    {
        this.name = "Linked List";
	list = null;
    }

    public LinkedList(String name) 
    {
	this.name = name;
	list = null;
    }
		
    public void add(T element) 
    {
	// add first element
	LinkedListNode <T> newNode = new LinkedListNode<T>(element, list);
	list = newNode;
	count++;
    }

    public void remove(T element) throws Exception
    {
	
        //find if element is in the list by iterating with '=='
        //if found, remove & reduce count 
        //else, throw exception
       
        //if list is empty, throw exception
        if(list==null)
            throw new Exception("cannot remove; empty");
        
        //if first node matches, special case (no prev)
        LinkedListNode<T> iter = this.list; 
        
        if(iter.getElement() == element)
        {
            list = list.getLink();
            iter.setLink(null);
            count--;
            return;
        }
         
        //other wise
        LinkedListNode<T> prev = list;
        iter = iter.getLink(); //iter and prev were pointing at the same node before this
        
        while (iter != null) 
        {
            iter.getElement();
            if(iter.getElement() == element)
            {
                prev.setLink(iter.getLink());
                iter.setLink(null);
                count--;
                return;
            }
            
            prev = iter;
            iter = iter.getLink();
        }
        
        //if element is not found
        throw new Exception("element not found");
   
    }

    public T pop() 
    {
	T temp = list.getElement();
	list = list.getLink();
	count--;
	return temp;
    }

    public T find(String findThis) 
    {
	LinkedListNode<T> current = list;
        while (current != null) 
        {
            if (current.getElement().equals(findThis))
                return current.getElement();
            
            current = current.getLink();
        }
        return null;
    }
    

    public boolean contains(T match_element) 
    {
	LinkedListNode<T> current = list;
	System.out.println("contains");
        while (current != null) 
        {
            System.out.println("contains 0");
            if (current.getElement().equals(match_element))
                return true;
            current = current.getLink();
        }
        return false;
    }

		
    public boolean isEmpty() 
    {
	if(list==null)
            return true;
        
        return false;
    }

    public String getName() 
    {
	return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int size() 
    {
        return this.count;
    }

    public String toString() 	
    {
	String out = "";
	LinkedListNode<T> temp;
	temp = list;
	while (temp != null) 
        {
            out += temp.getElement() + "\n";
            temp = temp.getLink();
	}
        return out;
    }

		
}