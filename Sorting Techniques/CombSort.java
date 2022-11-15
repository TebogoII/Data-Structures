public class CombSort extends Sorting {
    public CombSort(){
        name="CombSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String[] arr=new String[array.length];
        for (int i=0; i<array.length; i++)
        {
            arr[i]=array[i].getVName();
        }
        int gap=array.length;
        boolean swapped=false;
        while (gap>1 || swapped)
        {
            swapped=false;
            if (gap>1)
            {
                double g=gap/1.3;
                gap= (int) Math.floor(g);
            }
            int i=0;
            while (i+gap<arr.length)
            {
                int x=arr[i].compareTo(arr[i+gap]);
                if (x>0)
                {
                    String temp=arr[i];
                    arr[i]=arr[i+gap];
                    arr[i+gap]=temp;
                    swapped=true;
                }
                i+=1;
            }
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
            System.out.print("Gap: "+gap+"\n");
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
        int gap=array.length;
        boolean swapped=false;
        while (gap>1 || swapped)
        {
            swapped=false;
            if (gap>1)
            {
                double g=gap/1.3;
                gap= (int) Math.floor(g);
            }
            int i=0;
            while (i+gap<arr.length)
            {
                int x=arr[i].compareTo(arr[i+gap]);
                if (x<0)
                {
                    String temp=arr[i];
                    arr[i]=arr[i+gap];
                    arr[i+gap]=temp;
                    swapped=true;
                }
                i+=1;
            }
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
            System.out.print("Gap: "+gap+"\n");
        }
        return arr;
    }
}
