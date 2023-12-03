internal class Solution {
  fun predictPartyVictory(senate: String): String {
    val n = senate.length
    val qr: Deque<Int> = ArrayDeque()
    val qd: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (senate[i] == 'R') {
        qr.offer(i)
      } else {
        qd.offer(i)
      }
    }
    while (!qr.isEmpty() && !qd.isEmpty()) {
      if (qr.peek() < qd.peek()) {
        qr.offer(qr.peek() + n)
      } else {
        qd.offer(qd.peek() + n)
      }
      qr.poll()
      qd.poll()
    }
    return if (qr.isEmpty()) "Dire" else "Radiant"
  }
}
