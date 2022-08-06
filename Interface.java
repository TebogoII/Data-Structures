import java.text.DecimalFormat;

public class Interface {

	private Node origin;

	private String floatFormatter(float value){
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(value);
	}

	//DO NOT CHANGE THE ABOVE FUNCTION
	//Place your code below

	public Interface() {
		Origin f=new Origin();
		origin= new Node(f,0,0);
		origin.prevVal=null;
		origin.nextVal=null;
	}

	public Interface(Node[] arr) {
		Origin f=new Origin();
		origin= new Node(f,0,0);
		origin.prevVal=null;
		origin.nextVal=null;

		int x=arr.length;
		int v1,v2;
		for (int i=0;i<x;i++)
		{
			if (arr[x-1]!=null)
			{
				v1=arr[i].getVariables()[0];
				v2=arr[i].getVariables()[1];
				addPoint(arr[i].getFunction(),v1,v2);
			}
		}
	}

	public Node getOrigin() {
		return origin;
	}

	public float addPoint(Function function, int v1, int v2) {
		if (v1==0 || v2==0)
		{
			return Float.NaN;
		}
		Node n=new Node(function,v1,v2);
		Node curr=origin;
		//ADD AXIS v1
		if(v1>0) {
			while (curr.right != null) {
				if (curr.right.getVariables()[0] < v1)
					curr = curr.right;
				else break;
			}
			V1Axis f = new V1Axis();
			Node x = new Node(f, v1, 0);
			if (curr.right == null) {
				curr.right = x;
				x.left = curr;
				x.right = null;
			} else {
				if (curr.right.getVariables()[0] != v1) {
					x.left = curr;
					x.right = curr.right;
					x.left.right = x;
					x.right.left = x;
				}
			}
		}
		else {
			while (curr.left != null) {
				if (curr.left.getVariables()[0] > v1)
					curr = curr.left;
				else break;
			}
			V1Axis f = new V1Axis();
			Node x = new Node(f, v1, 0);
			if (curr.left == null)
			{
				curr.left = x;
				x.right = curr;
				x.left = null;
			}
			else
			{
				if (curr.left.getVariables()[0] != v1)
				{
					x.right = curr;
					x.left = curr.left;
					x.left.right = x;
					x.right.left = x;
				}
			}
		}
		//ADD AXIS v2
		curr=origin;
		if(v2>0) {
			while (curr.up != null) {
				if (curr.up.getVariables()[1] < v2)
					curr = curr.up;
				else break;
			}
			V2Axis f = new V2Axis();
			Node x = new Node(f, 0, v2);
			if (curr.up == null) {
				curr.up = x;
				x.down = curr;
				x.up = null;
			} else {
				//System.out.println("------------------------------------------------------------------->["+curr.getVariables()[0]+"]["+x.getVariables()[1]+"]    "+curr.getFunction().functionName);
				if (curr.up.getVariables()[1] != v2) {
					x.down=curr;
					x.up = curr.up;
					x.down.up = x;
					x.up.down = x;
				}
				else
				{
					//System.out.println("--------->["+curr.getVariables()[0]+"]["+x.getVariables()[1]+"]    "+curr.getFunction().functionName);
				}
			}
		}
		else {
			while (curr.down != null) {
				if (curr.down.getVariables()[1] > v2)
					curr = curr.down;
				else break;
			}
			V2Axis f = new V2Axis();
			Node x = new Node(f, 0, v2);
			if (curr.down == null)
			{
				curr.down = x;
				x.up = curr;
				x.down = null;
			}
			else
			{
				if (curr.down.getVariables()[1] != v2)
				{
					x.down = curr.down;
					x.up = curr;
					x.down.up = x;
					x.up.down = x;
				}
			}
		}

		//ADD NODE to v1
		curr=origin;
			//LEFT RIGHT
		if (v1>0)
		{
			while (curr.getVariables()[0] != v1) {
				curr = curr.right;
			}
		}
		else
		{
			while (curr.getVariables()[0] != v1) {
				curr = curr.left;
			}
		}
			//UP DOWN
		if (v2>0)
		{
			while (curr.up!=null)
			{
				if (curr.up.getVariables()[1]<v2)
					curr=curr.up;
				else break;
			}
			if (curr.up!=null)
			{
				//if (curr.up.getVariables()[1]==1) System.out.println("--------[1][1]"+curr.up.getVariables()[0]);
				if (curr.up.getVariables()[1]!=v2)
				{
					n.down=curr;
					n.up=curr.up;
					n.down.up=n;
					n.up.down=n;
				}
				else //insert prev & next ------------------------------------------------------------------------------
				{
					moveback(curr.up,n);
				}
			}
			else
			{
				n.down=curr;
				n.down.up=n;
				n.up=null;
			}
		}
		else
		{
			while (curr.down!=null)
			{
				if (curr.down.getVariables()[1]>v2)
					curr=curr.down;
				else break;
			}
			if (curr.down!=null)
			{
				if (curr.down.getVariables()[1]!=v2)
				{
					n.up=curr;
					n.down=curr.down;
					n.down.up=n;
					n.up.down=n;
				}
				else //insert prev & next ------------------------------------------------------------------------------
				{
					moveback(curr.down,n);
				}
			}
			else
			{
				n.up=curr;
				n.up.down=n;
				n.down=null;
			}
		}

		//ADD NODE to v2
		curr=origin;
			//UP DOWN
		if (v2>0)
		{
			while (curr.getVariables()[1] != v2) {
				curr = curr.up;
			}
		}
		else
		{
			while (curr.getVariables()[1] != v2) {
				curr = curr.down;
			}
		}
			//LEFT RIGHT
		if (v1>0)
		{
			while (curr.right!=null)
			{
				if (curr.right.getVariables()[0]<v1)
					curr=curr.right;
				else break;
			}
			if (curr.right!=null)
			{
				if (curr.right.getVariables()[0]!=v1)
				{
					n.left=curr;
					n.right=curr.right;
					n.left.right=n;
					n.right.left=n;
				}
				else //insert prev & next ------------------------------------------------------------------------------
				{
					//moveback(curr.right,n);
				}
			}
			else
			{
				n.left=curr;
				n.left.right=n;
				n.right=null;
			}
		}
		else
		{
			while (curr.left!=null)
			{
				if (curr.left.getVariables()[0]>v1)
					curr=curr.left;
				else break;
			}
			if (curr.left!=null)
			{
				if (curr.left.getVariables()[0]!=v1)
				{
					n.right=curr;
					n.left=curr.left;
					n.left.right=n;
					n.right.left=n;
				}
				else //insert prev & next ------------------------------------------------------------------------------
				{
					//moveback(curr.left,n);
				}
			}
			else
			{
				n.right=curr;
				n.right.left=n;
				n.left=null;
			}
		}
		return n.getValue();
	}

