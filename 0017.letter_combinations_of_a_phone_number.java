internal class Solution {
  fun letterCombinations(digits: String): List<String> {
    var ans: List<String> = ArrayList()
    if (digits.length == 0) {
      return ans
    }
    ans.add("")
    val d = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    for (i in digits.toCharArray()) {
      val s = d[i.code - '2'.code]
      val t: List<String> = ArrayList()
      for (a in ans) {
        for (b in s.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
          t.add(a + b)
        }
      }
      ans = t
    }
    return ans
  }
}
