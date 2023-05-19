package org.algorithms.books.commond_sense_guide.recursion;

class ReverseString {
    public String reverseOf(String word, int index){
        if(index == word.length()-1){
            return word.split("")[index];
        }

        return reverseOf(word, index+1) + word.split("")[index];
    }
}

//region Test
class ReverseStringTest{
    private ReverseString template = new ReverseString();

    public static void main(String[] args){
        ReverseStringTest test = new ReverseStringTest();
        test.test1();
    }

    private void test1(){
        System.out.println(template.reverseOf("ABCDEF", 0));
    }
}
//endregion
