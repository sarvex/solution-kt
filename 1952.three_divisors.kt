class Solution {
  fun isThree(n: Int): Boolean {
    var cnt = 0
    for (i in 1..n / i) {
      if (n % i == 0) {
        cnt += if (n / i == i) 1 else 2
      }
    }
    return cnt == 3
  }
}