	public Node removePoint(int v1, int v2) {
		if (v1==0 || v2==0) return null;
		Node x=getPoint(v1,v2);
		if (x==null) return null;
		if (x.prevVal!=null)
		{
			Node n=x.prevVal;
			n.left=x.left; 	x.left=null;
			n.right=x.right;x.right=null;
			n.up=x.up; 		x.up=null;
			n.down=x.down; 	x.down=null;
			if (n.left!=null) 	n.left.right=n;
			if (n.right!=null)	n.right.left=n;
			if (n.up!=null) 	n.up.down=n;
			if (n.down!=null)	n.down.up=n;
			n.nextVal=null;
			x.prevVal=null;
			x.nextVal=null;
		}
		else
		{
			//left right
				//both not null
			if (x.left!=null && x.right!=null)
			{
				x.left.right=x.right;
				x.right.left=x.left;
				x.left=null;
				x.right=null;
			}
				//left only null
			if (x.left==null && x.right!=null)
			{
				x.right.left=null;
				x.right=null;
			}
				//right only null
			if (x.left!=null && x.right==null)
			{
				x.left.right=null;
				x.left=null;
			}

			//up down
				//both not null
			if (x.up!=null && x.down!=null)
			{
				x.down.up=x.up;
				x.up.down=x.down;
			}
				//down only null
			if (x.down==null && x.up!=null)
			{
				x.up.down=null;
			}
				//up only null
			if (x.down!=null && x.up==null)
			{
				x.down.up=null;
			}
		}
		Node c=origin;
		if (v1>0)
			while (c.getVariables()[0]!=v1)
				c=c.right;
		else
			while (c.getVariables()[0]!=v1)
				c=c.left;
		if (c.up==null&&c.down==null)
		{
			if (c.left==null)
			{
				c.right.left=null;
			}
			else if (c.right==null)
			{
				c.left.right=null;
			}
			else
			{
				c.right.left=c.left;
				c.left.right=c.right;
			}
		}

		c=origin;
		if (v2>0)
			while (c.getVariables()[1]!=v2)
				c=c.up;
		else
			while (c.getVariables()[1]!=v2)
				c=c.down;
		if (c.right==null&&c.left==null)
		{
			if (c.down==null)
			{
				c.up.down=null;
			}
			else if (c.up==null)
			{
				c.down.up=null;
			}
			else
			{
				c.up.down=c.down;
				c.down.up=c.up;
			}
		}

		x.up=null;
		x.down=null;
		x.left=null;
		x.right=null;
		x.prevVal=null;
		x.nextVal=null;
		return x;
	}

