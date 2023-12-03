class Solution {
  fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
    val deg = IntArray(n)
    for (r in roads) {
      ++deg[r[0]]
      ++deg[r[1]]
    }
    Arrays.sort(deg)
    var ans: Long = 0
    for (i in 0 until n) {
      ans += (i + 1).toLong() * deg[i]
    }
    return ans
  }
}
