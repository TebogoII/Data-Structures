import java.util.ArrayList;

public class User {
    String userName;
    int userID;
    ArrayList<Relationship> friends = new ArrayList<>();
    int color=0;
    boolean visited=false;

    @Override
    public String toString() {
        return userName + "[" + userID + "]";
    }
    
    public User(String userName, int userID){
        this.userName=userName;
        this.userID=userID;
    }

    public Relationship[] getFriends(){
        return friends.toArray(new Relationship[0]);
    }

    public Relationship addFriend(User friend, double friendshipValue)
    {
        //System.out.println(friend.userName);
        if (friend==null)
        {
            return null;
        }
        int pos=-1;
        boolean known = false;
        for (int i = 0; i < friends.size(); i++) {
            Relationship x = friends.get(i);
            if (x.friendB == friend) {
                pos=i;
                known = true;
            }
        }
        if (!known)
        {
            friend.friends.add(new Relationship(friend,this, friendshipValue));
            friends.add(new Relationship(this, friend, friendshipValue));
            return friends.get(friends.size()-1);
        }
        else
        {
            return friends.get(pos);
        }
    }

    public void addFriend(Relationship relationship){
        friends.add(relationship);
    }
}
