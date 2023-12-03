internal class Solution {
  fun threeSumMulti(arr: IntArray, target: Int): Int {
    val cnt = IntArray(101)
    for (v in arr) {
      ++cnt[v]
    }
    var ans: Long = 0
    for (j in arr.indices) {
      val b = arr[j]
      --cnt[b]
      for (i in 0 until j) {
        val a = arr[i]
        val c = target - a - b
        if (c >= 0 && c <= 100) {
          ans = (ans + cnt[c]) % Solution.Companion.MOD
        }
      }
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
