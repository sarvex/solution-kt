class RecentCounter {
  private val q: Deque<Int> = ArrayDeque()
  fun ping(t: Int): Int {
    q.offer(t)
    while (q.peekFirst() < t - 3000) {
      q.pollFirst()
    }
    return q.size()
  }
}
