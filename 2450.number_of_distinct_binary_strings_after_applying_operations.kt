class Solution {
  fun countDistinctStrings(s: String, k: Int): Int {
    var ans = 1
    for (i in 0 until s.length - k + 1) {
      ans = ans * 2 % Solution.Companion.MOD
    }
    return ans
  }

  companion object {
    const val MOD = 1e9.toInt() + 7
  }
}
