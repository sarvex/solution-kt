internal class Solution {
  fun circularPermutation(n: Int, start: Int): List<Int> {
    val ans: List<Int> = ArrayList()
    for (i in 0 until (1 shl n)) {
      ans.add(i xor (i shr 1) xor start)
    }
    return ans
  }
}
