public class BST<T extends Comparable<T>> {
    protected BSTNode<T> root;
    private int count;
    private Object[] obj;
    private boolean out;

    public BST(){};

    public boolean insert(T val){
        if(root == null){
            root = new BSTNode<>(val);
            return true;
        } else {
            return root.recInsert(val);
        }
    }

    //Place code below
    public int numNodes(){
        return countNode(root);
    }

    public Object[] toArray(){
        if (root==null)
            return null;
        obj = new Object[numNodes()];
        count=0;
        return inorder(root);
    }

    public boolean contains(T val){
        if (root==null)
            return false;
        out=false;
        return container(root, val);
    }

    public boolean isEmpty(){
        if (root==null)
        {
            return true;
        }
        else return false;
    }

    public BSTNode<T> find(T val){
        BSTNode<T> p=root;
        while (p != null)
        {
            if (val.equals(p.getVal()))
                return p;
            else if (val.compareTo(p.getVal()) < 0)
                p = p.left;
            else p = p.right;
        }
        return null;
    }

    public int height(){
        if(root == null) {
            //System.out.println("Tree is empty");
            return -1;
        }
        else return findheight(root)-1;
    }

    public Object[] nodesOnHeight(int h){
        if (root==null || h<0)
            return null;
        //Stack<BSTNode<T>> nodes = new Stack<>();
        BSTNode<T> current = root;
        int ans=2;
        if (h==0)
            ans=1;
        for (int i=1;i<(h);i++)
        {
            ans=ans*2;
        }
        BSTNode[] obj = new BSTNode[ans];
        BSTNode[] top = new BSTNode[ans*10];
        int count=0;
        int x=0;
        while (x!=0 || current != null) {

            if (current != null) {
                //nodes.push(current);
                //System.out.println(current.getVal()+"   "+ans);
                top[x]=current;
                x++;
                current = current.left;
            } else {
                //BSTNode<T> node = nodes.pop();
                BSTNode<T> node=top[x-1];
                x--;
                if (getLevelOfNode(root,node.getVal(),0)==h)
                {
                    obj[count]=node;
                    count++;
                }
                current = node.right;
            }

        }
        BSTNode[] obj2 = new BSTNode[count];
        for (int i=0;i<count;i++)
        {
            obj2[i]=obj[i];
        }
        this.count=count;
        return obj2;
    }

    public String DFT(){
        if (root==null)
            return "";
        String out="";
        obj = toArray();
        for (int i=0;i<numNodes();i++)
        {
            out=out+obj[i].toString();
            if (i!=numNodes()-1)
            {
                out=out+";";
            }
        }
        return out;
    }

    public String BFT(){
        if (root==null)
            return "";
        String out="";
        obj = new Object[numNodes()];
        for (int i=0;i<height()+1;i++)
        {
            nodesOnHeight(i);
            for (int j=0;j<count;j++)
            {
                out = out + nodesOnHeight(i)[j].toString();
                //System.out.println(i+""+height()+" "+j+count);
                if(i==height() && j==count-1)
                {
                    //do nothing
                }
                else
                {
                    out=out+";";
                }
            }


        }
        return out;
    }

    public T maxVal(){
        if (root==null)
            return null;
        BSTNode<T> p = root;
        while (p.right!=null)
        {
            p=p.right;
        }
        return p.getVal();
    }

    public T minVal(){
        if (root==null)
            return null;
        BSTNode<T> p = root;
        while (p.left!=null)
        {
            p=p.left;
        }
        return p.getVal();
    }








    //ADD HELPER FUNCTIONS HERE
    public int findheight(BSTNode<T> temp){
        //Check whether tree is empty
        if(root == null) {
            System.out.println("Tree is empty");
            return 0;
        }
        else {
            int leftHeight = 0, rightHeight = 0;

            //Calculate the height of left subtree
            if(temp.left != null)
                leftHeight = findheight(temp.left);

            //Calculate the height of right subtree
            if(temp.right != null)
                rightHeight = findheight(temp.right);

            //Compare height of left subtree and right subtree
            //and store maximum of two in variable max
            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            //Calculate the total height of tree by adding height of root
            return (max+1);
        }
    }

    public boolean container(BSTNode node, T val){
        if (node != null)
        {
            container(node.left,val);
            if (node.getVal()==val)
            {
                out=true;
            }
            container(node.right,val);
        }
        return out;
    }

    public int countNode(BSTNode<T> head){

        //base case
        if(head==null)
            return 0;

        return 1 + countNode(head.left) + countNode(head.right);
    }

    private Object[] inorder(BSTNode<T> node)
    {
        if (node != null)
        {
            inorder(node.left);
            obj[count]=node;
            //System.out.println(obj[count]+"-------"+count);
            count++;
            inorder(node.right);
        }
        return obj;
    }

    public int getLevelOfNode(BSTNode node,T key,int level)
    {
        if(node==null)
            return 0;
        if(node.getVal()==key)
            return level;

        int result=getLevelOfNode(node.left,key,level+1) ;
        if(result!=0)
        {
            // If found in left subtree , return
            return result;
        }
        result= getLevelOfNode(node.right,key,level+1);

        return result;
    }
}
