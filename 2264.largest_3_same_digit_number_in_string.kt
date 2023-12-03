class Solution {
  fun largestGoodInteger(num: String): String {
    for (i in 9 downTo 0) {
      val s = i.toString().repeat(3)
      if (num.contains(s)) {
        return s
      }
    }
    return ""
  }
}
