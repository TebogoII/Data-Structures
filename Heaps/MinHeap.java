

@SuppressWarnings("unchecked")
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(int capacity) {
	super(capacity);
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////

    @Override
    public void insert(T elem) {
        //System.out.println(mH[currentSize]);
        mH[currentSize+1]=elem;
        currentSize++;
        if (currentSize!=1)
        {
            swap(elem, currentSize);
        }
        else
        {
            mH[1]=elem;
        }
        //Your code goes here
    }

    public T removeMin() {
        if (isEmpty()) return null;
        Comparable<T> temp=mH[1];
        delete((T) mH[1]);
        return (T) temp;
        //Your code goes here
    }

    public void delete(T elem) {
        if (isEmpty()) return;
        int i=0;
        boolean found=false;
        while (mH[i]!=elem && i<currentSize)
        {
            if (mH[i+1]==elem)
            {
                found=true;
            }
            i++;
        }
        if (found)
        {
            mH[i] = mH[currentSize];
            mH[currentSize] = null;
            currentSize--;
            swapUp(i);
        }
	//Your code goes here
    }

    //Helper functions
    public void swapUp(int i)
    {
        Comparable<T> l=null;
        Comparable<T> r=null;
        double x=-1738;
        double y=-1738;
        if (2*i<=currentSize)
        {
            if (mH[2*i]!=null) {
                x = mH[i].compareTo((T) mH[2 * i]);
                if (x>0)
                {
                    l=mH[2 * i];
                }
            }
        }
        if (2*i+1<=currentSize)
        {
            if (mH[2*i+1]!=null) {
                y = mH[i].compareTo((T) mH[2 * i+1]);
                if (y>0)
                {
                    r=mH[2 * i + 1];
                }
            }
        }
        //----------------------------------------------------
        double u;
        if (r==null && l==null) return;
        if (r==null)
        {
            Comparable<T> temp=mH[i];
            mH[i]=mH[2 * i];
            mH[2 * i]=temp;
            swapUp(2*i);
            return;
        }
        if (l==null)
        {
            Comparable<T> temp=mH[i];
            mH[i]=mH[2 * i + 1];
            mH[2 * i + 1]=temp;
            swapUp(2*i+1);
            return;
        }
        u = l.compareTo((T) r);
        if (u < 0)
        {
            if (l==null) return;
            Comparable<T> temp=mH[i];
            mH[i]=mH[2 * i];
            mH[2 * i]=temp;
            swapUp(2*i);
        }
        else
        {
            if (r==null) return;
            Comparable<T> temp=mH[i];
            mH[i]=mH[2 * i + 1];
            mH[2 * i + 1]=temp;
            swapUp(2*i+1);
        }
    }

    public void swap(T el, int k)
    {
        int par=(int) (Math.floor((k)/2));
        //System.out.println(par);
        if (par==0) return;
        double x=mH[par].compareTo(el);
        if (x>0)
        {
            Comparable<T> temp=mH[par];
            mH[par]=el;
            mH[k]=temp;
            swap(el,par);
        }
    }
}