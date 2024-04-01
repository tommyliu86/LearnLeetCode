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
            String[] split = preorder.split(",");
            //模拟前序遍历的过程，这里我们用栈来模拟
            //校验的方法类似于进行后序遍历，需要进行验证
            Stack<Integer> stack = new Stack<>();

            int i = 0;
            while (i < split.length) {
                //第一个节点
                if (stack.isEmpty() && i != 0) {
                    return false;
                }
                //左节点入栈
                while (i < split.length && !split[i].equals("#")) {
                    stack.push(2);
                    i++;
                }
                if (i == split.length) {
                    continue;
                }
                //遇到#号，则处理父节点节点
                if (split[i].equals("#")) {
                    i++;
                    if (stack.isEmpty()) {
                        continue;
                    }
                    Integer pop = stack.pop();
                    //表示这个子树已经都访问过了，就弹出了，下一个遍历到的节点就应该是父节点的右树的开始
                    while (!stack.isEmpty() && pop == 1) {
                        pop = stack.pop();
                    }
                    if (pop == 2) {
                        stack.push(pop - 1);
                    }

                }

            }
            return stack.isEmpty();
        }

    }
}
