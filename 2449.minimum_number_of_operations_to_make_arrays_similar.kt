class Solution {
  fun makeSimilar(nums: IntArray, target: IntArray): Long {
    Arrays.sort(nums)
    Arrays.sort(target)
    val a1: List<Int> = ArrayList()
    val a2: List<Int> = ArrayList()
    val b1: List<Int> = ArrayList()
    val b2: List<Int> = ArrayList()
    for (v in nums) {
      if (v % 2 == 0) {
        a1.add(v)
      } else {
        a2.add(v)
      }
    }
    for (v in target) {
      if (v % 2 == 0) {
        b1.add(v)
      } else {
        b2.add(v)
      }
    }
    var ans: Long = 0
    for (i in 0 until a1.size()) {
      ans += Math.abs(a1[i] - b1[i])
    }
    for (i in 0 until a2.size()) {
      ans += Math.abs(a2[i] - b2[i])
    }
    return ans / 4
  }
}
