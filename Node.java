public class Node {
    private String Str;
    private Node Next;
    private int Keyval;
    
    public Node (String str, Node next){
    Str = str;
    Next = next;
    
}
    
    public Node setnext(Node next){
        Next = next;
        return Next;
    }
    
    public int setval(int keyval){
        Keyval = keyval;
        return Keyval;
    }
    
    public int getval(){
        return Keyval;
    }
    
    @Override
    public String toString(){
        System.out.println("String:  " + Str + "   Next Node:  " + Next);
    return Str;
}
}
