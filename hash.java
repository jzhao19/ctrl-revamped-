/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project.netbeans;

/**
 *
 * @author Jenny
 */
public class hash  {
    private static Node data [] = new Node [199];
    
    public static Node insert(int key, String Name){
        int loc = 0;
        loc = (key) % data.length;
        if (data[loc] == null){
            Node curr = new Node(Name,null, null);
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
            Node curr = new Node(Name,null, prv);
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
            Node curr = new Node(Name,null, null);
            data[loc] = curr;
            curr.setval(loc);
            return curr;
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
            System.out.println(data[x].getnext().getString());
            data[x]=data[x].getnext();
        }
    }
    }
    
    public static void main(String[] args) {
        hash.printtable();
    }
}
