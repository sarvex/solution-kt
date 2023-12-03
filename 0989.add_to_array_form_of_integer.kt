class Solution {
  fun addToArrayForm(num: IntArray, k: Int): List<Int> {
    var k = k
    var i = num.size - 1
    var carry = 0
    val ans: LinkedList<Int> = LinkedList()
    while (i >= 0 || k > 0 || carry > 0) {
      carry += (if (i < 0) 0 else num[i--]) + k % 10
      ans.addFirst(carry % 10)
      carry /= 10
      k /= 10
    }
    return ans
  }
}
