internal class KthLargest(k: Int, nums: IntArray) {
  private val q: PriorityQueue<Int>
  private val size: Int

  init {
    q = PriorityQueue(k)
    size = k
    for (num in nums) {
      add(num)
    }
  }

  fun add(`val`: Int): Int {
    q.offer(`val`)
    if (q.size() > size) {
      q.poll()
    }
    return q.peek()
  }
}
