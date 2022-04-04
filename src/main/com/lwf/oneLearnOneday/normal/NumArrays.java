package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-04 09:44
 */
public class NumArrays {
    /**
     * 暴力解法，超时
     */
    public class NumArray {
        int[] sum;
        int[] number;

        public NumArray(int[] nums) {
            number = nums;
            sum = new int[number.length];
            int sums = 0;
            for (int i = 0; i < sum.length; i++) {
                sum[i] = (sums += number[i]);
            }
        }

        public void update(int index, int val) {
            int oldVal = number[index];
            number[index] = val;
            int minus = val - oldVal;
            for (int i = index; i < sum.length; i++) {
                sum[i] += minus;
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sum[right];
            } else {
                return sum[right] - sum[left - 1];
            }
        }
    }

    /**
     * 分段数组
     */
    public class NumArray1 {
        public NumArray1(int[] nums) {
            number = nums;
            size = (int) Math.sqrt(nums.length);
            sum = new int[((number.length - 1) / size) + 1];

            for (int i = 0; i < nums.length; i++) {
                sum[i / size] += nums[i];
            }
        }

        int[] sum;
        int[] number;
        int size;

        public void update(int index, int val) {
            int oldVal = number[index];
            number[index] = val;
            int minus = val - oldVal;
            sum[index / size] += minus;
        }

        public int sumRange(int left, int right) {
            if (left == right) {
                return number[left];
            }
            int sumLeft = left / size;
            int sumRight = right / size;
            if (sumLeft == sumRight) {
                int sumRtn = 0;
                for (int i = left; i <= right; i++) {
                    sumRtn += number[i];

                }
                return sumRtn;
            } else {
                int sumRtn = 0;
                for (int i = left; i < (sumLeft + 1) * size; i++) {
                    sumRtn += number[i];
                }
                for (int i = sumLeft + 1; i < sumRight; i++) {
                    sumRtn += sum[i];
                }
                for (int i = sumRight * size; i <= right; i++) {
                    sumRtn += number[i];
                }
                return sumRtn;
            }
        }
    }

    /**
     * 线段数
     */
    public class NumArray2 {
        public NumArray2(int[] nums) {
            n = nums.length;
            segment = new int[n * 4];
            build(0, nums, 0, n - 1);

        }

        int[] segment;
        int n;

        /**
         * 使用递归方法，构建数组表示的树结构，每个节点i的子节点的坐标是2*i+1，2*i+2;每个叶子节点表示的是原来数组数值，每个父节点=左右子节点的和
         *
         * @param segmentIndex
         * @param nums
         * @param left
         * @param right
         */
        private void build(int segmentIndex, int[] nums, int left, int right) {
            if (left == right) {
                segment[segmentIndex] = nums[left];
                return;
            }
            int mid = (left + right) / 2;
            build(segmentIndex * 2 + 1, nums, left, mid);
            build(segmentIndex * 2 + 2, nums, mid + 1, right);
            segment[segmentIndex] = segment[segmentIndex * 2 + 1] + segment[segmentIndex * 2 + 2];

        }

        public void update(int index, int val) {
            update(0, index, val, 0, n - 1);
        }

        private void update(int segmentIndex, int index, int val, int left, int right) {
            if (left == right) {
                segment[segmentIndex] = val;
                return;
            }
            int mid = (left + right) / 2;
            if (index <= mid) {
                update(segmentIndex * 2 + 1, index, val, left, mid);
            } else {
                update(segmentIndex * 2 + 2, index, val, mid + 1, right);
            }
            segment[segmentIndex] = segment[segmentIndex * 2 + 1] + segment[segmentIndex * 2 + 2];
        }

        public int sumRange(int left, int right) {
            return sumRange(left, right, 0, 0, n - 1);
        }

        private int sumRange(int findL, int findR, int segIndex, int segL, int segR) {
            if (findL == segL && findR == segR) {
                return segment[segIndex];
            }
            int segM = (segL + segR) / 2;
            if (findR <= segM) {
                return sumRange(findL, findR, segIndex * 2 + 1, segL, segM);
            } else if (findL > segM) {
                return sumRange(findL, findR, segIndex * 2 + 2, segM + 1, segR);
            } else {
                return sumRange(findL, segM, segIndex * 2 + 1, segL, segM) + sumRange(segM + 1, findR, segIndex * 2 + 2, segM + 1, segR);
            }
        }
    }

    /**
     * 树状数组
     * 主要用来计算区间和以及数组元素更新的问题
     */
    public class NumArray3 {
        public NumArray3(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        int[] tree;
        int[] nums;
        int n;

        private int lowbit(int x) {
            return x & (-x);
        }

        private void add(int treeIndex, int number) {
            for (int i = treeIndex; i < tree.length; i += lowbit(i)) {
                tree[i] += number;
            }
        }

        public void update(int index, int val) {
            int oldVal = nums[index];
            nums[index] = val;
            int diff = val - oldVal;
            add(index + 1, diff);

        }

        private int querySum(int x) {
            int sum = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                sum += tree[i];
            }
            return sum;
        }

        public int sumRange(int left, int right) {
            return querySum(right + 1) - querySum(left);
        }

        class NumArray {

            public NumArray(int[] _nums) {
                nums = _nums;
                n = nums.length;
                //tree保存的是和，切计算需要借助二进制算法，因此下标是从1开始的！
                tree = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    add(i + 1, nums[i]);
                }
            }


            int[] tree;
            int[] nums;
            int n;

            /**
             * 固定函数，求x的最后一个二进制中1的位置。比如11100=100=（int）4
             * 用lowbit来查找节点i的父节点，父节点的坐标=i+lowbit(i)
             *
             * @param x
             * @return
             */
            int lowbit(int x) {
                return x & -x;
//                return x &(x^(x-1));

            }

            /**
             * 构建树状数组结构 更新也可以使用。只要找到所有包含了输入index的节点进行更新即可
             * 用lowbit来查找节点i的父节点，父节点的坐标=i+lowbit(i)
             * 树状数组的每个节点i中保留的是原始数组中的元素前缀和。
             * tree中的每个节点i的父节点 parent=i+lowbit(i);
             * tree中的特质： tree(i)=A(i-lowbit(i)+1)+A(i-lowbit(i)+2)...+A(i)
             */
            void add(int index, int number) {
                for (int i = index; i <= n; i += lowbit(i)) {
                    tree[i] += number;
                }
            }

            /**
             * update利用add方法，计算出输入的差值作为要更新进去的值，所有节点都增加该差值。
             *
             * @param i
             * @param val
             */
            public void update(int i, int val) {
                add(i + 1, val - nums[i]);
                nums[i] = val;
            }

            public int sumRange(int l, int r) {
                return query(r + 1) - query(l);
            }

            /**
             * 计算到x的所有前缀和，首先，在tree中 i是树的节点，i若是叶子节点，则只是本身tree(i)=A(i),
             * 若i不是叶子节点，则i表示一个以i为根的数，该数的区间是 i-lowbit(i)+1 ~i【参考tree的节点特征】
             * 因此从i向下查找 i-lowbit(i)即可找到所有和
             *
             * @param x
             * @return
             */
            int query(int x) {
                int ans = 0;
                for (int i = x; i > 0; i -= lowbit(i)) {
                    ans += tree[i];
                }
                return ans;
            }


        }
    }
}
