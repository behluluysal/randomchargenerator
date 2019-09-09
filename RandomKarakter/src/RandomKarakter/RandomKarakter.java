/**  
 * 
 * @author Süleyman Behlül UYSAL, Alperen TOKLU
 * @since 19.03.2019  
 **  Açıklama  **/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomKarakter;

/**
 *
 * @author sbuys
 */
public class RandomKarakter {
    
    String result = "";
    char[] letters = {'a','b','c','ç','d','e','f','g','ğ','h','ı','i','j','k','l','m','n','o','ö'
                         ,'p','r','s','ş','t','u','ü','v','y','z'}; //29 karakter var
    String[] letterss = {"a","b","c","ç","d","e","f","g","ğ","h","ı","i","j","k","l","m","n","o"
                          ,"ö","p","r","s","ş","t","u","ü","v","y","z"};
    
   
    public String randomcharacter1 (int x)
    {
        int[] results1 = new int[x];
        for(int i = 0; i<x; i++)
        {
            results1[i]= (int)(System.nanoTime()%29);
        }
        result = collector(results1,x);
        //result = Arrays.toString(results1);
        return result;
    }
    
    public String randomcharacter2 (int x)
    {
        int lastindex = 0;
        boolean flag2 = false;
        boolean flag1 = false;
        int test;
        int[] results1 = new int[x];
        results1[0]= (int)(System.nanoTime()%29);
        
        for(int i = 1; i<x; i++)
        {
            if(i==28)
            {
                for(int a = 0; a<results1.length-1; a++)
                {
                    for(int z=0; z<results1.length-1;z++)
                        if(lastindex == results1[z])
                            flag2 = true;
                    lastindex++;
                    if(flag2 == false)
                    {
                      results1[28] = lastindex;
                      break;
                    }
                        
                    
                }
            }
            test = (int)(System.nanoTime()%29);
            for(int y = 0; y<x ;y++)
            {
                if(test == results1[y])
                    flag1 = true;
            }
            if(flag1==false)
            {
                results1[i] = test;
            }
            else
            {
                i--;
                flag1 = false;
            }
                
        }
        result = collector(results1,x);
        return result;
    }
    
    public String randomcharacter3 (int max, String input)
    {
        boolean flagt = false;
        int calc = 0;
        String[] splitted = input.replaceAll(",", "").split("");
        String[] work = new String[splitted.length];
        for(int i = 0; i< splitted.length ;i++)
        {
            for(int y = 0; y< letters.length ;y++)
            {
                if((letterss[y]).equals(splitted[i]))
                {
                    for(int z = 0; z<work.length;z++)
                    {
                        if(splitted[i].equals(work[z]))
                        {
                            flagt=true;
                            break;
                        }                     
                    }
                    if(flagt == false)
                    {
                        work[calc] = splitted[i];
                        calc++;
                        break;
                    }  
                    else if(flagt == true)
                        break;
                }
                flagt=false;
            }
        }
        
        int[] workint = new int[calc];
        calc=0;
        for(int i = 0;i<work.length;i++)
        {
            if(work[i] != null)
                for(int y=0;y<letterss.length;y++)
                {
                    if(work[i].equals(letterss[y]))
                    {
                        workint[calc] = y;
                        calc++;
                    }

                }
            else if(work[i]==null)
                break;
        }
        calc=0;
        boolean flag1 = true;
        boolean flag2 = true;
        int[] resulst = new int[max];
        for(int i = 0; i<max;i++)
            resulst[i] = 31;
        int temp = (int)(System.nanoTime()%29);
        if(workint.length < max)
            return ("That's illegal.");
        for(int i = 0; i<max; i++)
        {
            flag1=true;
            while(flag1)
            {
                for(int y = 0; y<workint.length;y++)
                {
                    if(temp == workint[y])
                    {
                        for(int z=0;z< resulst.length;z++)
                        {
                            if(temp==resulst[z])
                                flag2=false;
                        }
                        if(flag2 != false)
                        {
                            resulst[calc]=temp;
                             calc++;
                             flag1=false;
                             break;
                        }

                    }
                }
                flag2=true;
                temp = (int)(System.nanoTime()%29);
            }
        }
        return collector(resulst,max);
    }
    public String randomcharacter3(int max, String ch1, String ch2)
    {
        int[] chints = new int [2];
        String[] characters = new String[2];
        characters[0] = ch1;
        characters[1] = ch2;
        
        for(int i = 0; i<2;i++)
        {
            for(int y= 0; y<letterss.length;y++)
            {
                if(characters[i].equals(letterss[y]))
                {
                    chints[i]=y;
                    break;
                }
                    
            }
        }
        if(chints[0] == chints[1])
            return "There are no characters between the chosen ones.";
        int control = (chints[0]-chints[1]);
        if(control < 0)
            control = control*(-1);
        control= control-1;
        if(control < max)
            return"There is "+control+" characters between inputs but you want "+max+" characters...";
        
        int max2;
        boolean flag1=true;
        boolean flag2=false;
        if(chints[0]<chints[1])
        {
            
        }
        else
        {
            max2 = chints[1];
            chints[1] = chints[0];
            chints[0] =max2;
        }
        max2 = chints[1];
        int[] resulst = new int[max];
        for(int i= 0; i<max;i++)
            resulst[i]=31;
        int temp = (int)(System.nanoTime()%max2);
        for(int i = 0; i<max; i++)
        {
            flag1=true;
            while(flag1)
            {
                if(temp>chints[0] && temp<chints[1])
                {
                   for(int y = 0 ; y<max;y++)
                    {
                        if(resulst[y]==temp)
                          flag2=true;
                    } 
                   if(flag2 == false)
                       flag2=true;
                   else
                       flag2=false;
                }
                
                if(flag2)
                {
                    resulst[i]=temp;
                    flag1=false;
                    flag2=false;
                } 
                 temp = (int)(System.nanoTime()%max2);
            }
           
        }
        
        
        
        
        return collector(resulst,max);
                
    }
    
    public String randomsentence(int maxw, int maxl)
    {
        int maxwords = (int)(System.nanoTime()%maxw+1);
        int maxletters = (int)(System.nanoTime()%maxl+1);
        String[] sentence = new String [maxwords];
        String sentence2="";
        String tempword;
        for(int i = 0; i<maxwords;i++)
        {
           tempword = randomcharacter2(maxletters).replaceAll(",", "");
           maxletters = (int)(System.nanoTime()%maxl+1);
           sentence[i]=tempword;
        }
        
        for(int i = 0; i<maxwords;i++)
        {
            sentence2+=sentence[i]+"   ";
            
        }
        return sentence2;
    }
    
    
            
    
    
    
    
    
    
    
    
    public String collector(int[] exarray, int max)
    {
        result = "";
        for(int i = 0; i< max;i++)
            for(int y= 0; y<=28;y++)
            {
                if(exarray[i]==y)
                {
                    result += (letters[y]+","); 
                    break;
                    //result += exarray[i];
                }
                    
            }
        return result;
    }
}
