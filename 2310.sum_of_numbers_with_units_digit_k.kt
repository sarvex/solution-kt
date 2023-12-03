class Solution {
  fun minimumNumbers(num: Int, k: Int): Int {
    if (num == 0) {
      return 0
    }
    for (i in 1..num) {
      val t = num - k * i
      if (t >= 0 && t % 10 == 0) {
        return i
      }
    }
    return -1
  }
}
