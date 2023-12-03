class Solution {
  fun numOfStrings(patterns: Array<String?>, word: String): Int {
    var ans = 0
    for (p in patterns) {
      if (word.contains(p!!)) {
        ++ans
      }
    }
    return ans
  }
}
