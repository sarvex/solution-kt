import kotlin.math.max

class Solution {
  fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    var power = power
    Arrays.sort(tokens)
    var i = 0
    var j = tokens.size - 1
    var ans = 0
    var t = 0
    while (i <= j) {
      if (power >= tokens[i]) {
        power -= tokens[i++]
        ++t
        ans = max(ans.toDouble(), t.toDouble()).toInt()
      } else if (t > 0) {
        power += tokens[j--]
        --t
      } else {
        break
      }
    }
    return ans
  }
}
