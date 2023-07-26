package com.lwf.oneLearnOneday.hard;

import com.lwf.data.SegmentTree;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 线段树
 *
 * @author liuwenfei
 * @date 2023/2/20 17:37
 */
public class HandleQuery {
    class Solution {
        public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
            int n = nums1.length;
            int m = queries.length;
            SegTree tree = new SegTree(nums1);

            long sum = 0;
            for (int num : nums2) {
                sum += num;
            }
            List<Long> list = new ArrayList<Long>();
            for (int i = 0; i < m; i++) {
                if (queries[i][0] == 1) {
                    int l = queries[i][1];
                    int r = queries[i][2];
                    tree.reverseRange(l, r);
                } else if (queries[i][0] == 2) {
                    sum += (long) tree.sumRange(0, n - 1) * queries[i][1];
                } else if (queries[i][0] == 3) {
                    list.add(sum);
                }
            }
            long[] ans = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }


        class SegTree {
            private SegNode[] arr;

            public SegTree(int[] nums) {
                int n = nums.length;
                arr = new SegNode[n * 4 + 1];
                build(1, 0, n - 1, nums);
            }

            public int sumRange(int left, int right) {
                return query(1, left, right);
            }

            //翻转
            public void reverseRange(int left, int right) {
                modify(1, left, right);
            }

            //初始构建，使用包含左、右区间范围的节点来构建线段树
            public void build(int id, int l, int r, int[] nums) {
                arr[id] = new SegNode();
                arr[id].l = l;
                arr[id].r = r;
                arr[id].lazytag = false;
                if (l == r) {
                    arr[id].sum = nums[l];
                    return;
                }
                //构建左子树，右子树，构建完成后反过来通过左+右来计算当前节点的sum！
                int mid = (l + r) >> 1;
                build(2 * id, l, mid, nums);
                build(2 * id + 1, mid + 1, r, nums);
                arr[id].sum = arr[2 * id].sum + arr[2 * id + 1].sum;
            }

            /* pushdown函数：下传懒标记，即将当前区间的修改情况下传到其左右孩子结点 */
            public void pushdown(int x) {
                if (arr[x].lazytag) {
                    arr[2 * x].lazytag = !arr[2 * x].lazytag;
                    arr[2 * x].sum = arr[2 * x].r - arr[2 * x].l + 1 - arr[2 * x].sum;
                    arr[2 * x + 1].lazytag = !arr[2 * x + 1].lazytag;
                    arr[2 * x + 1].sum = arr[2 * x + 1].r - arr[2 * x + 1].l + 1 - arr[2 * x + 1].sum;
                    arr[x].lazytag = false;
                }
            }

            // 区间修改 这里的id是开始查找的 节点下标
            public void modify(int id, int l, int r) {
                //如果区间被包含在查找范围内 直接翻转 并返回，不需要再细分
                if (arr[id].l >= l && arr[id].r <= r) {
                    arr[id].sum = (arr[id].r - arr[id].l + 1) - arr[id].sum;
                    arr[id].lazytag = !arr[id].lazytag;
                    return;
                }
                //假如有修改标记，先下推修改
                pushdown(id);
                //如果左子树象交，修改左
                if (arr[2 * id].r >= l) {
                    modify(2 * id, l, r);
                }
                //如果右子树相交，修改右
                if (arr[2 * id + 1].l <= r) {
                    modify(2 * id + 1, l, r);
                }
                arr[id].sum = arr[2 * id].sum + arr[2 * id + 1].sum;
            }

            /* 区间查询 */
            public int query(int id, int l, int r) {
                if (arr[id].l >= l && arr[id].r <= r) {
                    return arr[id].sum;
                }
                if (arr[id].r < l || arr[id].l > r) {
                    return 0;
                }
                //此时表示当前区间与查询区间右交集
                pushdown(id);
                int res = 0;
                if (arr[2 * id].r >= l) {
                    res += query(2 * id, l, r);
                }
                if (arr[2 * id + 1].l <= r) {
                    res += query(2 * id + 1, l, r);
                }
                return res;
            }
        }

        //线段树节点，
        class SegNode {
            public int l, r, sum;
            public boolean lazytag;

            public SegNode() {
                this.l = 0;
                this.r = 0;
                this.sum = 0;
                this.lazytag = false;
            }
        }
    }


    /**
     * 线段树处理nums1进行区间更新
     */
    class Solution2 {
        public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
            List<Long> ans = new ArrayList<>();
            long sums1 = 0, sums2 = 0;
            for (int i = 0; i < nums2.length; i++) {
                sums1 += nums1[i];
                sums2 += nums2[i];
            }
            SegmentTree segmentTree = new SegmentTree(nums1);
            long[] longs = new long[ans.size()];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = ans.get(i);
            }
            return longs;
        }


        /**
         * 暴力解法
         * 对于操作1. 操作之后可以知道有多少个1存在，我们用sum1保存总数
         * 对于操作2，我们可以直接sum2+=p*sum1即可
         * 对于操作3.我们可以直接把sum2写入答案，
         * 这里的时间消耗主要在操作1处，因此如何快速计算操作1.
         */
        class Solution1 {
            public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {

//            BitSet bitSet = new BitSet(n);
                List<Long> ans = new ArrayList<>();
                long sum1 = 0;
                long sum2 = 0;
                for (int i = 0; i < nums2.length; i++) {
                    sum1 += nums1[i];
                    sum2 += nums2[i];
                }
                for (int i = 0; i < queries.length; i++) {
                    int[] query = queries[i];
                    if (query[0] == 1) {
                        int total = 0;
                        for (int j = query[1]; j <= query[2]; j++) {
                            nums1[j] ^= 1;
                            total += nums1[j];
                        }
                        sum1 = sum1 - (query[2] + 1 - query[1] - total) + total;
                    } else if (query[0] == 2) {

                        sum2 += sum1 * query[1];

                    } else {
                        ans.add(sum2);
                    }
                }
                long[] longs = new long[ans.size()];
                for (int i = 0; i < longs.length; i++) {
                    longs[i] = ans.get(i);
                }
                return longs;
            }
        }
    }
}
