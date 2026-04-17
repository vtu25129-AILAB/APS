import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The top of the min-heap is the kth largest element
        return minHeap.peek();
    }
}
