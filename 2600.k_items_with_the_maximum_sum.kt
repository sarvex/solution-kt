class Solution {
  fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
    if (numOnes >= k) {
      return k
    }
    return if (numZeros >= k - numOnes) {
      numOnes
    } else numOnes - (k - numOnes - numZeros)
  }
}
