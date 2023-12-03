internal class Solution {
  fun countPrimeSetBits(left: Int, right: Int): Int {
    var ans = 0
    for (i in left..right) {
      if (Solution.Companion.primes.contains(Integer.bitCount(i))) {
        ++ans
      }
    }
    return ans
  }

  companion object {
    private val primes: Set<Int> = Set.of(2, 3, 5, 7, 11, 13, 17, 19)
  }
}
