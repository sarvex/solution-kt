import kotlin.math.max

class Solution {
  private val f: Map<Long, Int> = HashMap()
  private var size = 0
  fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
    size = batchSize
    var ans = 0
    var state: Long = 0
    for (g in groups) {
      val i = g % size
      if (i == 0) {
        ++ans
      } else {
        state += 1L shl i * 5
      }
    }
    ans += dfs(state, 0)
    return ans
  }

  private fun dfs(state: Long, mod: Int): Int {
    if (f.containsKey(state)) {
      return f[state]!!
    }
    var res = 0
    for (i in 1 until size) {
      if (state shr i * 5 and 31L != 0L) {
        val t = dfs(state - (1L shl i * 5), (mod + i) % size)
        res = max(res.toDouble(), (t + if (mod == 0) 1 else 0).toDouble()).toInt()
      }
    }
    f.put(state, res)
    return res
  }
}
