class Solution {
  fun minimumPossibleSum(n: Int, target: Int): Long {
    var n = n
    val vis = BooleanArray(n + target)
    var ans: Long = 0
    var i = 1
    while (n > 0) {
      while (vis[i]) {
        ++i
      }
      ans += i.toLong()
      if (target >= i) {
        vis[target - i] = true
      }
      --n
      ++i
    }
    return ans
  }
}
