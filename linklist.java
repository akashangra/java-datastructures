import java.util.*;
public class linklist
{
    class node
    {
	node left;
        int data;
        node(int data)
        {
            this.data=data;
            this.left=null;
        }
         
    }
    node start=null;
    void put(int k)
    {
	node ptr=new node(k);
        node temp;
	if(start==null)
	    start=ptr;
        else
        {
            temp=start;
	    while(temp.left!=null)
		temp=temp.left;
	    temp.left=ptr;
        }
    }
    void get()
    {
	 node temp;
         temp=start;
         while(temp!=null)
         {
	     System.out.print(temp.data + " ");
             temp=temp.left;
	 }
    }
    public static void main(String args[])
    {
	linklist l=new linklist();
        l.put(1);
        l.put(2);
        l.put(5);
        l.put(3);
        l.get();
    }
}