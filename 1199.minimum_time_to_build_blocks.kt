internal class Solution {
  fun minBuildTime(blocks: IntArray, split: Int): Int {
    val q: PriorityQueue<Int> = PriorityQueue()
    for (x in blocks) {
      q.offer(x)
    }
    while (q.size() > 1) {
      q.poll()
      q.offer(q.poll() + split)
    }
    return q.poll()
  }
}
