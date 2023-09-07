package org.algorithms.books.commond_sense_guide.trie;

public class ExecuteTrie {
    public static void main(String[] args){
        Trie trie = new Trie("ace");
        trie.addWord("acedc");
        trie.printTrie();
    }
}
