class SeatManager(n: Int) {
  private val q: PriorityQueue<Int> = PriorityQueue()

  init {
    for (i in 1..n) {
      q.offer(i)
    }
  }

  fun reserve(): Int {
    return q.poll()
  }

  fun unreserve(seatNumber: Int) {
    q.offer(seatNumber)
  }
}
