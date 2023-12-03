internal class Solution {
  private var n = 0
  private var maxScore: Long = 0
  private var ans = 0
  private var graph: List<List<Int>>? = null
  fun countHighestScoreNodes(parents: IntArray): Int {
    n = parents.size
    maxScore = 0
    ans = 0
    graph = ArrayList()
    for (i in 0 until n) {
      graph.add(ArrayList())
    }
    for (i in 1 until n) {
      graph.get(parents[i]).add(i)
    }
    dfs(0)
    return ans
  }

  private fun dfs(cur: Int): Int {
    var size = 1
    var score: Long = 1
    for (child in graph!![cur]) {
      val s = dfs(child)
      size += s
      score *= s.toLong()
    }
    if (cur > 0) {
      score *= (n - size).toLong()
    }
    if (score > maxScore) {
      maxScore = score
      ans = 1
    } else if (score == maxScore) {
      ans++
    }
    return size
  }
}
