public class SelectionSort extends Sorting {
    
    public SelectionSort(){
        name="SelectionSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String[] arr=new String[array.length];
        for (int i=0; i<array.length; i++)
        {
            arr[i]=array[i].getVName();
        }
        for (int i=0; i<arr.length; i++)
        {
            String small=arr[arr.length-1];

            int xPos=-1;
            for (int x=i; x<arr.length; x++)
            {
                //if (i==2)
                //System.out.println("--->"+small);
                int s=small.compareTo(arr[x]);
                if (s>=0)
                {
                    xPos=x;
                    small=arr[x];
                }
            }
            //System.out.println("--->"+small+"--->"+arr[i]);
            String temp=arr[i];
            arr[i]=small;
            arr[xPos]=temp;
            //Print
            for (int x=0; x<arr.length; x++)
            {
                System.out.print(arr[x]);
                if (x != arr.length-1)
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
        for (int i=0; i<arr.length; i++)
        {
            String small=arr[arr.length-1];
            String max=arr[arr.length-1];
            int xPos=-1;
            for (int x=i; x<arr.length; x++)
            {
                //if (i==2)
                //System.out.println("--->"+small);
                int s=small.compareTo(arr[x]);
                int m=max.compareTo(arr[x]);
                if (m<=0)
                {
                    xPos=x;
                    max=arr[x];
                }
            }
            String temp=arr[i];
            arr[i]=arr[xPos];
            arr[xPos]=temp;
            //Print
            for (int x=0; x<arr.length; x++)
            {
                System.out.print(arr[x]);
                if (x != arr.length-1)
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
