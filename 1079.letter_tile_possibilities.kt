internal class Solution {
  fun numTilePossibilities(tiles: String): Int {
    val cnt = IntArray(26)
    for (c in tiles.toCharArray()) {
      ++cnt[c.code - 'A'.code]
    }
    return dfs(cnt)
  }

  private fun dfs(cnt: IntArray): Int {
    var res = 0
    for (i in cnt.indices) {
      if (cnt[i] > 0) {
        ++res
        --cnt[i]
        res += dfs(cnt)
        ++cnt[i]
      }
    }
    return res
  }
}
