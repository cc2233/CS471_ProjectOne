package restaurantvendor2;

import java.io.*;
import java.nio.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.math.*;

/**
 * @author Caroline Chey
 * @CSC202 Assignment2 designs restaurant vendor interface 
 * Driver contains main
 */
public class Driver 
{
    LinkedList<CategoryClass> mCategories;
    public String mLastError; //stores possible error messages
    
    CategoryClass mSearchResultCategory;
    FoodItemClass mSearchResultFood;
    
    /**
     * Driver constructor to create a LinkedList of categories
     */
    public Driver() //constructor
    {
        mCategories = new LinkedList<>();
    }
   
    public static void main(String[] args) 
    {
                VendorGUI v1 = new VendorGUI();
                Driver d1 = new Driver();
                v1.setDriver(d1);
                v1.setVisible(true);
                
             
    }
    /**
     * loadFromExcel(String excelFileName) loads food data from an excel file
     * @param excelFileName 
     */
    
    
    
    public void saveToBinary(String binaryFileName)
    {
        try 
        {
            // Put some bytes in a buffer so we can write
            String bytes = "EMPTY";
            byte[] buffer = bytes.getBytes();

            FileOutputStream outputStream = new FileOutputStream(binaryFileName);
           
            // write() writes as many bytes from the buffer as the length of the buffer.
            outputStream.write(buffer);

            //close files.
            outputStream.close();		

            System.out.println("Saved " + buffer.length + " bytes");
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" + binaryFileName + "'");
  			
        }
        catch(IOException ex) 
        {
            System.out.println("Error writing file : " + binaryFileName);
        }
    }
    


    public void loadFromBinary(String binaryFileName)
    {
        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = new FileInputStream(binaryFileName);
      
            // read fills buffer with data and returns
            // the number of bytes read 
            
            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) 
            {
                // Convert to String so we can display it.
                System.out.println(new String(buffer));
                total += nRead;
            }	

            //close file
            inputStream.close();		

