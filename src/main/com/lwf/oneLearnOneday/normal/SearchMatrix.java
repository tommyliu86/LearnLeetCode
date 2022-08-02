package com.lwf.oneLearnOneday.normal;



/**
 * createdWithIntellijIdea.User:Liuwenfei14Date:20191204Time:09:39
*/
public class SearchMatrix {
    public static void main(String[] args) {
        new SearchMatrix().searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},
        15);
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length==0||matrix[0].length==0||matrix[0][0]>target||matrix[matrix.length-1][matrix[0].length-1]<target) return  false;
        return halfSearch(matrix,0,0,matrix.length-1,matrix[0].length-1,target);
    }

    /**
     * 直接二分法错误，原因是左下和右上之间没有必然的大小关系，只有00 -xy是有大小关系的。因此不能直接二分
     * @param matrix
     * @param sx
     * @param sy
     * @param ex
     * @param ey
     * @param target
     * @return
     */
    boolean halfSearch(int[][] matrix,int sx,int sy,int ex,int ey,int target){
        if (matrix[ex][ey]==target||matrix[sx][sy]==target) return true;
        if ((ex-sx<2)&&(ey-sy<2)){
            boolean rtnx=false;
            if (sx+1<matrix.length) {
                rtnx= (matrix[sx+1][sy]==target);
            }
            boolean rtny=false;
            if (sy+1<matrix[0].length) {
                rtny= (matrix[sx][sy+1]==target);
            }
            return rtnx||rtny;
        }else{
            int subx=(ex+sx)/2 ;
            int suby=(ey+sy)/2 ;
            if (matrix[subx][suby]==target) {
                return true;
            }
            else  {
                return matrix[subx][suby]>target?halfSearch(matrix,sx,sy,subx,suby, target):halfSearch(matrix,subx,suby,ex,ey ,target);
            }
        }
    }

    /**
     * 分治法，但不二分，而是类似最短路径形式的剪枝方法！
     * @param matrix
     * @param target
     * @return
     */
    boolean binarySearch(int[][] matrix,int target){
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        for (int i = matrix.length-1, j=0; i >= 0&&j<matrix[0].length; ) {
            if (matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
