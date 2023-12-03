internal class TopVotedCandidate(persons: IntArray, times: IntArray) {
  private val times: IntArray
  private val wins: IntArray

  init {
    val n = persons.size
    var mx = 0
    var cur = 0
    this.times = times
    wins = IntArray(n)
    val counter = IntArray(n)
    for (i in 0 until n) {
      val p = persons[i]
      if (++counter[p] >= mx) {
        mx = counter[p]
        cur = p
      }
      wins[i] = cur
    }
  }

  fun q(t: Int): Int {
    var left = 0
    var right = wins.size - 1
    while (left < right) {
      val mid = left + right + 1 ushr 1
      if (times[mid] <= t) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return wins[left]
  }
}
