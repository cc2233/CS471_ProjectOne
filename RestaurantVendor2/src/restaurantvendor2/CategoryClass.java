package restaurantvendor2;

/**
 * CategoryClass to create category objects
 * 
 */
public class CategoryClass 
{
    
    public String mCategoryName;
    LinkedList<FoodItemClass> mFoodItems;
	
    public CategoryClass() //constructor
    {
	mFoodItems = new LinkedList<FoodItemClass>();
    }
    
    public CategoryClass(String newCategoryName) //constructor to set category name
    {
        mCategoryName = newCategoryName;
        mFoodItems = new LinkedList<FoodItemClass>();
    }
    
    
    public boolean equals(Object object1)//compares category names
    {
        if(object1 instanceof String)
            return(object1.equals(this.mCategoryName));
        else if(object1 instanceof CategoryClass)
        {
            CategoryClass y = (CategoryClass)object1;
            return y.mCategoryName.equals(this.mCategoryName);
        }
       
        else
            throw new IllegalArgumentException("object type must be String or CategoryClass");

    }
    
    public boolean matches(String string1)
    {
        return(string1.equals(this.mCategoryName));
    }
    
    
    public void debugPrint()
    {
        LinkedListNode<FoodItemClass> iter = mFoodItems.list;
        System.out.println("Category name : " + mCategoryName);
        while (iter != null) 
        {
            iter.getElement().debugPrint();
            
            iter = iter.getLink();
        }
    }
}
