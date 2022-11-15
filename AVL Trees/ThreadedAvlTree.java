public class ThreadedAvlTree<T extends Comparable<T>> {
    public Node<T> root;

    public ThreadedAvlTree() {
        this.root = null;
    }


    int getHeight(Node<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    static Node getLeftMost(Node node) {
        while (node != null && node.left != null)
            node = node.left;
        return node;
    }

    // Inorder traversal of a threaded avl tree
    void print(Node<T> node) {
        if (node == null)
            return;

        Node<T> cur = getLeftMost(node);

        while (cur != null) {
            System.out.print(" " + cur.data + " ");


            if (cur.rightThread == true)
                cur = cur.right;
            else 
                cur = getLeftMost(cur.right);
        }
    }

    /* Do not edit the code above */

    Node<T>[] que;
    void convertAVLtoThreaded(Node<T> node) {
        root=node;
        x=0;
        int count=count(root);
        que=new Node[count];
        que(root);
        thread(root);
        //for (int i=0;i<count;i++) System.out.print("\nque["+i+"]: "+que[i].data+"\n");
    }

    /**
     * Insert the given data into the tree.
     * Duplicate data is not allowed. just return the node.
     */

    boolean F=true;
    Node<T> xx=null;
    Node<T> insert(Node<T> node, T data) {
        given=node;
        unthread(node);
        F=true;
        if(root == null){
            root = new Node<>(data);
            updateH(root);
            return root;
        } else {
            xx=add(root,data);
            //System.out.println("---->"+xx.data);
            updateH(root);
            if (F) {
                Node<T> bal=balance(node);
                convertAVLtoThreaded(bal);
                return bal;
            }
            else {
                convertAVLtoThreaded(xx);
                return xx;
            }
        }
    }

    private void updateH(Node<T> curr) {
        if (curr==null) return;
        int leftHeight = height(curr.left);
        int rightHeight = height(curr.right);
        int max=rightHeight;
        if ((leftHeight> rightHeight))
        {
            max=leftHeight;
        }
        curr.height = max + 1;
    }

    Node<T> given=null;
    public Node<T> add(Node<T> node,T val){
        if(val.compareTo(node.data) == 0) {
            F=false;
            //System.out.println("---------->"+val);
            return given;
        }
        updateH(node);
        if(val.compareTo(node.data) < 0)
        {
            if(node.left == null)
            {
                node.left = new Node<>(val);
                updateH(node);
                node.left.height=0;
                return root;
            } else {
                Node<T> inode=add(node.left,val);
                updateH(node);
                node.left=balance(node.left);
                return inode;
            }
        } else {
            if(node.right == null)
            {
                node.right = new Node<>(val);
                updateH(node);
                node.right.height=0;
                return root;
            } else {
                Node<T> inode=add(node.right,val);
                updateH(node);
                node.right=balance(node.right);
                return inode;
            }
        }
    }

    private int height(Node<T> curr) {
        if (curr == null)
        {
            return -1;
        }
        else
        {
            return curr.height;
        }
    }

    private Node<T> balance(Node<T> curr) {
        if (curr==null) return null;
        int balanceFactor = bF(curr);
        //R H
        if (balanceFactor > 1) {
            if (bF(curr.right) >= 0) {
                // Rotate left
                curr = leftRotate(curr);
            } else {
                // Rotate right-left
                curr.right = rightRotate(curr.right);
                curr = leftRotate(curr);
            }
        }
        //L H
        if (balanceFactor < -1) {
            if (bF(curr.left) <= 0) {
                // Rotate right
                curr = rightRotate(curr);
            } else {
                // Rotate left-right
                curr.left = leftRotate(curr.left);
                curr = rightRotate(curr);
            }
        }
        return curr;
    }

    private Node<T> rightRotate(Node<T> curr) {
        Node<T> left = curr.left;
        curr.left = left.right;
        left.right = curr;
        updateH(curr);
        updateH(left);
        return left;
    }

    private Node<T> leftRotate(Node<T> curr) {
        Node<T> right = curr.right;
        curr.right = right.left;
        right.left = curr;
        updateH(curr);
        updateH(right);
        return right;
    }

    private int bF(Node<T> curr) {
        int out=height(curr.right) - height(curr.left);
        //out++;
        return out;
    }

    /**
     * Delete the given element \texttt{data} from the tree.  Re-balance the tree after deletion.
     * If the data is not in the tree, return the given node / root.
     */
    Node<T> removeNode(Node<T> node, T data) {
        unthread(node);
        given=node;
        root = delete(data, node);


        // Node is null if the tree doesn't contain the key
        if (node == null) {
            return null;
        }

        updateH(node);
        Node<T> bal=balance(node);
        convertAVLtoThreaded(bal);
        return bal;
    }
    //Helper Functions
    void que(Node<T> node)
    {
        if (node == null)
            return;

        que(node.left);
        int i=0;
        while (que[i]!=null)
            i++;
        que[i]=node;
        if (!node.rightThread)
        que(node.right);
    }

    int x;
    int count(Node<T> node) {
        if (node == null)
        {
            return 0;
        }
        count(node.left);
        x++;
        if (!node.rightThread)
        count(node.right);
        return x;
    }

    Node<T> thread(Node<T> node)
    {
        if (node == null)
        {
            return null;
        }

        thread(node.left);
        if (node.right==null)
        {
            int i=0;
            //System.out.println("------>"+node.data);
            while (que[i]!=node)
            {
                i++;
            }
            i++;
            if (i<x)
            {
                node.rightThread=true;
                node.right=que[i];
            }
            else {
                node.rightThread=false;
            }
        }
        else {
            node.rightThread=false;
        }
        if (!node.rightThread)
        thread(node.right);
        return root;
    }

    Node<T> unthread(Node<T> node)
    {
        if (node == null)
        {
            return null;
        }
        unthread(node.left);
        if (node.rightThread)
        {
            node.right=null;
            node.rightThread=false;
        }
        unthread(node.right);
        return root;
    }

    Node<T> delete(T data, Node<T> curr) {
        Node<T> rc=curr;
        // No node curr pos --> go up the recursion

        if (curr == null) {
            return null;
        }
        //System.out.println("contains? "+Contains(root,data));
        if (!Contains(root,data)) return given;
        updateH(curr);
        // find node to delete
        float x = data.compareTo(curr.data);
        if (x < 0) {
            curr.left = delete(data, curr.left);
            updateH(curr);
            curr.left=balance(curr.left);
        } else if (x > 0) {
            curr.right = delete(data, curr.right);
            updateH(curr);
            curr.right=balance(curr.right);
        }
        //0 kids
        else if (curr.left == null && curr.right == null) {
            if (rc==root)
                if (root==curr) root=null;
            //System.out.println("---------->"+curr.data);
            curr = null;
        }
        //1 kid
        else if (curr.left == null) {
            if (root==curr)
            {
                root=curr.right;
                curr=root;
                updateH(curr);
            }
            else
            {
                curr = curr.right;
                updateH(curr);
            }
        } else if (curr.right == null) {
            if (root==curr)
            {
                root=curr.left;
                curr=root;
                updateH(curr);
            }
            else
            {
                curr = curr.left;
                //System.out.println("---->" + curr.data);
                updateH(curr);
            }
        }
        //2 kids
        else {
            delete2(curr);
            updateH(curr);
            //System.out.println("---->" + curr.left.data);
            curr.left=balance(curr.left);
        }

        return curr;
    }
    //2 kids
    private void delete2(Node<T> curr) {
        Node<T> next = Max(curr.left);
        curr.data = next.data;
        curr.left = delete(next.data, curr.left);
        updateH(curr.left);
    }

    private Node<T> Max(Node<T> curr) {
        while (curr.right != null) {
            curr = curr.right;
        }
        //System.out.println(node.data)
        return curr;
    }
    public boolean Contains(Node<T> curr, T data)
    {
        if (curr==null) return false;
        float x=curr.data.compareTo(data);
        if (x == 0)
        {
            return true;
        }
        if (x > 0)
        {
            return Contains(curr.left, data);
        }
        return Contains(curr.right, data);
    }
}
