public class TopologicalSort extends Sorting {
    public TopologicalSort(){
        name="TopologicalSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) throws CycleException {
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
        }
        return arr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) throws CycleException{
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
        }
        return arr;
    }

}

class CycleException extends Exception{
    public String message = "Cycle has been detected";
}
