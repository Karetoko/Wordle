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

    // examines if a certain word has a perfect character match
    public int isPerfect(String word) {
        if (word == this.motherWord) {
            return -1; // special case when everything's correct
        }
        if (word.charAt(pos) == character) {
            return pos; // When the character from the given word is a match, return the position
        } else {
            return -2; // there is no match!
        }
    }

    // examines if the given character is contained in the word; returns a boolean array -> important: includes perfect matches! (post-sorting needed)
    public boolean[] isContained(String word) {
        boolean[] output = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == this.character) { // if the character of the word at a certain position is equal to the given character, mark the position on the array as 'true'
                output[i] = true;
            } else {
                output[i] = false;
            }
        }
        return output;
    }


}
