internal class RLEIterator(private val encoding: IntArray) {
  private var curr = 0
  private var i = 0
  fun next(n: Int): Int {
    var n = n
    while (i < encoding.size) {
      if (curr + n > encoding[i]) {
        n -= encoding[i] - curr
        i += 2
        curr = 0
      } else {
        curr += n
        return encoding[i + 1]
      }
    }
    return -1
  }
}
