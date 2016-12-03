public class Node {
    private String Str;
    private Node Next;
    private Node Prev;
    private int Keyval;
    
    public Node (String str, Node next, Node prev){
    Str = str;
    Next = next;
    Prev = prev;
    
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
    
    public int compareTo(String name){
        if (this.Str.compareTo(name) < 1) {
            return -1;
        }
        else if (this.Str.compareTo(name) > 1){
            return 1;
        }
        else return 0;
    }
    
    @Override
    public String toString(){
        System.out.println("String:  " + Str + "   Next Node:  " + Next);
    return Str;
}
}
