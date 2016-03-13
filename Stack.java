public class Stack
{
	private int top ;
	private int arr[];
	private int size;
	Stack()
	{
			top = -1;
			size = 100;
			arr = new int[size];
	}
	public int pop()
	{
		if(top>=0)
		return arr[top--];
	
		return -6;
	}
	public void push(int x)
	{
		if(top<size)
			arr[++top] = x;
		else
			System.out.println("out of limits ");
	}
	
	public void seek()
	{
		System.out.println(arr[top]);
	}
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		return false;
	}
	public boolean isFull()
	{
		if(top==size)
			return true;
		return false;
	}
}