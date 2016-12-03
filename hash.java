/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrlf;

/**
 *
 * @author Jenny
 */
public class hash {
    private static Node data [] = new Node [11];
    
    public static Node insert(int key, String Name){
        int loc = 0;
        loc = (key) % data.length;
        if (data[loc] == null){
            Node curr = new Node(Name,null, null);
            data[loc] = curr;
            curr.setval(loc);
            return curr;
        }
        else if (data[loc].compareTo(Name) == 0){
            Node prv = data[loc];
            while (prv.getnext() != null){
                prv = data[loc];
            }
            Node curr = new Node(Name,null, prv);
            prv.setnext(curr);
            curr.setval(loc);
            return curr;
        }
        
        for (int x = 0; x< data.length; x++){
        loc = (int) ((x*(7 - (key%7)) + (key % data.length))); 
        if (loc >= data.length){
             int locc = (loc % data.length);
             loc = locc;
        if (data[loc] == null){
            Node curr = new Node(Name,null, data[loc]);
            data[loc] = curr;
            curr.setval(loc);
            return curr;
        }
        }
        }
       return data[loc]; 
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
            System.out.print(data[x].getnext().getString());
        }
    }
    }
    
    public static void main(String[] args) {
        hash.insert(1,"Jenny");
        System.out.println(data[1]);
        System.out.println(data[1].compareTo("Jenny"));
        hash.insert(1, "Jenny");
        hash.insert(2, "Jennifer");
        hash.printtable();
    }

}
