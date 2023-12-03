class Solution {
  fun smallestRepunitDivByK(k: Int): Int {
    var n = 1 % k
    for (i in 1..k) {
      if (n == 0) {
        return i
      }
      n = (n * 10 + 1) % k
    }
    return -1
  }
}
