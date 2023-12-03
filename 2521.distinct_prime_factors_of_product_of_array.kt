class Solution {
  fun distinctPrimeFactors(nums: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (n in nums) {
      for (i in 2..n / i) {
        if (n % i == 0) {
          s.add(i)
          while (n % i == 0) {
            n /= i
          }
        }
      }
      if (n > 1) {
        s.add(n)
      }
    }
    return s.size()
  }
}