	public Node getPoint(int v1, int v2) {
		Node curr= origin;
		//Go to v1
		if (v1==0 || v2==0) return null;
		if (v1>0)
		{
			while (curr.getVariables()[0]!=v1)
			{
				curr=curr.right;
				if (curr==null)
				{
					return null;
				}
			}
		}
		else
		{
			while (curr.getVariables()[0]!=v1)
			{
				curr=curr.left;
				if (curr==null)
				{
					return null;
				}
			}
		}
		//Go to v2
		if (v2>0)
		{
			while (curr.getVariables()[1]!=v2)
			{
				curr=curr.up;
				if (curr==null)
				{
					return null;
				}
			}
		}
		else
		{
			while (curr.getVariables()[1]!=v2)
			{
				curr=curr.down;
				if (curr==null)
				{
					return null;
				}
			}
		}
		return curr;
	}

	public Node[] toArray() {
		Node[] arr=new Node[countNumberOfPoints()];
		Node curr=origin;
		if (origin==null) return arr;
		if (origin.left==null && origin.right==null) return arr;
		//Q1 top right
		//curr=origin.right;
		int n=0;
		while (curr.right!=null)
		{
			curr=curr.right;
		}
		while (curr!=null)
		{
			Node x=curr;
			if (x!=origin)
			{
				while (curr.up!=null)
				{
					curr=curr.up;
				}
				while (curr!=null)
				{
					if (curr!=x)
					{
						arr[n] = curr;
						n++;
						Node temp=curr;
						while (temp.prevVal!=null)
						{
							arr[n] = temp.prevVal;
							n++;
							temp=temp.prevVal;
						}
					}
					curr = curr.down;
				}
			}
			curr=x.left;
		}

		return arr;
	}

	public float calculateValue(Function function, int v1, int v2) {
		Node n=new Node(function,v1,v2);
		return n.getValue();
	}

	public float findMaxValue() {
		Node[] arr=toArray();
		Node max=arr[0];
		//Q1 top right
		for (int i=1;i<arr.length;i++)
		{
			if (max.getValue()<arr[i].getValue())
			{
				max=arr[i];
			}
		}
		return max.getValue();
	}

	public Node findMax() {
		Node[] arr=toArray();
		Node max=arr[0];
		//Q1 top right
		for (int i=1;i<arr.length;i++)
		{
			if (max.getVariables()[0]<arr[i].getVariables()[0])
			{
				max=arr[i];
			}
		}
		for (int i=1;i<arr.length;i++)
		{
			if (max.getVariables()[0]==arr[i].getVariables()[0])
				if (max.getVariables()[1]<arr[i].getVariables()[1])
				{
					max=arr[i];
				}
		}
		return max;
	}

	public float findMinValue() {
		Node[] arr=toArray();
		Node min=arr[0];
		//Q1 top right
		for (int i=1;i<arr.length;i++)
		{
			if (min.getValue()>arr[i].getValue())
			{
				min=arr[i];
			}
		}
		return min.getValue();
	}

	public Node findMin() {
		Node[] arr=toArray();
		Node min=arr[0];
		//Q1 top right
		for (int i=1;i<arr.length;i++)
		{
			if (min.getVariables()[0]>arr[i].getVariables()[0])
			{
				min=arr[i];
			}
		}
		for (int i=1;i<arr.length;i++)
		{
			if (min.getVariables()[0]==arr[i].getVariables()[0])
			if (min.getVariables()[1]>arr[i].getVariables()[1])
			{
				min=arr[i];
			}
		}
		return min;
		//System.out.println(curr.getVariables()[0]+":"+curr.getVariables()[1]);
	}

	public String printFunctionValues(String functionName) {
		String str="";
		if (origin.left==null && origin.right==null)
			return str;
		Node curr=origin;
		Node ax=origin;
		while (curr.left!=null)
			curr=curr.left;
		if (curr==origin)
			curr=curr.right;
		ax=curr;
		while (ax!=null)
		{
			while (curr.down!=null)
				curr=curr.down;
			if (curr==ax)
				curr = curr.up;
			while (curr!=null)
			{
				if (curr.getFunction().functionName==functionName)
				{
					str=str+floatFormatter(curr.getValue())+";";

					//System.out.println("-->["+curr.getVariables()[0]+"]["+curr.getVariables()[1]+"]    "+curr.getFunction().functionName);
				}
				Node temp=curr;
				while (temp.prevVal!=null)
				{
					//System.out.println("---->["+temp.prevVal.getVariables()[0]+"]["+temp.prevVal.getVariables()[1]+"]    "+temp.prevVal.getFunction().functionName);
					if (temp.prevVal.getFunction().functionName==functionName)
					{
						//System.out.println("---->["+temp.getVariables()[0]+"]["+temp.getVariables()[1]+"]    "+temp.getFunction().functionName);
						str=str+floatFormatter(temp.prevVal.getValue())+";";
					}
					temp=temp.prevVal;
				}
				curr=curr.up;
			}
			ax=ax.right;
			curr=ax;
		}
		if (str.length()!=0)
			str=str.substring(0,str.length()-1);
		return str;
	}

