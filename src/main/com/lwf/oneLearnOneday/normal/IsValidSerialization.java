package com.lwf.oneLearnOneday.normal;

import java.util.Stack;

/**
 * 331. 验证二叉树的前序序列化
 * from home
 * author: liuwu
 * time: 2024/3/31 22:04
 */
public class IsValidSerialization {
    class Solution {
        public boolean isValidSerialization(String preorder) {
           //模拟前序遍历的过程，这里我们用栈来模拟
           //使用栈模拟前序遍历
            Stack<String> stack = new Stack<>();
            String[] split = preorder.split(",");
            stack.push(split[0]);
            int i=1;
            while (i<split.length) {
                //如果栈位空，但i没有遍历完成，则表示不是一个合法的二叉树
                if (stack.isEmpty()) {
                    return false;
                }
                //左节点入栈
                while (i<split.length && !split[i].equals("#")) {
                    stack.push(split[i++]);
                }
                //左节点找到底
                if (i==split.length ) {
                    return true;
                }
                //否则表示左节点遍历到最后了
                stack.push(split[i]);
                stack.push("#");
                i++;
            }

        }

    }
}
