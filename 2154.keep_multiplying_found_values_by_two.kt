class Solution {
  fun findFinalValue(nums: IntArray, original: Int): Int {
    var original = original
    val s: Set<Int> = HashSet()
    for (num in nums) {
      s.add(num)
    }
    while (s.contains(original)) {
      original = original shl 1
    }
    return original
  }
}