	public int removeAllFunctionPoints(String functionName){
		int rem=0;
		Node[] arr=toArray();
		for (int i=0;i<arr.length;i++)
		{
			//System.out.println(i+" "+arr[i].getVariables()[0]+":"+arr[i].getVariables()[1]);
			if (arr[i]!=null) {
				if (arr[i].prevVal != null && arr[i].nextVal == null) {
					Node curr = arr[i].prevVal;
					while (curr != null) {
						//System.out.println("??????????"+curr.getFunction().functionName);
						if (curr.getFunction().functionName == functionName) {
							rem++;
							//removePoint(arr[i].getVariables()[0], arr[i].getVariables()[1]);
							if (curr.prevVal==null)
							{
								curr.nextVal.prevVal=null;
								//curr.nextVal=null;
							}
							else
							{
								curr.prevVal.nextVal=curr.nextVal;
								curr.nextVal.prevVal=curr.prevVal;
							}
						}
						curr = curr.prevVal;
					}
				}
				if (arr[i].getFunction().functionName == functionName && arr[i].nextVal==null) {
					rem++;
					removePoint(arr[i].getVariables()[0], arr[i].getVariables()[1]);
				}
			}
		}
		return rem;
	}

	public int countNumberOfPoints(){
		int[] n=numPointsPerQuadrant();
		return n[0]+n[1]+n[2]+n[3];
	}

	public int[] numPointsPerQuadrant(){
		Node curr=origin;
		int[] n=new int[4];
		n[0]=0;
		n[1]=0;
		n[2]=0;
		n[3]=0;
		if (origin==null) return n;
		if (origin.left==null && origin.right==null) return n;
		//Q0 top right
		curr=origin.right;
		while (curr!=null)
		{
			Node x=curr;
			while (curr.up!=null)
			{
				n[0]++;
				curr=curr.up;
				Node temp=curr;
				while (temp.prevVal!=null)
				{
					n[0]++;
					temp=temp.prevVal;
				}
			}
			curr=x.right;
		}

		//Q1 top left
		curr=origin.left;
		while (curr!=null)
		{
			Node x=curr;
			while (curr.up!=null)
			{
				n[1]++;
				curr=curr.up;
				Node temp=curr;
				while (temp.prevVal!=null)
				{
					n[1]++;
					temp=temp.prevVal;
				}
			}
			curr=x.left;
		}

		//Q2 bottom left
		curr=origin.left;
		while (curr!=null)
		{
			Node x=curr;
			while (curr.down!=null)
			{
				n[2]++;
				curr=curr.down;
				Node temp=curr;
				while (temp.prevVal!=null)
				{
					n[2]++;
					temp=temp.prevVal;
				}
			}
			curr=x.left;
		}

		//Q3 bottom right
		curr=origin.right;
		while (curr!=null)
		{
			Node x=curr;
			while (curr.down!=null)
			{
				n[3]++;
				curr=curr.down;
				Node temp=curr;
				while (temp.prevVal!=null)
				{
					n[3]++;
					temp=temp.prevVal;
				}
			}
			curr=x.right;
		}
		return n;
	}

	public void clearAllData(){
		origin.left=null;
		origin.right=null;
		origin.up=null;
		origin.down=null;
		origin.prevVal=null;
		origin.nextVal=null;
	}

	//ADD HELPER FUNCTIONS BELOW
	public void moveback(Node curr,Node n)
	{
		Node x=curr;
		int comp=x.getFunction().functionName.compareTo(n.getFunction().functionName);
		while (comp<0)
		{
			if (x.prevVal==null) break;
			x=x.prevVal;
			comp=x.getFunction().functionName.compareTo(n.getFunction().functionName);
		}
		if (curr.prevVal==null && comp<0)
		{
			x.prevVal=n;
			n.nextVal=x;
		}
		else if (x==curr)
		{
			//System.out.println("---["+n.getVariables()[0]+"]["+n.getVariables()[1]+"]");
			n.left=x.left; 	x.left=null;
			n.right=x.right;x.right=null;
			n.up=x.up; 		x.up=null;
			n.down=x.down; 	x.down=null;
			if (n.left!=null) n.left.right=n;
			if (n.right!=null) n.right.left=n;
			if (n.up!=null) n.up.down=n;
			if (n.down!=null) n.down.up=n;
			n.prevVal=x; 	x.nextVal=n;
		}
		else if (x.prevVal==null)
		{
			x.prevVal=n;
			n.nextVal=x;
		}
		else
		{
			n.nextVal=x.nextVal;
			x=x.nextVal;
			n.prevVal=x.prevVal;
			n.nextVal.prevVal=n;
			n.prevVal.nextVal=n;

		}
	}
}