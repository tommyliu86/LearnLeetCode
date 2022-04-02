package com.lwf.oldtime;


/**
 * author Administrator
 * time 2019-09-01-22:27
 */
public class Tree2str {
    /**
     * 效率不高，字符串拼接
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t==null ) return "";
        if (t.left==null&&t.right==null){
            return t.val+"";
        }
      return  ""+ t.val+(t.left==null?"()":"("+tree2str(t.left)+")")+
              (t.right==null?"":"("+tree2str(t.right)+")");

    }

    /**
     * 使用递归stringbuilder，提高效率
     * @param t
     * @param sb
     */
    public void preOrder(TreeNode t,StringBuilder sb){
        if (t==null) {
            return;
        }
        sb.append(t.val);
        if (t.left==null&&t.right==null){

            return;
        }else   {
            sb.append("(");
            preOrder(t.left,sb);
            sb.append(")");
            if (t.right!=null){
                sb.append("(");
                preOrder(t.right,sb);
                sb.append(")");
            }
        }
    }



}
