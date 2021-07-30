package lcof;

import java.util.PriorityQueue;

/**
 * Offer 59. 滑动窗口的最大值。
 * 这里我的用的堆（优先级队列）去做的。
 * 其实更好的方法是使用单调双端队列，这里暂时不做过多深入研究。
 * @author LBW
 */
public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        int len = nums.length - k + 1;
        int[] res = new int[len];
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        res[0] = queue.peek();
        for (int i = 1; i < len; i++) {
            // update the queue
            queue.remove(nums[i - 1]);
            queue.offer(nums[i + k - 1]);
            // get the largest element
            res[i] = queue.peek();
        }
        return res;
    }
}
