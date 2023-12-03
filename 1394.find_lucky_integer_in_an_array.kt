class Solution {
  fun findLucky(arr: IntArray?): Int {
    val cnt = IntArray(510)
    for (x in cnt) {
      ++cnt[x]
    }
    var ans = -1
    for (x in 1 until cnt.size) {
      if (cnt[x] == x) {
        ans = x
      }
    }
    return ans
  }
}
