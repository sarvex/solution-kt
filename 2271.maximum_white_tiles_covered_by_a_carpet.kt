import kotlin.math.max

class Solution {
  fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
    Arrays.sort(tiles) { a, b -> a.get(0) - b.get(0) }
    val n = tiles.size
    var s = 0
    var ans = 0
    var i = 0
    var j = 0
    while (i < n) {
      while (j < n && tiles[j][1] - tiles[i][0] + 1 <= carpetLen) {
        s += tiles[j][1] - tiles[j][0] + 1
        ++j
      }
      ans = if (j < n && tiles[i][0] + carpetLen > tiles[j][0]) {
        max(ans.toDouble(), (s + tiles[i][0] + carpetLen - tiles[j][0]).toDouble())
          .toInt()
      } else {
        max(ans.toDouble(), s.toDouble()).toInt()
      }
      s -= tiles[i][1] - tiles[i][0] + 1
      ++i
    }
    return ans
  }
}
