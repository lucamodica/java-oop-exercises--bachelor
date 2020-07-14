import java.util.*;

//SALVATE TUTTO IN UN SOLO FILE Ex.java
abstract class Tree<T extends Comparable<T>> 
 {public abstract String m(T x, T z);
  public abstract String toString();
 }

class Leaf<T extends Comparable<T>> extends Tree<T> 
 {public String m(T x, T z)
  { 
      return "";
  }
  
  public String toString(){return "{}";}
 }

class Branch<T extends Comparable<T>> extends Tree<T> 
 {private T elem;private Tree<T> left, right;
  public Branch(T elem, Tree<T> left, Tree<T> right) 
   {this.elem = elem;this.left = left;this.right = right;}

  public String m(T x, T z){ 
        if(this.elem.compareTo(x) == 0 || this.elem.compareTo(z) > 0 ){
            return elem + left.m(x,z) + right.m(x,z);
        }
        return left.m(x,z) + right.m(x,z);
  }
     
  public String toString()
   {String l=left.toString(), r=right.toString();
    return "{" + elem.toString()+l+r + "}";
   }
 }
 
class Tree_Method_m{

//TEST DEFINITION
 public static Random r = new Random();
 
 public static T r()
 {int n = r.nextInt(5);
  if (n==0) 
   return new T("a");
  else if (n==1)
   return new T("b");
  else if (n==2)
   return new T("c");
  else if (n==3)
   return new T("d");
  else //n=4
   return new T("e");
 }
 
 static T b=new T("b"); static T d=new T("d");

 public static Tree<T> c(T elem, Tree<T> left, Tree<T> right)
  {return new Branch<T>(elem, left, right);}
  
public static String d(T elem, String l, String r)
  {if ( (elem.compareTo(b)==0) || (elem.compareTo(d) >  0) )
    return elem.toString()+l+r;
   else
    return l+r;
  }
  
public static void test(){
T[] v = {r(),r(),r(), r(),r(),r(), r(),r(),r()};
Tree<T> l = new Leaf<>();

Tree<T> t1 = c(v[1], l, c(v[2],c(v[3],l,l), c(v[4],l,l)) );
Tree<T> t2 = c(v[5],  c(v[6],c(v[7],l,l),c(v[8],l,l)), l );

String ris1 = d(v[1], "", d(v[2],d(v[3],"",""), d(v[4],"","")) );
String ris2 = d(v[5],  d(v[6],d(v[7],"",""),d(v[8],"","")), "" );
  
check("t1 = " + t1.toString() + "\n t1.m(b,d)=",
       t1.m(b,d),
       ris1
       );
check("t2 = " + t2.toString() + "\n t2.m(b,d)=",
       t2.m(b,d),
       ris2
       );
} 

//COMPARING WITH THE RIGHT ANSWER
 public static <T> void check(String s, T a, T b)
 {if (a.equals(b)) 
   System.out.println(s + a + " OK"); 
  else 
   System.out.println(s + a + " EXPECTED " + b);
 }

 static void msg()
 { System.out.println
   ("Alberi in pre-ordine: leaf={}, branch={ elem,left,right }");
   System.out.println
   ("m concatena in pre-ordine tutti i nodi che soddisfano:\n (elem uguale ad b) oppure (elem maggiore di d)");
  }
  
//TEST EXECUTION
public static void main(String[] args)
 {
  msg();test();test();test();
 }
      
}

class T implements Comparable<T>
{public String s;
 public T(String s){this.s=s;}
 public int compareTo(T y)
  {return s.compareTo(y.s);}
 public String toString(){return s;}
}