package restaurantvendor2;

/**
 * LinkedListInterface 

 * @param <T> 
 */
public interface LinkedListInterface <T>
{
	
    public void add(T element);
    public void remove(T elememt) throws Exception;
    public boolean contains(T element);
    public boolean isEmpty();	

}
