
package ctrlf;

import java.util.ArrayList;

/**
 *
 * @author Jenny
 */
public class hash {
    private static Node data [] = new Node [11];
    
    public static Node insert(int key, String Name, int index){
        int loc = 0;
        loc = (key) % data.length;
        if (data[loc] == null){
            Node curr = new Node(Name,null, null, index);
            data[loc] = curr;
            curr.setval(loc);
            return curr;
        }
        else if (data[loc].getString().compareTo(Name) == 0){
            Node prv = data[loc];
            while (prv.getnext() != null){
                prv = prv.getnext();
            }
            //System.out.println(prv.getnext());
            Node curr = new Node(Name,null, prv, index);
            prv.setnext(curr);
            //System.out.println(prv);
            curr.setval(loc);
            return curr;
        }
        
        for (int x = 0; x< data.length; x++){
        loc = (int) ((x*(7 - (key%7))) + (key % data.length)); 
        if (loc >= data.length){
             int locc = (loc % data.length);
             loc = locc;
        }
        if (data[loc] == null){
            Node curr = new Node(Name,null, null, index);
            data[loc] = curr;
            curr.setval(loc);
            return curr;
        }
        else if (data[loc].getString().compareTo(Name) == 0){
            Node prv = data[loc];
            while (prv.getnext() != null){
                prv = prv.getnext();
            }
            //System.out.println(prv.getnext());
            Node curr = new Node(Name,null, prv, index);
            prv.setnext(curr);
            //System.out.println(prv);
            curr.setval(loc);
            return curr;
        }
        }
       return data[loc]; 
    }
    
    public static ArrayList find(String Name, int key){
        ArrayList <NewString> Found = new ArrayList <NewString>();
        int loc = (key) % data.length;
        //System.out.println("loc:  " + loc);
        Node next = null;
        if (data[loc]==null){
            Found.add(new NewString(null,0));
            return Found;
        }
        if (data[loc].getString().compareTo(Name) == 0){
            System.out.println("in");
            Found.add(new NewString(data[loc].getString(),data[loc].getIndex()));
            if(data[loc].getnext()==null){
                return Found;
            }
            next = data[loc].getnext();
        }
        else {
            
            for (int x = 0; x< data.length; x++){   
            loc = (int) ((x*(7 - (key%7))) + (key % data.length)); 
                if (loc >= data.length){
                int locc = (loc % data.length);
                loc = locc;
                }
                    if (data[loc].getString().compareTo(Name) == 0){
                    Found.add(new NewString(data[loc].getString(), data[loc].getIndex()));
                    if(data[loc].getnext()==null){
                    return Found;
                    }
                    next = data[loc].getnext();
                    System.out.println("thisisus" + next.getString());
                    break;
                }
            }
        }
        
        //System.out.println("loc:  " + loc);
        
        if (next == null){
            Found.add(new NewString(null,0));
            return Found;
        }

        while (next!= null){
            System.out.println("adding");
            Found.add(new NewString(next.getString(), next.getIndex()));
            next = next.getnext();
        }
        System.out.println(Found.toString());
        return Found;
    }
    
    public static void printtable(){
        for (int x = 0; x< data.length;x++){
            if (data[x] ==null){
                System.out.println(x + ": " + data[x]);
            }
            else{
                System.out.println(x + ": " + data[x].getString());
            }
            while(data[x] != null && data[x].getnext()!= null){
            System.out.println(data[x].getnext().getString());
            data[x]=data[x].getnext();
        }

    }
    }


}

