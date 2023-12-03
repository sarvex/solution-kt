class Solution {
  fun lastVisitedIntegers(words: List<String>): List<Int> {
    val nums: List<Int> = ArrayList()
    val ans: List<Int> = ArrayList()
    var k = 0
    for (w in words) {
      if ("prev" == w) {
        ++k
        val i: Int = nums.size() - k
        ans.add(if (i < 0) -1 else nums[i])
      } else {
        k = 0
        nums.add(w)
      }
    }
    return ans
  }
}
