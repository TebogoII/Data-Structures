public class AvlTree<T extends Comparable<T>> {
    public Node<T> root;

    public AvlTree() {
        this.root = null;
    }


    int getHeight(Node<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    /*Printing AvlTree in inorder*/
    void print(Node<T> node) {
        if (node == null)
            return;

        print(node.left);

        System.out.print(node.data + " ");

        print(node.right);
    }

    /* Do not edit the code above */

    /**
     * Insert the given data into the tree.
     * Duplicate data is not allowed. just return the node.
     */

    Node<T> insert(Node<T> node, T data) {
        F=true;
        given=node;
        if(root == null){
            root = new Node<>(data);
            updateH(root);
            return root;
        } else {
            x=add(root,data);
            updateH(root);
            if (F)
                return balance(node);
            else
                return x;
        }
    }


    /**
     * Remove / Delete the node based on the given data
     * Return the node / root if the data do not exist
     */
    boolean F=true;
    Node<T> x=null;
    Node<T> removeNode(Node<T> root, T data) {
        root = delete(data, root);
        given=root;
        // Node is null if the tree doesn't contain the key
        if (root == null) {
            return null;
        }

        updateH(root);

        return balance(root);
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

    private int bF(Node<T> curr) {
        int out=height(curr.right) - height(curr.left);
        //out++;
        return out;
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
}
