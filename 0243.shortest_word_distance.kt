import kotlin.math.abs
import kotlin.math.min

internal class Solution {
  fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
    var ans = 0x3f3f3f3f
    var k = 0
    var i = -1
    var j = -1
    while (k < wordsDict.size) {
      if (wordsDict[k] == word1) {
        i = k
      }
      if (wordsDict[k] == word2) {
        j = k
      }
      if (i != -1 && j != -1) {
        ans = min(ans.toDouble(), abs((i - j).toDouble())).toInt()
      }
      ++k
    }
    return ans
  }
}
