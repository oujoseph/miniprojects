

import java.io.*;
import java.util.*;

class StringArray
{
    //both char and string versions are accessible
    char[] element;
    String data;
    static int numberOfStringArrays = 0;
    
    public StringArray(String newData){
        this.data = newData;
        this.element = this.data.toCharArray();
        this.numberOfStringArrays++;
    }
    
    public String makeStr(){
        return String.valueOf(this.element);
    }
    
    public String getSortedStringArray(){
        char[] sortedElement = this.element;
        Arrays.sort(sortedElement);
        return String.valueOf(sortedElement);
        
    }
}


class stringPermutation
{
    public static Boolean isPermutation(StringArray first, StringArray second) {
        if(first.getSortedStringArray().equals(second.getSortedStringArray())) {
            return true;
        }
        
        return false;
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        StringArray first = new StringArray("babby");
        StringArray second = new StringArray("dog");
        StringArray third = new StringArray("god");
        
        
        Boolean result = isPermutation(second, third);
        
        
        //STATIC IS A UNIVERSAL MAGICAL THING THAT LINKS INSTANCES OF StringArray. 
        // numberOfStringArrays counts number of StringArray instances that have been called.
        System.out.println(result.toString());
        System.out.println(first.element);
        System.out.print("Number of StringArray instances: ");
        System.out.println(first.numberOfStringArrays);
    }
}
