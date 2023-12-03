class Solution {
  fun findMatrix(nums: IntArray): List<List<Int>> {
    val ans: List<List<Int>> = ArrayList()
    val n = nums.size
    val cnt = IntArray(n + 1)
    for (x in nums) {
      ++cnt[x]
    }
    for (x in 1..n) {
      val v = cnt[x]
      for (j in 0 until v) {
        if (ans.size() <= j) {
          ans.add(ArrayList())
        }
        ans[j].add(x)
      }
    }
    return ans
  }
}
