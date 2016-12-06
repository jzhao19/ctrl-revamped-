package ctrlf;

public class NewString {
    private int Index;
    private String Word;
    
    public NewString(String word, int index){
        Word = word;
        Index = index;
    }

    /**
     * @return the Index
     */
    public int getIndex() {
        return Index;
    }


    public String getWord() {
        return Word;
    }


    public String toString(){
        if (Word==null){
            return "NOT_FOUND";
        }
        String nWord;
        nWord = Word + ": " + Index;
        return nWord;
    }
}
