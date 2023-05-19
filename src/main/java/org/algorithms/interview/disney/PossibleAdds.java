package org.algorithms.interview.disney;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Company: Disney
 * Type of Algorithms: Recursive top-down
 *
 * Given a list of adds represented by letters ABCD, a number of spaces between them, and a total number of spots, return in a string, the possible combinations to show this adds
 *
 * Note 1: Between each group of adds should exist the spaces defined
 * Note 2: The returned string with the distribution can not be greater than the available spots
 *
 * Solution:
 * 1. This problem is solved using recursive top-down strategy, starting with all items and reducing the problem by one letter
 */
class PossibleAdds {
    public String allAdds = "";
    private int spots;
    private String spacesStr = "";
    public int numberOfAdds;
    public void findPossibleAdds(String adds, int spaces, int spots){
        this.spots = spots;
        spacesStr = "";
        for(int i = 0; i<spaces;i++){
            spacesStr = spacesStr + " ";
        }
        findAllAdds(Arrays.asList(adds.split("")), "");
    }

    private void findAllAdds(List<String> letters, String var){
        //Base Case
        if(letters.size() == 0){
            if(allAdds.length() + var.length() + spacesStr.length() <= spots){
                allAdds = allAdds + var + spacesStr;
                numberOfAdds += 1;
            }
            return;
        }

        //The recursive case should be executed for each letter
        for(int i = 0; i < letters.size(); i++){
            //Recursive case
            findAllAdds(removeItem(letters, i), var+letters.get(i));
        }
    }

    private List<String> removeItem(List<String> letters, int index){
        List<String> copy = letters.stream()
                .map(String::new)
                .collect(toList());

        //Reducing the problem
        copy.remove(index);
        return copy;
    }
}

//region Test
class PossibleAddsTest{
    private PossibleAdds possibleAdds = new PossibleAdds();

    public static void main(String[] args){
        PossibleAddsTest test = new PossibleAddsTest();
        test.test1();
    }

    private void test1(){
        possibleAdds.findPossibleAdds("ABCD", 2, 40);
        System.out.println(possibleAdds.allAdds);
        System.out.println(possibleAdds.numberOfAdds);
    }
}
//endregion
