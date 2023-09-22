package org.algorithms.books.commond_sense_guide.trie;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
    Map<String, TrieNode> letters = new TreeMap<>();
    public TrieNode addLetter(String letter){
        TrieNode trieNode;
        if("*".equals(letter)) {
            trieNode = null;
            letters.put(letter, null);
        }else if(letters.containsKey(letter)){
            trieNode = letters.get(letter);
        } else {
            trieNode = new TrieNode();
            letters.put(letter, trieNode);
        }

        return trieNode;
    }
}
