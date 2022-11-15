import java.util.ArrayList;

public class GraphDB {
    private ArrayList<User> users = new ArrayList<>();

    public User addUser(String userName, int ID){
        int pos=-1;
        boolean known = false;
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).userID==ID)
            {
                pos=i;
                known = true;
                break;
            }
        }
        if (known)
        {
            return users.get(pos);
        }
        else
        {
            User x=new User(userName,ID);
            users.add(x);
            return users.get(users.size()-1);
        }

    }

    public User getUser(int userID){
        boolean known = false;
        //System.out.println(userID+" YERRRRRRRRRRRR ");
        int iPos=-1;
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).userID==userID)
            {
                iPos=i;
                known = true;
                break;
            }
        }
        if (!known)
        {
            return null;
        }
        return users.get(iPos);
    }

    public User getUser(String userName){
        boolean known = false;
        int iPos=-1;
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).userName.equals(userName))
            {
                iPos=i;
                known = true;
                break;
            }
        }
        if (!known)
        {
            return null;
        }
        return users.get(iPos);
    }

    public Relationship addFriendship(int frienteeID, int friendedID, double relationshipValue){
        User x=getUser(frienteeID);
        User y=getUser(friendedID);
        if (x==null||y==null)
        {
            return null;
        }
        return x.addFriend(y,relationshipValue);
    }

    public User[][] clusterUsers(){
        User[][] out;
        ArrayList<User> buffer= new ArrayList<>();
        buffer.addAll(users);
        //ArrayList<User>sorted=sort(buffer);
        //buffer.addAll(sorted);
        //for each vertex allocate Sat=0 and Unc=Deg
        int[] Sat=new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            Sat[i]=0;
        }
        int[] Unc=new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            Unc[i]=Deg(buffer.get(i));
            //System.out.println(buffer.get(i)+" * "+Unc[i]);
        }
        int[] Col=new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            Col[i]=0;
        }
        int[] C=new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            C[i]=i+1;
        }
        //while not all vertices are processed
        for (int i = 0; i < buffer.size(); i++) {
            //find vertex with highest Sat and max Unc
            int maxSat=0;
            for (int j = 0; j < buffer.size(); j++) {
                if (maxSat<Sat[j])
                {
                    if (Col[j]==0)
                    maxSat=Sat[j];
                }
            }
            int maxUnc=-1;
            User v;
            int iPos=-1;
            for (int j = 0; j < buffer.size(); j++) {
                if (Sat[j]==maxSat)
                {
                    if (maxUnc<Unc[j])
                    {
                        //System.out.println(maxSat+"-------->"+buffer.get(j));
                        if (Col[j]==0)
                        {
                            maxUnc = Unc[j];
                            iPos = j;
                        }
                    }
                }
            }
            //System.out.println(iPos+"-------->"+buffer.get(iPos));
            if (iPos!=-1)
            {
                v=buffer.get(iPos);
            }
            else
            {
                continue;
            }
            //find colour j
            int color=1;
            ArrayList<Relationship> friends=v.friends;
            for (int j = 0; j < friends.size(); j++) {
                //System.out.println(friends.get(j).friendB.color+"-------->KHALA YA "+friends.get(j).friendB+" = "+color+"?"+j);
                if (friends.get(j).friendB.color==color)
                {
                    color++;
                    j=-1;
                }
            }
           // System.out.println(color);
            //for each uncolored vertex
            for (int j = 0; j < friends.size(); j++) {
                int x=buffer.indexOf(friends.get(j).friendB);
                if (friends.get(j).friendB.color==0)
                {
                    boolean s=false;
                    ArrayList<Relationship> friends2=friends.get(j).friendB.friends;
                    for (int k = 0; k < friends2.size(); k++) {
                        if (friends2.get(k).friendB.color==color)
                        {
                            s=true;
                        }
                    }
                    if (!s)
                    {
                        Sat[x]++;
                        //System.out.println(friends.get(j).friendB+" "+buffer.get(x)+" "+x);
                    }
                }
                Unc[x]--;
            }
            int y=1;
            //System.out.println(v+" "+y);
            if (v.friends.size()==0)
            {
                v.color=1;
                Col[iPos]=color;
                continue;
            }
            //int x=buffer.indexOf(friends.get(y).friendB);
            v.color=color;
            Col[iPos]=color;
        }
        out=toArr(buffer);
        return out;
    }

    public User[][] toArr(ArrayList<User> buffer)
    {
        int chrome=0;
        for (int i = 0; i < buffer.size(); i++) {
            if (buffer.get(i).color>chrome)
            {
                chrome=buffer.get(i).color;
            }
        }
        User[][] out=new User[chrome][];
        int[] rows=new int[chrome];
        for (int i = 0; i < buffer.size(); i++) {
            rows[buffer.get(i).color-1]++;
        }
        //System.out.println(rows[2]);
        for (int i = 0; i < chrome; i++) {
            out[i]=new User[rows[i]];
        }
        int[] index=new int[chrome];
        for (int i = 0; i < buffer.size(); i++) {
            for (int j = 0; j < chrome; j++) {
                if (buffer.get(i).color-1==j)
                {
                    out[j][index[j]]=buffer.get(i);
                    index[j]++;
                }
            }
        }
        for (int i = 0; i < chrome; i++) {
            sortArr(out[i]);
        }
        return out;
    }
    
    public User[] sortArr(User[] x)
    {
        ArrayList<User> out = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            out.add(x[i]);
        }
        out=sort(out);
        for (int i = 0; i < out.size(); i++) {
            x[i]=out.get(i);
        }
        return x;
    }

    public int max(int[] x)
    {
        int max=x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i]>max)
            {
                max=x[i];
            }
        }
        return max;
    }
    public int Deg(User x)
    {
        return x.friends.size();
    }
    
    public ArrayList<User> sort(ArrayList<User> buffer)
    {
        ArrayList<User> sorted= new ArrayList<>();
        int iPos=-1;
        int x=buffer.size();
        for (int j = 0; j < x; j++) {
            User min=buffer.get(0);
            iPos=0;
            for (int i = 0; i < buffer.size(); i++) {
                if (min.userID>buffer.get(i).userID)
                {
                    min=buffer.get(i);
                    iPos=i;
                }
            }
            //System.out.println("--->"+min.userName);
            sorted.add(min);
            buffer.remove(iPos);

        }
        //System.out.println("SIZE--->"+sorted.size());

        return sorted;
    }

    public ArrayList<Relationship> sortR(ArrayList<Relationship> buffer)
    {
        ArrayList<Relationship> sorted= new ArrayList<>();
        int iPos=-1;
        int x=buffer.size();
        for (int j = 0; j < x; j++) {
            Relationship min=buffer.get(0);
            iPos=0;
            for (int i = 0; i < buffer.size(); i++) {
                if (min.friendshipValue>buffer.get(i).friendshipValue)
                {
                    min=buffer.get(i);
                    iPos=i;
                }
            }
            //System.out.println("--->"+min.friendshipValue);
            sorted.add(min);
            buffer.remove(iPos);

        }
        //System.out.println("SIZE--->"+sorted.size());

        return sorted;
    }

    public Relationship[] minSpanningTree(){
        ArrayList<Relationship> edges = allEdges();
        ArrayList<User> vertX = new ArrayList<>();
        ArrayList<Relationship> tree = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            tree.add(edges.get(i));
            ArrayList<User> vert = vertX;
            vertX=vertex(edges.get(i).friendA,vertX);
            vertX=vertex(edges.get(i).friendB,vertX);
            //System.out.println();
            //System.out.println(edges.get(i).friendA+"<--->"+edges.get(i).friendB);
            if (!hasCycle(null,edges.get(i).friendA,tree,vertX))
            {
                //System.out.println("Accepted "+edges.get(i));
            }
            else{
                vertX=vert;
                tree.remove(tree.size()-1);
            }
        }
        Relationship[] output=new Relationship[tree.size()];
        for (int i = 0; i < tree.size(); i++) {
            output[i]=tree.get(i);
        }
        return output;
    }

    public ArrayList<User> vertex(User x, ArrayList<User> v)
    {
        boolean found=false;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i)==x)
            {
                found=true;
            }
        }
        if (!found)
        {
            v.add(x);
        }
        return v;
    }

    public boolean allVisited()
    {
        boolean allv=true;
        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).visited)
            {
                allv=false;
            }
        }
        return allv;
    }

    public boolean detectCycle(User p,User u,ArrayList<Relationship> tree,boolean[] visits,ArrayList<User> vertex){
        u.visited=true;
        visits[vertex.indexOf(u)]=true;
        //System.out.println(u.userName+"         <--******-->");
        for (int i = 0; i < u.friends.size(); i++) {
            //System.out.println(u+" : "+u.friends.get(i)+"+++++");
            boolean flag[]=contains(u.friends.get(i),tree);
            if (flag[0])
            {
                if (u==p&&visits[vertex.indexOf(u.friends.get(i).friendB)])
                {
                    p=u.friends.get(i).friendB;
                    if (flag[1])
                    {
                        p=u.friends.get(i).friendA;
                    }
                }
                //System.out.println(u+" : "+u.friends.get(i)+"-----"+p);
                if (!visits[vertex.indexOf(u.friends.get(i).friendB)]) {
                    //System.out.println(u.friends.get(i).friendB+"::::::--0000000000000000");
                    p = u;
                    //if (u.friends.get(i).friendB!=u)
                    if (detectCycle(p,u.friends.get(i).friendB,tree,visits,vertex))
                    {
                        return true;
                    }
                }
                else if(u.friends.get(i).friendB!=p){
                    //System.out.println(u+" : "+u.friends.get(i)+"-----"+p);
                    //System.out.println("Rejected "+tree.get(tree.size()-1));
                    return true;
                }
            }
        }
        return false;

       /* for (int i = 0; i < users.size(); i++) {
            users.get(i).visited=false;
        }
        */
    }

    public boolean hasCycle(User p,User u,ArrayList<Relationship> tree,ArrayList<User> vertex)
    {
        boolean[] visits=new boolean[vertex.size()];
        for (int j = 0; j < vertex.size(); j++) {
            visits[j] = false;
        }
        /*for (int j = 0; j < vertex.size(); j++) {
            vertex.get(j).visited = false;
        }*/
        for (int i = 0; i < vertex.size(); i++) {
            //System.out.println(vertex.get(i)+"<---");
            //System.out.println(tree.get(tree.size()-1)+"<---");
            if (!visits[i])
            {
                if (detectCycle(p,vertex.get(i),tree,visits,vertex))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[] contains(Relationship x,ArrayList<Relationship> tree){
        boolean[] con=new boolean[2];
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i)==x)
            {
                con[0]=true;
            }
            else if (tree.get(i).friendB==x.friendA&&tree.get(i).friendA==x.friendB)
            {
                //System.out.println("it happaned");
                con[0]=true;
                con[1]=true;
            }
        }
        return con;
    }
    public ArrayList<Relationship> allEdges()
    {
        ArrayList<User> buffer=new ArrayList<>();
        buffer.addAll(users);
        buffer=sort(buffer);


        //
        ArrayList<Relationship> edges=new ArrayList<>();
        int j=0;
        for (int i = 0; i < buffer.size(); i++) {
            //System.out.println("ALL EDGES--->"+buffer.get(i).friends.size());
            for (int k = 0; k < buffer.get(i).friends.size(); k++) {
                boolean foundOpp=false;
                for (int l = 0; l < edges.size(); l++) {
                    if (buffer.get(i).friends.get(k).friendA==edges.get(l).friendB && buffer.get(i).friends.get(k).friendB==edges.get(l).friendA)
                    {
                        foundOpp=true;
                    }
                }
                if(!foundOpp)
                {
                    edges.add(buffer.get(i).friends.get(k));
                    //System.out.println("edge: FA["+edges.get(j).friendA.userID+"] FB["+edges.get(j).friendB.userID+"]");
                    j++;
                }
            }
        }
        return sortR(edges);
    }

    ArrayList<User> atDist=new ArrayList<>();
    ArrayList<User> prev=new ArrayList<>();
    User og;

    public User[] getUsersAtDistance(User fromUser, int distance){
        og=fromUser;
        atDist=new ArrayList<>();
        render(fromUser,distance);
        //System.out.println(" * "+prev.get(3));
        ArrayList<User> out=getUsers(fromUser,distance);
        return out.toArray(new User[0]);
    }

    public ArrayList<User> getUsers(User fromUser, int distance){
        if (distance==0)
        {
            return vertex(fromUser, atDist);
        }
        else
        for (int i = 0; i < fromUser.friends.size(); i++) {
            //if (contains(fromUser.friends.get(i),mst)[0])
            if (1==distance)
            {
                User in=fromUser.friends.get(i).friendB;
                if (in!=og) {
                    if (!prev.contains(in))
                    atDist = vertex(in, atDist);
                }
            }
            else
            {
                //System.out.println(fromUser.friends.get(i).friendB+" * "+distance);
                getUsers(fromUser.friends.get(i).friendB, distance - 1);
            }
        }
        return atDist;
    }



    public void render(User fromUser, int distance){
        prev=new ArrayList<>();
        for (int i = 0; i < distance; i++) {
            atDist2=new ArrayList<>();
            prev.addAll(getUsers2(fromUser,i));
        }
    }

    ArrayList<User> atDist2=new ArrayList<>();
    public ArrayList<User> getUsers2(User fromUser, int distance){
        //System.out.println(fromUser+" *** "+distance);
        if (distance==0)
        {
            return vertex(fromUser, atDist2);
        }
        else
            for (int i = 0; i < fromUser.friends.size(); i++) {
                //if (contains(fromUser.friends.get(i),mst)[0])
                if (1==distance)
                {
                    User in=fromUser.friends.get(i).friendB;
                    if (in!=og) {
                        if (!prev.contains(in))
                            atDist2 = vertex(in, atDist2);
                    }
                }
                else
                {
                    //System.out.println(fromUser.friends.get(i).friendB+" * "+distance);
                    getUsers2(fromUser.friends.get(i).friendB, distance - 1);
                }
            }
        return atDist2;
    }

}
