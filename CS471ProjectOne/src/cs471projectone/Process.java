/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs471projectone;
import java.util.*;

/**
 *
 * @author Caroline Chey
 */
public class Process implements Comparable {
    
    int pID;
    int priority;
    String pName;
    
    int pRunCount; //run count for Process
    
    //default constructor
    Process()
    {
        pID = 0;
        priority = 0; 
        pName = "No Name";
        pRunCount = 0;
    }

    //constructor
    Process(int pIDx, int priorityx, String pNamex)
    {
        pID = pIDx;
        priority = priorityx;
        pName = pNamex;
        pRunCount = 0;
    }
    
    
    public String toString()
    {
        String ret  = Integer.toString(this.pID);
        ret += (" " + Integer.toString(this.priority));
        ret += (" " + pName);
        
        return ret;
    }
    /*
    static abstract class PQsort implements Comparator<Process> 
    {
        public boolean higher(Process one, Process two) 
        {
                return one.priority >= two.priority;
        }
    } */

    @Override
    public int compareTo(Object o) {
    
        if(!(o instanceof Process))
            throw new ClassCastException("Process object expected");
    
        int ret = (((Process)(o)).priority - this.priority);
        if(ret != 0) return ret;
        
        return ( this.pRunCount - ((Process)(o)).pRunCount );
    }
}
