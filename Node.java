package ctrlf;

/**
 *
 * @author Jenny
 */
public class Node {
    private String Str;
    private Node Next;
    private Node Prev;
    private int Keyval;
    private int Index;
    
    public Node (String str, Node next, Node prev, int index ){
    Str = str;
    Next = next;
    Prev = prev;
    Index = index;
}
    
    public int getorigind(){
        return getIndex();
    }
    
    public Node setnext(Node next){
        Next = next;
        return Next;
    }
    
    public Node getnext(){
        return Next;
    }
    
    public Node setprev(Node prev){
        Prev = prev;
        return Prev;
    }
    
    public Node getprev(){
        return Prev;
    }
    
    public int setval(int keyval){
        Keyval = keyval;
        return Keyval;
    }
    
    public int getval(){
        return Keyval;
    }
    
    public String getString(){
        return Str;
    }
    
    public int compareTo(String name){
        if (this.getString().compareTo(name) < 1) {
            return -1;
        }
        else if (this.getString().compareTo(name) > 1){
            return 1;
        }
        else return 0;
    }
    
    @Override
    public String toString(){
        System.out.println("String:  " + Str + "   Next Node:  " + Next + "   Prev Node:  " + Prev);
    return Str;
}

    /**
     * @return the Index
     */
    public int getIndex() {
        return Index;
    }

    /**
     * @param Index the Index to set
     */
    public void setIndex(int Index) {
        this.Index = Index;
    }
}

