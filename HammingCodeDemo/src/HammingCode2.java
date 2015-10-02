/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Scar
 */
public class HammingCode2 {
    
//since Hamming code index goes from right to left, starting with 1,
//that's the opposite of how array index goes
//calculation in the "code" array goes from left to right, starting with index 1,
//index 0 in the code array is not used


    private String data;
    private int [ ] code;
    private int codeSize;
    private int paritySize;
    private int dataSize;

    private int [ ] received;
    
    
    
    public static void main (String [ ] args)
    {
        HammingCode2 x = new HammingCode2("101011110111");
        x.errorChecking ( );
        
        Scanner kbd = new Scanner (System.in);
        System.out.print ("\ndata? ");
        x.setHammingCode (kbd.nextLine ( ));
        
        System.out.print ("\nreceived code? ");
        x.errorChecking(kbd.nextLine ( ));
        
    }
    
    
    public HammingCode2()
    {
        codeSize = 0;
        paritySize = 0;
        dataSize = 0;
    }
    
    public HammingCode2(String nData)
    {
        data = nData;
        dataSize = data.length ( );
        setParitySize ( );
        setCode ( );
        
    }
    
    public void setHammingCode(String nData)
    {
        data = nData;
        dataSize = data.length ( );
        setParitySize ( );
        setCode ( );
    }
    
    private void setParitySize()
    {
        
        System.out.println ("\n\ndata = " + data);
        paritySize = 1;
        while (true)
        {
            if ((int) Math.pow (2,paritySize) >= (dataSize + paritySize + 1))
                break;
            paritySize++;
        }
        
        System.out.println ("paritySize = " + paritySize);
        
    }
    
    private void setCode()
    {
             
        codeSize = paritySize + dataSize;
        code = new int [codeSize+1];
        
        for (int i = 1; i <= codeSize; i++)
            code[i] = 0;
        
        //first, put data bits in the code, from right to left
        setDataBits ( );
        //calculate even parity bits
        setParityBits ( );
        
        printCode ( );
     
    }
    
    private void setParityBits ( )
    {
        int parityIndex = 0;
        while (parityIndex < paritySize)
        {
            int parityBitPosition = (int)Math.pow(2,parityIndex);
            
            System.out.println ("parity bit position = " + parityBitPosition);
            int codeIndex = parityBitPosition;
            int checkAndSkip = parityBitPosition;
            int sumOfOnes = 0;
            while (codeIndex <= codeSize)
            {
                //check "parityBitPosition" bits
                for (int i = 1; i <= checkAndSkip; i++)
                {
                    System.out.println ("checking bit " + codeIndex);
                    sumOfOnes += code[codeIndex];
                    if ((++codeIndex)> codeSize)
                        break;
                }
                
                //and skip "parityBitPosition" bits
                if (codeIndex <= codeSize)
                    codeIndex += checkAndSkip;
            }
            
            int parity = sumOfOnes % 2;
            code[parityBitPosition] = parity;
            parityIndex++;
        }
        
        
    }
    
    private void printCode ( )
    {
        System.out.print ("\nHamming Code = ");
        for (int i = codeSize; i >= 1; i--)
            System.out.print (code[i] + " ");
    }
    
    private void setDataBits ( )
    {
        int dataIndex = dataSize - 1;
        int parityIndex = 0;
        int codeIndex = 1;
        while ((codeIndex <= codeSize)&& (dataIndex >=0))
        {
           //this bit in the code is used by parity, skip 
           if (codeIndex == (int)Math.pow (2,parityIndex))
               parityIndex++;
           else
               code[codeIndex] = data.charAt(dataIndex--)- 48;
           
           codeIndex++;
        }       
    }
    
    
    public void selectErrorBit ( )
    {
        Random gen = new Random ( );
        //randomly select a bit to flip
        int errorBitIndex = gen.nextInt (codeSize) + 1;
        System.out.println ("\n\n**bit " + errorBitIndex + " flipped on purpose for testing........");
        received = new int [codeSize+1];
        
        for (int i = 1; i <= codeSize; i++)
            received[i] = code[i];
        
        if (received[errorBitIndex] == 1)
            received[errorBitIndex] = 0;
        else
            received[errorBitIndex] = 1;
        
        System.out.print ("\nreceived code = ");
        for (int i = codeSize; i>= 1; i--)
            System.out.print (received[i] + " ");
    }
    
    public void detectErrorBit ( )
    {
        int receivedCodeSize = received.length - 1;
        int parityIndex = 0;
        int errorBitPosition = 0;
        while (true)
        {
            int parityBitPosition = (int)Math.pow(2,parityIndex);
            if (parityBitPosition > receivedCodeSize)
                break;
            
            System.out.println ("\nparity bit position = " + parityBitPosition);
            int codeIndex = parityBitPosition;
            int checkAndSkip = parityBitPosition;
            int sumOfOnes = 0;
            while (codeIndex <= receivedCodeSize)
            {
                //check "parityBitPosition" bits
                for (int i = 1; i <= checkAndSkip; i++)
                {
                    System.out.println ("checking bit " + codeIndex);
                    sumOfOnes += received[codeIndex];
                    if ((++codeIndex)> receivedCodeSize)
                        break;
                }
                
                //and skip "parityBitPosition" bits
                if (codeIndex <= receivedCodeSize)
                    codeIndex += checkAndSkip;
            }
            
            if ((sumOfOnes%2)!= 0)
            {
                System.out.println ("\n**parity bit " + parityBitPosition + " is not right");
                errorBitPosition += parityBitPosition;
            }
                
            parityIndex++;
        }
        
        System.out.println ("\n**detected error bit position = " + errorBitPosition);
    }
        
    //randomly select a bit to test
    public void errorChecking ( )
    {
        selectErrorBit ( );
        detectErrorBit ( );
    }
    
    //let the user enter received code
    public void errorChecking (String receivedCode)
    {
        System.out.println ("\nreceived code = " + receivedCode);
        int receivedCodeSize = receivedCode.length ( );
        received = new int [receivedCodeSize+1];
        int receivedIndex = 1; int receivedCodeIndex = receivedCodeSize - 1;
        while (receivedCodeIndex >= 0)
            received[receivedIndex++] = receivedCode.charAt(receivedCodeIndex--) - 48;
 
        int parityIndex = 0;
        int errorBitPosition = 0;
        while (true)
        {
            int parityBitPosition = (int)Math.pow(2,parityIndex);
            if (parityBitPosition > receivedCodeSize)
                break;
            
            System.out.println ("\nparity bit position = " + parityBitPosition);
            int codeIndex = parityBitPosition;
            int checkAndSkip = parityBitPosition;
            int sumOfOnes = 0;
            while (codeIndex <= receivedCodeSize)
            {
                //check "parityBitPosition" bits
                for (int i = 1; i <= checkAndSkip; i++)
                {
                    System.out.println ("checking bit " + codeIndex);
                    sumOfOnes += received[codeIndex];
                    if ((++codeIndex)> receivedCodeSize)
                        break;
                }
                
                //and skip "parityBitPosition" bits
                if (codeIndex <= receivedCodeSize)
                    codeIndex += checkAndSkip;
            }
            
            if ((sumOfOnes%2)!= 0)
            {
                System.out.println ("\n**parity bit " + parityBitPosition + " is not right");
                errorBitPosition += parityBitPosition;
            }
                
            parityIndex++;
        }
        
        System.out.println ("\n**detected error bit position = " + errorBitPosition);
        
        
    }
            
}


