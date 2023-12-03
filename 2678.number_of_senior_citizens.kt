class Solution {
  fun countSeniors(details: Array<String>): Int {
    var ans = 0
    for (x in details) {
      val age = x.substring(11, 13).toInt()
      if (age > 60) {
        ++ans
      }
    }
    return ans
  }
}
