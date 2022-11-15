public class BSTNode<T extends Comparable<T>> {
    private T value;
    public BSTNode<T> right;
    public BSTNode<T> left;

    public boolean recInsert(T val){
        if(val.compareTo(value) == 0)
            return false;

        if(val.compareTo(value) < 0)
        {
            if(left == null)
            {
                left = new BSTNode<>(val);
                return true;
            } else {
                return left.recInsert(val);
            }
        } else {
            if(right == null)
            {
                right = new BSTNode<>(val);
                return true;
            } else {
                return right.recInsert(val);
            }
        }
    }

    //Implement the following

    public BSTNode(T val){
        value=val;
    }

    public T getVal(){
        return value;
    }

    public String toString(){
        String output = "";
        if (right==null && left==null)
        {
            output="L["+"]V["+value+"]R["+"]";
        }
        else if (right==null)
        {
            output="L["+left.value+"]V["+value+"]R["+"]";
        }
        else if (left==null)
        {
            output="L["+"]V["+value+"]R["+right.value+"]";
        }
        else
        {
            output="L["+left.value+"]V["+value+"]R["+right.value+"]";
        }
        return output;
    }

    //ADD HELPER FUNCTIONS HERE
}
