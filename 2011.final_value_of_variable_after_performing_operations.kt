class Solution {
  fun finalValueAfterOperations(operations: Array<String>): Int {
    var ans = 0
    for (s in operations) {
      ans += if (s[1] == '+') 1 else -1
    }
    return ans
  }
}
