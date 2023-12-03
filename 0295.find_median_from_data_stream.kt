internal class MedianFinder
/** initialize your data structure here.  */
{
  private val q1: PriorityQueue<Int> = PriorityQueue()
  private val q2: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
  fun addNum(num: Int) {
    q1.offer(num)
    q2.offer(q1.poll())
    if (q2.size() - q1.size() > 1) {
      q1.offer(q2.poll())
    }
  }

  fun findMedian(): Double {
    return if (q2.size() > q1.size()) {
      q2.peek()
    } else (q1.peek() + q2.peek()) * 1.0 / 2
  }
}
