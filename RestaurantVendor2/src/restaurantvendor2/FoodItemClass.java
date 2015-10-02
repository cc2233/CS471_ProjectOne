package restaurantvendor2;


import java.math.*;

/**
 * FoodItemClass for food items 
 * @author Scar
 */
public class FoodItemClass 
{
    
    public String mFoodName;
    public BigDecimal mFoodPrice;
    public int mFoodQty;
    public String mFoodDescription;
    public String mFoodSize;
    public String mFoodSpecialOrder;
    
    
    /**
     * updateFrom(FoodItemClass newFoodItem) takes in a new food item and copies its member variables
     * @param newFoodItem 
     */
    public void updateFrom(FoodItemClass newFoodItem)
    {
        mFoodName = newFoodItem.mFoodName;
        mFoodPrice = newFoodItem.mFoodPrice;
        mFoodQty = newFoodItem.mFoodQty;
        mFoodDescription = newFoodItem.mFoodDescription;
        mFoodSize = newFoodItem.mFoodSize;
        mFoodSpecialOrder = newFoodItem.mFoodSpecialOrder;
        
    }
 
    public void debugPrint()
    {
        System.out.println("Food name : " + mFoodName);
    }
   
    
    
    /**
     * equals(Object object1) compares two objects for equality
     * @param object1
     * @return 
     */
    public boolean equals(Object object1)//compares category names
    {
        if(object1 instanceof String)
            return(object1.equals(this.mFoodName));
        else if(object1 instanceof FoodItemClass)
        {
            FoodItemClass y = (FoodItemClass)object1;
            return y.mFoodName.equals(this.mFoodName);
        }
       
        else
            throw new IllegalArgumentException("object type must be String or FoodItemClass");

    }
}