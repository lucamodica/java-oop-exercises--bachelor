import java.util.*;

class Matrix_method_l{
//METHOD TO FILL IN
 public static <T extends Comparable<T>> int l(T v[][], T x)
 {
     int count = 0;   
     for(int i = 0;i < v.length; i++){
        for(int j = 0;j < v[i].length; j++){
            if(v[i][j].compareTo(x) >= 0){
                count++;
            }
        }
     }
     return count;
 }

//TEST DEFINITION
 public static int c(int y)
  {if ( y >= 2 ) return 1; else return 0;}
  
 public static int c2(T y)
  {if ( y.s.compareTo("b") >= 0) 
    return 1; 
  else 
   return 0;}
   
public static String toString(Integer[] v, int i)
 {if (v.length==0)
   return "{}";
  else if (v.length==1)
   return "{" + v[0] + "}";  
  else if (i==0)
   return "{" + v[0] + "," + toString(v,1);
  else if (i == v.length-1) 
   return v[i] + "}"; 
  else 
   return v[i] + "," + toString(v,i+1);
 }
 
 public static String toString(Integer[][] v, int i)
 {if (v.length==0)
   return "{}";
  else if (v.length==1)
   return "{" + toString(v[0],0) + "}";  
  else if (i==0)
   return "{" + toString(v[0],0) + "," + toString(v,1);
  else if (i == v.length-1) 
   return toString(v[i],0) + "}"; 
  else 
   return toString(v[i],0) + "," + toString(v,i+1);
 }
 
 public static void test1(){
  Integer v[][][]=
  {
    { { 2 }, { 2 + 1, 2 + 2 } },     //v[0]
    { { 2 }, { 2 + 1, 2 - 1 } },     //v[1]
    { { 2, 2 - 1}, { 2 }     },      //v[2]
    { { 2, 2 - 1}, { 2 - 2 } },      //v[3]
    { { 2, 2    , 2 }, {}     },     //v[4]
    { { 2 }, { 2 + 1, 2}     },      //v[5]
    { {}, {}, {}},                               //v[6]
 };  
     
  Integer answ[] =
  {c(2) + c(2+1) + c(2+2),
   c(2) + c(2+1) + c(2-1),
   c(2) + c(2-1) + c(2),
   c(2) + c(2-1) + c(2-2),
   c(2) + c(2) + c(2),
   c(2) + c(2+1) + c(2),
    0
  };
  
 for(int i=0;i<v.length;i++) 
   check("v[" + i + "]=" + toString(v[i],0) 
         + "\n l(v[" + i + "],2)=",
         l(v[i],2), 
         answ[i]);

 T a = new T("a"), b = new T("b"), c = new T("c");
 T[][] w = { {a,b,b,c}, {c,c,c} }; 
 int answ2 = c2(a) + c2(b)*2 + c2(c)*4;   
 check("w={ {a,b,b,c}, {c,c,c} } \n l(w,b)=",
       Matrix_method_l.l(w,new T("b")),
       answ2);
} 

//COMPARING WITH THE RIGHT ANSWER
 public static void check(String s, int a, int b)
 {if (a==b) 
   System.out.println(s + a + " OK"); 
  else 
   System.out.println(s + a + " EXPECTED " + b);
 }

//TEST EXECUTION
public static void main(String[] args)
 {
  test1();
 }
      
}

class T implements Comparable<T>
{public String s;

 public T(String s){this.s=s;}
    
 public int compareTo(T y)
  {return s.compareTo(y.s);} 
}