            System.out.println("Read " + total + " bytes");
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" +   binaryFileName + "'");
  			
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file :"+ binaryFileName);
        }
    }

    
    public void loadFromExcel(String excelFileName)
    {
        mCategories = new LinkedList<>();
        
        FileInputStream fis = null;
        try 
        {
            fis = new FileInputStream(excelFileName);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();   
            rows.next();//skip the first row
            
            while (rows.hasNext()) 
            {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                //get first cell -> category name
                if(!cells.hasNext()) //empty row
                {
                    continue;
                }
                HSSFCell cell = (HSSFCell) cells.next();
                String categoryName = cell.getStringCellValue();
                if(categoryName.equals("") || categoryName.equals(null))//if categoryName is empty, cintiue
                {
                    continue;
                }
                CategoryClass c1 = findOrAddCategory(categoryName);
                
                //get second cell -> food name
                if(!cells.hasNext())
                {
                    continue;
                }
                cell = (HSSFCell) cells.next();
                String foodName = cell.getStringCellValue();
                if(foodName.equals("")||foodName.equals(null)) //if foodName is empty, continue
                {
                    continue;
                }
                FoodItemClass f1 = findOrAddFood(c1,foodName);
                
                //get third cell -> food price
                if(!cells.hasNext())
                {
                    continue;
                }
                cell = (HSSFCell) cells.next();
                String foodPrice = cell.getStringCellValue();
                if(foodPrice.equals("")||foodPrice.equals(null))
                {//if price is empty
                    continue;
                }
                BigDecimal p1 = new BigDecimal(foodPrice);
                BigDecimal zero = new BigDecimal("0");
                if(p1.compareTo(zero)<0)
                {//if food price < 0
                    continue;
                }
                f1.mFoodPrice = p1;
                
                //get fourth cell -> food qty
                if(!cells.hasNext())
                {
                    continue;
                }
                cell = (HSSFCell) cells.next();
                String foodQty = cell.getStringCellValue();
                if(foodQty.equals("") || foodQty.equals(null)) 
                {//if qty is empty
                    continue;
                }
                int q1 = Integer.parseInt(foodQty);
                if(q1<0)
                {
                    continue;
                }
                f1.mFoodQty = q1;
                
                //get fifth cell -> food description
                if(!cells.hasNext())
                {
                    continue;
                }
                cell = (HSSFCell) cells.next();
                String foodDescription = cell.getStringCellValue();
                if(foodDescription.equals(null))
                {//will allow empty description
                    continue;
                }
                f1.mFoodDescription = foodDescription;
                
                
                //get sixth cell -> food size
                if(!cells.hasNext())
                {
                    continue;
                }
                cell = (HSSFCell) cells.next();
                String foodSize = cell.getStringCellValue();
                if(foodSize.equals("") || foodSize.equals(null))
                {//if food size is empty
                    continue;
                }
                f1.mFoodSize = foodSize;
                
                //get seventh cell -> food special order
                if(!cells.hasNext())
                {
                    continue;
                }
                cell = (HSSFCell) cells.next();
                String foodSO = cell.getStringCellValue();
                if(foodSO.equals(null))
                {//allows empty food special order
                    continue;
                }
                f1.mFoodSpecialOrder = foodSO;
            }
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (fis != null) 
            {
                try
                {
                    fis.close();
                }
                catch(Exception e)
                {
                }
            }
        }

    }
    

    
    /**
     * findOrAddCategory(String newCategoryName) takes in a category name to locate it if it exists, or add new if it doesn't
     * @param newCategoryName
     * @return 
     */
     public CategoryClass findOrAddCategory(String newCategoryName)
    {
        CategoryClass newCategory = mCategories.find(newCategoryName);
        
        if(newCategory!=null) //if there's a duplicate, category won't be added
        {
            return newCategory;
        }
        //else
        newCategory = new CategoryClass(newCategoryName);
        mCategories.add(newCategory);
        
        return newCategory;
    }
     
     /**
      * findOrAddFood(CategoryClass c1, String foodName) takes in two parameters, a CategoryClass object and a food name, to locate existing food or add new
      * @param c1
      * @param foodName
      * @return 
      */
     public FoodItemClass findOrAddFood(CategoryClass c1, String foodName)
    {
        FoodItemClass food1 = c1.mFoodItems.find(foodName);
        
        if(food1!=null) //if there's a duplicate, category won't be added
        {
            return food1;
        }
        //else
        food1 = new FoodItemClass();
        food1.mFoodName = foodName;
        c1.mFoodItems.add(food1);
        
        return food1;
    }

    /**
     * addCategory(String newCategoryName) takes in the name of new category to be added and returns true or false if addition was successful
     * @param newCategoryName
     * @return 
     */
    
    public boolean addCategory(String newCategoryName)
    {
        CategoryClass newCategory = new CategoryClass(newCategoryName);
        
        //System.out.println("There are currently " + mCategories.count + " categories.");
        
        if(mCategories.contains(newCategory)) //if there's a duplicate, category won't be added
        {
            mLastError = "Category name already exists!";
            return false;
        }
        
        mCategories.add(newCategory);
        
        //System.out.println("Category : " + newCategoryName + " was added.");
        //System.out.println("There are now " + mCategories.count + " categories.");
        
        this.debugPrint();
        
        return true;
    }
    
    /**
     * deleteCategory(String deleteCategoryName) takes in the name of category to be deleted & returns true or false if deletion was successful
     * @param deleteCategoryName
     * @return 
     */
    public boolean deleteCategory(String deleteCategoryName)
    {
        //use find() to locate category to remove
        CategoryClass deleteThisCategory = mCategories.find(deleteCategoryName);
        //return false if not found - set error message mLastError
        if(deleteThisCategory==null)
        {
            mLastError = "Cannot delete! Category : " + deleteCategoryName + " does not exist";
            return false;
        }
        //try to call remove() of LinkedList.java to remove the found category
        try
        {
            mCategories.remove(deleteThisCategory);
        }
        catch(Exception e)// catch errors and return false - set error message mLastError
        {
            mLastError = "Category : " + deleteCategoryName + " cannot be deleted at this time";
            return false;
        }

        return true;
    }
    
    /**
     * createOrSave (FoodItemClass foodToAdd, String categoryName) takes in a FoodItemClass object and the name of category. 
     * If an existing match is found, the food item will be updated. Else, a new food will be created.
     * @param foodToAdd
     * @param categoryName
     * @return
     * @throws Exception 
     */
    public boolean createOrSave (FoodItemClass foodToAdd, String categoryName) throws Exception
    {
        CategoryClass category1 = this.mCategories.find(categoryName);
        if(category1==null)
            throw new Exception("Category does not exist");
        
        FoodItemClass resultFoodItem = category1.mFoodItems.find(foodToAdd.mFoodName);
        if(resultFoodItem==null)
        {
            //if result is null, Add a new food item
            category1.mFoodItems.add(foodToAdd);
            
            return true; //true if adding new food item
        } 
        else
        {
            //if there is a match, update the existing food item
            resultFoodItem.updateFrom(foodToAdd); //copying from new food item to existing food item
            
            return false; //false if updating existing food item
        }
             
        
   }
    
    
    
    
    
    
    
    
    public void debugPrint()
    {
        LinkedListNode<CategoryClass> iter = mCategories.list;
        
        while (iter != null) 
        {
            iter.getElement().debugPrint();
            
            iter = iter.getLink();
        }
    }
}