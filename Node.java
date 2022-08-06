import java.text.DecimalFormat;

public class Node {

	private int v1; // this is the first variable
	private int v2; // this is the second variable
	public Node left; // this is the node left of this node
	public Node right; // this is the node right of this node
	public Node up; // this is the node up of this node
	public Node down; // this is the node down of this node
	public Node nextVal; // this is the next value of the current node
	public Node prevVal; // this is the prev value of the current node
	private Function nodeFunction; // this is the function associated with the current node

	private String floatFormatter(float value){
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(value);
	}
	
	//DO NOT CHANGE THE ABOVE FUNCTION
	//Place your code below

	public Node(Function function, int v1, int v2) {
		if (function==null) return;
		nodeFunction= function;
		nodeFunction.functionName=function.getFunctionName();
		this.v1=v1;
		this.v2=v2;
	}

	public Function setFunction(Function function) {
		Function func=nodeFunction;
		nodeFunction=function;
		return func;
	}

	public float getValue() {
		if (nodeFunction==null)
		{
			return Float.NEGATIVE_INFINITY;
		}
		else
		{
			return nodeFunction.calculate(v1,v2);
		}
	}

	public int[] getVariables() {
		int[] ans=new int[2];
		ans[0]=v1;
		ans[1]=v2;
		return ans;
	}

	public Function getFunction(){
		return nodeFunction;
	}

	public String[] getNodeLinks(){
		String[] str=new String[6];
		if (up==null)
			str[0]="U[][]{}";
		else
			str[0]="U["+Integer.toString(up.v1)+"]["+Integer.toString(up.v2)+"]{"+floatFormatter(up.getValue())+"}";

		if (down==null)
			str[1]="D[][]{}";
		else
			str[1]="D["+Integer.toString(down.v1)+"]["+Integer.toString(down.v2)+"]{"+floatFormatter(down.getValue())+"}";

		if (right==null)
			str[2]="R[][]{}";
		else
			str[2]="R["+Integer.toString(right.v1)+"]["+Integer.toString(right.v2)+"]{"+floatFormatter(right.getValue())+"}";

		if (left==null)
			str[3]="L[][]{}";
		else
			str[3]="L["+Integer.toString(left.v1)+"]["+Integer.toString(left.v2)+"]{"+floatFormatter(left.getValue())+"}";

		if (prevVal==null)
			str[4]="P[][]{}";
		else
			str[4]="P["+Integer.toString(prevVal.v1)+"]["+Integer.toString(prevVal.v2)+"]{"+floatFormatter(prevVal.getValue())+"}";

		if (nextVal==null)
			str[5]="N[][]{}";
		else
			str[5]="N["+Integer.toString(nextVal.v1)+"]["+Integer.toString(nextVal.v2)+"]{"+floatFormatter(nextVal.getValue())+"}";

		return str;
	}

}