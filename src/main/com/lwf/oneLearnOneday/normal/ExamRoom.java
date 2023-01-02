package com.lwf.oneLearnOneday.normal;

import java.util.PriorityQueue;
import java.util.TreeSet;

class ExamRoom {
    public static void main(String[] args) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> {
            int al = a[1] - a[0];
            int bl = b[1] - b[0];

            return bl - al;

        });
        priorityQueue.add(new int[]{0, 9});
        priorityQueue.add(new int[]{2, 9});
        priorityQueue.add(new int[]{4, 9});
        priorityQueue.add(new int[]{3, 9});


        ExamRoom1 examRoom1 = new ExamRoom1(10);
        examRoom1.seat();
        examRoom1.seat();
        examRoom1.seat();
        examRoom1.seat();
        examRoom1.leave(4);
        examRoom1.seat();
    }

    /**
     * 官方思路，
     */
    static class ExamRoom1 {
        TreeSet<Integer> students = new TreeSet<>();
        int num;
        PriorityQueue<int[]> priorityQueue;

        public ExamRoom1(int n) {
            num = n;

            priorityQueue = new PriorityQueue<int[]>((a, b) -> {
                int al = (a[1] - a[0]) / 2;
                int bl = (b[1] - b[0]) / 2;
                if (al == bl) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(bl, al);
                }
            });
        }

        public int seat() {
            if (students.size() == 0) {
                students.add(0);
                return 0;
            }


            Integer first = students.first();
            int curPoint = 0;
            int curStep = first - 0;
            int[] point = new int[]{curPoint, first};

            Integer last = students.last();
            int ll = num - 1 - last;
            if (curStep < ll) {
                curPoint = num - 1;
                curStep = ll;
                point = new int[]{last, num - 1};
            }

            int[] peek = priorityQueue.peek();
            while (peek != null && (!students.contains(peek[0]) || !students.contains(peek[1]) || students.higher(peek[0]) != peek[1])) {
                priorityQueue.poll();
                peek = priorityQueue.peek();
            }
            int mid = peek == null ? 0 : ((peek[1] - peek[0]) / 2);

            if ((curStep == mid && point[0] > peek[0] + mid) || curStep < mid) {
                curPoint = peek[0] + mid;
                students.add(curPoint);
                priorityQueue.offer(new int[]{peek[0], curPoint});
                priorityQueue.offer(new int[]{curPoint, peek[1]});

            } else {
                students.add(curPoint);
                priorityQueue.offer(point);
            }
            return curPoint;
        }


        public void leave(int p) {
            Integer first = students.lower(p);

            Integer last = students.higher(p);

            students.remove(p);
            if (first != null && last != null) {
                priorityQueue.offer(new int[]{first, last});
            }
        }
    }

}

