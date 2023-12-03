class Solution {
  fun differenceOfSums(n: Int, m: Int): Int {
    var ans = 0
    for (i in 1..n) {
      ans += if (i % m == 0) -i else i
    }
    return ans
  }
}
