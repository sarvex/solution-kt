internal class MedianFinder(private val k: Int) {
  private val small: PriorityQueue<Int> = PriorityQueue(Comparator.reverseOrder())
  private val large: PriorityQueue<Int> = PriorityQueue()
  private val delayed: Map<Int, Int> = HashMap()
  private var smallSize = 0
  private var largeSize = 0
  fun addNum(num: Int) {
    if (small.isEmpty() || num <= small.peek()) {
      small.offer(num)
      ++smallSize
    } else {
      large.offer(num)
      ++largeSize
    }
    rebalance()
  }

  fun findMedian(): Double {
    return if (k and 1 == 1) small.peek() else (small.peek() as Double + large.peek()) / 2
  }

  fun removeNum(num: Int) {
    delayed.merge(num, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    if (num <= small.peek()) {
      --smallSize
      if (num == small.peek()) {
        prune(small)
      }
    } else {
      --largeSize
      if (num == large.peek()) {
        prune(large)
      }
    }
    rebalance()
  }

  private fun prune(pq: PriorityQueue<Int>) {
    while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
      if (delayed.merge(pq.peek(), -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        delayed.remove(pq.peek())
      }
      pq.poll()
    }
  }

  private fun rebalance() {
    if (smallSize > largeSize + 1) {
      large.offer(small.poll())
      --smallSize
      ++largeSize
      prune(small)
    } else if (smallSize < largeSize) {
      small.offer(large.poll())
      --largeSize
      ++smallSize
      prune(large)
    }
  }
}

internal class Solution {
  fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    val finder = MedianFinder(k)
    for (i in 0 until k) {
      finder.addNum(nums[i])
    }
    val n = nums.size
    val ans = DoubleArray(n - k + 1)
    ans[0] = finder.findMedian()
    for (i in k until n) {
      finder.addNum(nums[i])
      finder.removeNum(nums[i - k])
      ans[i - k + 1] = finder.findMedian()
    }
    return ans
  }
}
