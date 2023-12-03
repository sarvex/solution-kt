import kotlin.math.min

class Solution {
  fun minimumRecolors(blocks: String, k: Int): Int {
    var cnt = 0
    for (i in 0 until k) {
      cnt += if (blocks[i] == 'W') 1 else 0
    }
    var ans = cnt
    for (i in k until blocks.length) {
      cnt += if (blocks[i] == 'W') 1 else 0
      cnt -= if (blocks[i - k] == 'W') 1 else 0
      ans = min(ans.toDouble(), cnt.toDouble()).toInt()
    }
    return ans
  }
}
