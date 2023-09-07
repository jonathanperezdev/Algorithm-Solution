package org.algorithms.books.commond_sense_guide.trie;

import java.util.Map;
import java.util.TreeMap;
/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 17: It Doesn’t Hurt to Trie
 * Implementing a Trie data structure
 * Add a method to the classic LinkedList class that reverses the list. That is, if the original list is A -> B -> C, all of the list’s links should change so that C -> B -> A.
 *
 * Solution:
 * 1. Is a Tree data structure but not binary-tree
 * 2. It has a TrieNode who is a class with a TreeMap
 *      * With Key String who is the character
 *      * And pointer to next TrieNode
 * 3. TreeMap is needed because asterisk * should be first into the Map
 *
 * See Knowledge-base Trie data structure
 * */
public class Trie {
    TrieNode root = new TrieNode();
    public Trie(String word){
        addWord(word);
    }

    public void addWord(String word){
        TrieNode current = root;
        for(String letter : word.split("")){
            current = current.addLetter(letter);
        }
        current.addLetter("*");
    }

    public void printTrie(){
        print(root,"");
    }

    private void print(TrieNode current, String word){
        for (Map.Entry<String, TrieNode> letter : current.letters.entrySet()){
            if("*".equals(letter.getKey())) {
                System.out.println(word);
            }else{
                word = word+letter.getKey();
                print(letter.getValue(), word);
            }
        }
    }
}

class TrieNode {
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

