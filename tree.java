public class tree
{
    class node
    {
        node left;
        node right;
        int data;
	node(int y)
	{
	    this.data=y;
	    this.left=null;
	    this.right=null;
	}
    }
    node root=null;
    node putnode(node x,int y)
    {
	if(x==null)
	{
	    x=new node(y);
	    return x;
	}
        if(y<x.data)
	    x.left=putnode(x.left,y);
        if(y>x.data)
	    x.right=putnode(x.right,y);
	return x;
    }
    void put(int y)
    {
	root=putnode(root,y);
    }
    void inorder(node x)
    {
	if(x==null)
	    return;
	inorder(x.left);
	System.out.println(x.data);
	inorder(x.right);
    }
    int sum=0;
    int height(node x)
    {
	if(x==null)
	    return 0;
	int lheight=height(x.left);
	int rheight=height(x.right);
	int subht=lheight>rheight?lheight:rheight;
	return 1+subht;
    }
    void levelorder(node x)
    {
	int h=height(x);
	int i,n=0;
	for(i=0;i<h;i++)
	{
            printlevel(x,i,n);
	    System.out.println();
	    n++;
	}
    }
    void printlevel(node x,int h,int n)
    {
	if(x==null)
	    return;
	if(h==0)
	  {
	      if(n%2==0)
		sum=sum + x.data;
	      else
		sum=sum - x.data;
	      System.out.print(x.data + " ");
	  }
	else
	{

                printlevel(x.left,h-1,n);
                printlevel(x.right,h-1,n);

        }
    }
    public static void main(String args[])
    {
	tree t=new tree();
	t.put(6);
	t.put(8);
	t.put(5);
	t.put(4);
	t.put(12);
	t.put(10);
	t.inorder(t.root);
	System.out.println();
	t.levelorder(t.root);
        System.out.println();
        System.out.println(t.sum);
    }
}