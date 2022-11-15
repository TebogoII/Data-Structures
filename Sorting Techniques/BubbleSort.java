public class BubbleSort extends Sorting {
    public BubbleSort(){
        name="BubbleSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String[] arr=new String[array.length];
        for (int i=0; i<array.length; i++)
        {
            arr[i]=array[i].getVName();
        }
        for (int i=0; i<arr.length-1; i++)
        {
            for (int j=arr.length-1; j>i; j--)
            {
                int r1=arr[j-1].compareTo(arr[j]);
                //System.out.println("--->"+arr[j-1]);
                if (r1>0)
                {
                    String v=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=v;
                }
            }
            //Print
            for (int j=0; j<arr.length; j++)
            {
                System.out.print(arr[j]);
                if (j != arr.length-1)
                {
                    System.out.print(";");
                }
                else
                {
                    System.out.print("\n");
                }
            }
        }
        return arr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) {
        String[] arr=new String[array.length];
        for (int i=0; i<array.length; i++)
        {
            arr[i]=array[i].getVName();
        }
        for (int i=0; i<arr.length-1; i++)
        {
            for (int j=arr.length-1; j>i; j--)
            {
                int r1=arr[j-1].compareTo(arr[j]);
                //System.out.println("--->"+arr[j-1]);
                if (r1<0)
                {
                    String v=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=v;
                }
            }
            //Print
            for (int j=0; j<arr.length; j++)
            {
                System.out.print(arr[j]);
                if (j != arr.length-1)
                {
                    System.out.print(";");
                }
                else
                {
                    System.out.print("\n");
                }
            }
        }
        return arr;
    }
}
