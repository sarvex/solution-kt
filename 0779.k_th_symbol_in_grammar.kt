internal class Solution {
  fun kthGrammar(n: Int, k: Int): Int {
    return Integer.bitCount(k - 1) and 1
  }
}
