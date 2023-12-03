internal class Solution {
  fun totalFruit(fruits: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    var j = 0
    val n = fruits.size
    for (x in fruits) {
      cnt.put(x, (cnt[x] ?: 0) + 1)
      if (cnt.size() > 2) {
        val y = fruits[j++]
        cnt.put(y, cnt[y]!! - 1)
        if (cnt[y] === 0) {
          cnt.remove(y)
        }
      }
    }
    return n - j
  }
}
