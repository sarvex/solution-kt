class Solution {
  fun frequencySort(nums: IntArray): IntArray {
    val cnt = IntArray(201)
    val t: List<Int> = ArrayList()
    for (v in nums) {
      v += 100
      ++cnt[v]
      t.add(v)
    }
    t.sort { a, b -> if (cnt[a] == cnt[b]) b - a else cnt[a] - cnt[b] }
    val ans = IntArray(nums.size)
    var i = 0
    for (v in t) {
      ans[i++] = v - 100
    }
    return ans
  }
}
