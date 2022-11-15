// Name:
// Student number:
import java.util.Arrays;
public class Sort
{
	
	////// Implement the functions below this line //////
	
	/********** MERGE **********/
	public static <T extends Comparable<? super T>> void mergesort(T[] data, int first, int last, boolean debug)
	{
		// Your code here
		if (last <= first) return;
		int middle= (last+first)/2;

		mergesort(data,first,middle,debug);
		mergesort(data,middle+1,last,debug);
		//System.out.println("outside>>>>"+middle);
		merge(data,first,last,debug);
	}

	public static class el<T>{
		public T x;
		public el(T x){
			this.x=x;
		}
	}

	private static <T extends Comparable<? super T>> void merge(T[] data, int first, int last, boolean debug)
	{
		int middle= (int) ((last+first)/2);
		int x1=middle-first+1;
		int x2=last-middle;
		el<T>[] Left=new el[x1];
		el<T>[] Right=new el[x2];
		// Your code here
		//System.out.println(data[first]);

		for (int i = 0; i < Left.length; i++) {
			Left[i] = new el<T>(data[first+i]);
			//Left[i].x=data[first+i];
		}
		for (int i = 0; i < Right.length; i++) {
			Right[i] = new el<T>(data[middle+1+i]);
			//Right[i].x=data[middle+1+i];
		}

		int x=0;
		int y=0;

		for (int i = first; i < last+1; i++) {
			// If there are still uncopied elements in R and L, copy minimum of the two
			if (x < Left.length && y < Right.length) {
				if (Left[x].x.compareTo(Right[y].x)<0)
				{
					data[i] = Left[x].x;
					x++;
				}
				else
				{
					data[i] = Right[y].x;
					y++;
				}
			}
			else if (x < Left.length)
			{
				// If all elements have been copied from rightArray, copy rest of leftArray
				data[i] = Left[x].x;
				x++;
			}
			else if (y < Right.length)
			{
				// If all elements have been copied from leftArray, copy rest of rightArray
				data[i] = Right[y].x;
				y++;
			}
		}
		//if (Left[x]!=null&&Right[y]!=null)
		/*while (x < x1 && y <x2)
		{
			double a=-1;
			a=Left[x].x.compareTo(Right[y].x);

			if (a<=0)
			{
				data[z]=Left[x].x;
				x++;
			}
			else
			{
				data[z]=Right[y].x;
				y++;
			}
			z++;
		}
		//if (Left[x]!=null)
		while (x<x1)
		{
			data[z]=Left[x].x;
			x++;
			z++;
		}
		//if (Right[y]!=null)
		while (y<x2)
		{
			data[z]=Right[y].x;
			y++;
			z++;
		}*/
		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}
     
	/********** COUNTING **********/
	public static void countingsort(int[] data, boolean debug)
	{
		int n=data.length;
		int max=data[0];
		for (int i = 0; i < n; i++) {
			if(data[i]>max)
			{
				max=data[i];
			}
		}
		// Your code here
		int[] c = new int[max + 1];
		Arrays.fill(c, 0);
		for (int i = 0; i < data.length; i++)
		{
			c[data[i]]++;
			//System.out.println(c[i]);
		}
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		int[] sorted = new int[data.length+1];
		Arrays.fill(sorted, 0);
		for (int i = data.length-1; i >= 0; i--) {
			int current = data[i];
			sorted[c[data[i]]--] = data[i];
			c[data[i]]--;
		}
		for(int i = 0; i < data.length; i++){
			data[i] = sorted[i+1];
			//System.out.print(data[i] + " ");
		}
		/*int n=data.length;
		for (int i = 0; i < n; i++) {
			if(data[i]>max)
			{
				max=data[i];
			}
		}
		int count[]=new int[max+1];
		for (int i = 0; i < max+1; i++) {
			count[i]=0;
		}
		*/
		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

}

