package com.lwf.learn.everyday.coding.level2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 16:07
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list=new ArrayList<>();
    int index=-1;
    public NestedIterator(List<NestedInteger> nestedList) {

        recursive(nestedList);
        if (list.size()>0){
            index=0;
        }
    }
    public void recursive(List<NestedInteger> l){
        if (l==null||l.size()==0){
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            NestedInteger nestedInteger = l.get(i);
            if (nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else{
                recursive(nestedInteger.getList());
            }
        }
    }
    @Override
    public Integer next() {
        return  list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index!=-1&& list.size()!=index;
    }

     public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
}