import kotlin.math.min

internal class Leaderboard {
  private val d: Map<Int, Int> = HashMap()
  private val rank: TreeMap<Int, Int> = TreeMap { a, b -> b - a }
  fun addScore(playerId: Int, score: Int) {
    d.merge(playerId, score) { a: Int, b: Int -> Integer.sum(a, b) }
    val newScore = d[playerId]!!
    if (newScore != score) {
      rank.merge(newScore - score, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    rank.merge(newScore, 1) { a: Int, b: Int -> Integer.sum(a, b) }
  }

  fun top(K: Int): Int {
    var K = K
    var ans = 0
    for (e in rank.entrySet()) {
      val score: Int = e.getKey()
      var cnt: Int = e.getValue()
      cnt = min(cnt.toDouble(), K.toDouble()).toInt()
      ans += score * cnt
      K -= cnt
      if (K == 0) {
        break
      }
    }
    return ans
  }

  fun reset(playerId: Int) {
    val score: Int = d.remove(playerId)
    if (rank.merge(score, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
      rank.remove(score)
    }
  }
}
