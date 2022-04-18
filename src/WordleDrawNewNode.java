public class WordleDrawNewNode {
    public char character;
    private int pos;
    private String motherWord;
    private WordleDrawNewNode prev;
    private WordleDrawNewNode next;

    public WordleDrawNewNode(String word, int position) {
        this.motherWord = word;
        this.character = word.charAt(position);
        this.pos = position;
        this.prev = null;
        this.next = null;
    }

    public void setNext(WordleDrawNewNode node) {
        this.next = node;
    }

    public void setPrev(WordleDrawNewNode node) {
        this.prev = node;
    }

    public WordleDrawNewNode next() {
        return next;
    }

    public WordleDrawNewNode prev() {
        return prev;
    }

    public int getPos() {
        return pos;
    }


}
