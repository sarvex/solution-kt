class Solution : Relation() {
  fun findCelebrity(n: Int): Int {
    var ans = 0
    for (i in 1 until n) {
      if (knows(ans, i)) {
        ans = i
      }
    }
    for (i in 0 until n) {
      if (ans != i) {
        if (knows(ans, i) || !knows(i, ans)) {
          return -1
        }
      }
    }
    return ans
  }
}
