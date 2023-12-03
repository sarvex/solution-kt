class Solution {
  fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
    val cnt: Map<Int, Int> = HashMap()
    for (v in nums) {
      cnt.put(v, (cnt[v] ?: 0) + 1)
    }
    Arrays.sort(nums)
    for (v in nums) {
      if (cnt.containsKey(v)) {
        for (x in v until v + k) {
          if (!cnt.containsKey(x)) {
            return false
          }
          cnt.put(x, cnt[x]!! - 1)
          if (cnt[x] === 0) {
            cnt.remove(x)
          }
        }
      }
    }
    return true
  }
}
