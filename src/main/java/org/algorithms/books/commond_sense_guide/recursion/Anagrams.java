package org.algorithms.books.commond_sense_guide.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Anagrams {
    public List<String> allAnagrams = new ArrayList<>();
    public void anagramsOf(List<String> listWord, String acum){
        if(listWord.size() == 1){
            allAnagrams.add(acum+listWord.get(0));
            return;
        }

        for(int i = 0; i < listWord.size(); i++){
            //Sub-problem
            anagramsOf(listWithout(listWord, i), acum + listWord.get(i));
        }
    }

    private List<String> listWithout(List<String> listWord, int index){
        List<String> cloneListWord = listWord.stream().map(String::new).collect(Collectors.toList());
        cloneListWord.remove(index);
        return cloneListWord;
    }
}

//<editor-fold desc="Test">
class AnagramsTest{
    private Anagrams anagrams = new Anagrams();

    public static void main(String[] args){
        AnagramsTest test = new AnagramsTest();
        test.test1();
    }

    private void test1(){
        anagrams.anagramsOf(Arrays.asList("ABC".split("")),"");
        anagrams.allAnagrams.forEach(System.out::println);
    }
}
//</editor-fold>