public class WordleDrawNew {
    private WordleDrawNewNode head;
    private WordleDrawNewNode last;
    private String motherWord;

    public WordleDrawNew(String word) {
        this.head = null;
        this.last = null;
        this.motherWord = word;
    }

    public void create() { // creates a linked list with all the characters --> head = first character in word!
        for (int i = this.motherWord.length() - 1; i >= 0; i--) {
            add(i);
        }
    }

    // reads a node on a certain position (in the word!)
    public char read(int position) {
        WordleDrawNewNode temp = head;
        boolean found = false;
        while (!found) {
            if (temp.getPos() == position) {
                found = true;
            } else {
                temp = temp.next();
            }
        }
        return temp.character;
    }

    private void add(int pos) {
        if (this.head == null) { // if list is empty
            this.head = new WordleDrawNewNode(motherWord, pos);
            this.last = this.head;
        } else {
            WordleDrawNewNode temp = this.head;
            this.head = new WordleDrawNewNode(motherWord, pos);
            head.setNext(temp);
            temp.setPrev(head);
        }
    }

    // deletes a node on a certain position (in the word!)
    public void delete(int position) {
        WordleDrawNewNode temp = head;
        boolean found = false;
        while (!found) {
            if (temp.getPos() == position) {
                found = true;
            } else {
                temp = temp.next();
            }
        }
        WordleDrawNewNode setPrev = temp.prev();
        WordleDrawNewNode setNext = temp.next();
        setPrev.setNext(temp.next());
        setNext.setPrev(temp.prev());
    }

    public boolean[] isPerfectMatch(String givenWord) {
        boolean[] output = new boolean[givenWord.length()];
        for (int i = 0; i < givenWord.length(); i++) {
            if (this.read(i) == givenWord.charAt(i)) {
                output[i] = true;
            } else {
                output[i] = false;
            }
        }
        return output;
    }

    public boolean[] isContained(String givenWord, boolean[] perfectMatch) {
        boolean[] output = new boolean[givenWord.length()];
        for (int i = 0; i < givenWord.length(); i++) {
            for (int j = 0; j < givenWord.length(); j++) {
                if (this.read(i) == givenWord.charAt(j)) {
                    if (i != j) {
                        output[i] = true;
                    }
                }
            }
        }
        return output;
    }




}

