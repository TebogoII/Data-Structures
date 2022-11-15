/**
 * Name:
 * Student Number:
 */



public class OrganisingList {

    public ListNode root = null;

    public OrganisingList() {

    }
    
    /**
     * Calculate the sum of keys recursively, starting with the given node until the end of the list
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {
        if (node.next==null)
        {
            return node.key;
        }
        else
        {
            return sumRec(node.next)+node.key;
        }
    }

    /**
     * Calculate and set the data for the given node.
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {
        //System.out.println("---->"+node.key);
        if (node.next==null)
        {
            node.data= node.key;
            return node.data;
        }
        else
        {
            node.data=(node.key * sumRec(node)) - dataRec(node.next);
            return node.data;
        }
    }

    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     * DO NOT MODIFY!
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    /**
     * Retrieve the data for the node with the specified key and swap the
     * accessed node with its predecessor, then recalculate data fields.
     * @return The data of the node before it has been moved,
     * otherwise 'null' if the key does not exist.
     */
    public Integer getData(Integer key) {
        if (! contains(key))
        {
            return null;
        }
        if (root.key==key)
        {
            return root.data;
        }
        //Variables
        ListNode curr, prev, prev2;
        curr=root.next;
        prev=root;
        prev2=null;
        while(curr!=null)
        {
            if (curr.key==key)
            {
                int data=curr.data;
                if (prev2==null)
                {
                    prev.next=curr.next;
                    curr.next=prev;
                    root=curr;
                    calculateData();
                    return data;
                }
                else
                {
                    prev2.next=curr;
                    prev.next=curr.next;
                    curr.next=prev;
                    calculateData();
                    return data;
                }
            }
            prev2=prev;
            prev=curr;
            curr=curr.next;
        }
        return null;
    }

    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {
        ListNode curr =root;
        ListNode prev =null;
        if (curr==null)
            return;
        if (key==root.key)
        {
            root=root.next;
            return;
        }
        while (curr!=null)
        {
            if (curr.key==key)
            {
                if (prev==null)
                {
                    root=null;
                }
                else
                {
                    prev.next=curr.next;
                }
                calculateData();
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }


    /**
     * Insert a new key into the linked list.
     * 
     * New nodes should be inserted to the back
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {
        ListNode add = new ListNode(key);
        if (root==null)
        {
            root=add;
            calculateData();
        }
        else
        {
            //System.out.println("---->"+key);
            ListNode curr =root;
            while (curr.next!=null)
            {
                if (curr.key==key)
                {
                    return;
                }
                curr=curr.next;
            }
            if (curr.key==key)
            {
                return;
            }
            curr.next=add;
            calculateData();
        }
    }

    /**
     * Check if a key is contained in the list
     * @return true if the key is in the list, otherwise false
     */
    public Boolean contains(Integer key) {
        ListNode curr =root;
        if (curr==null)
            return false;
        while (curr!=null)
        {
            if (curr.key==key)
            {
                return true;
            }
            curr=curr.next;
        }
        return false;
    }


    /**
     * Return a string representation of the Linked List.
     * DO NOT MODIFY!
     */
    public String toString() {
        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result.concat("[K: " + node.key + ", D: " + node.data + "]");

            if (node.next != null) {
                result = result.concat(" ");
            }
        }

        return result;
    }

    /**
     * Return a string representation of the linked list, showing only the keys of nodes.
     * DO NOT MODIFY!
     */
    public String toStringKeysOnly() {

        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result + node.key;

            if (node.next != null) {
                result = result.concat(", ");
            }
        }

        return result;
    }

    
}