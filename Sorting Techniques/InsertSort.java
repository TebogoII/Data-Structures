public class InsertSort extends Sorting {

    public InsertSort(){
        name="InsertSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String[] arr=new String[array.length];
        for (int i=0; i<array.length; i++)
        {
            arr[i]=array[i].getVName();
        }
        for (int i=1; i<array.length; i++)
        {
            String tmp=arr[i];
            int j=i-1;
            int str=arr[j].compareTo(tmp);
            while (j>=0 && str>0)
            {
                arr[j+1]=arr[j];
                j--;
                if (j!=-1)
                str=arr[j].compareTo(tmp);
            }
            arr[j+1]=tmp;
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
        for (int i=1; i<array.length; i++)
        {
            String tmp=arr[i];
            int j=i-1;
            int str=arr[j].compareTo(tmp);
            while (j>=0 && str<0)
            {
                arr[j+1]=arr[j];
                j--;
                if (j!=-1)
                    str=arr[j].compareTo(tmp);
            }
            arr[j+1]=tmp;
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
