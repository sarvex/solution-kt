class Solution {
  fun mostVisited(n: Int, rounds: IntArray): List<Int> {
    val m = rounds.size - 1
    val ans: List<Int> = ArrayList()
    if (rounds[0] <= rounds[m]) {
      for (i in rounds[0]..rounds[m]) {
        ans.add(i)
      }
    } else {
      for (i in 1..rounds[m]) {
        ans.add(i)
      }
      for (i in rounds[0]..n) {
        ans.add(i)
      }
    }
    return ans
  }
}
