package org.algorithms.courses.udemy.master_coding_interview.data_structures;

/*
 * Data Structure and Algorithms
 *
 * Section 6: Data Structures: Arrays
 *  73. Exercise: Implement A Hash Table
 * */
public class MyHash {

    private String[] data;

    public MyHash(int capacity) {
        data = new String[capacity];
    }

    public String get(String key){
        return data[hash(key)];
    }

    public void put(String key, String value){
        data[hash(key)] = value;
    }

    private int hash(String key){
        int sumASCII = key.chars().reduce((left, right) -> (int)left + (int)right).getAsInt();
        return sumASCII % data.length;
    }

    public static void main(String[] args) {
        MyHash myHas = new MyHash(20);
        myHas.put("cats", "two");
        myHas.put("dogs", "one");

        System.out.println(myHas.get("cats"));
        System.out.println(myHas.get("dogs"));
    }
}
