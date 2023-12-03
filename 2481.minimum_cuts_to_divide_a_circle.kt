class Solution {
  fun numberOfCuts(n: Int): Int {
    return if (n > 1 && n % 2 == 1) n else n shr 1
  }
}
