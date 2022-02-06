package com.company.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<Integer> generate(int numRows) {
//        numRows = numRows +1;
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        bigList.add(list);
        if (numRows == 0)
            return bigList.get(0);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        bigList.add(list1);
        if (numRows == 1)
        {
            return bigList.get(1);
        }

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(1);
        bigList.add(list2);
        if (numRows >= 2) {
            int size = numRows;
            for (int i = 0; i < size-2; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                for (int j=0; j<list2.size()-1; j++) {
                   temp.add(list2.get(j) + list2.get(j+1));
                }
                temp.add(1);
                bigList.add(temp);
                list2=temp;
            }
            return bigList.get(numRows);
        }
        return bigList.get(numRows);
    }

    public static void main(String[] args) {
        List<Integer> bigList =  generate( 3);
        System.out.println(bigList);
    }
}
