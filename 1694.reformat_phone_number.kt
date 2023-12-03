class Solution {
  fun reformatNumber(number: String): String {
    var number = number
    number = number.replace("-", "").replace(" ", "")
    val n = number.length
    val ans: List<String> = ArrayList()
    for (i in 0 until n / 3) {
      ans.add(number.substring(i * 3, i * 3 + 3))
    }
    if (n % 3 == 1) {
      ans.set(ans.size() - 1, ans[ans.size() - 1].substring(0, 2))
      ans.add(number.substring(n - 2))
    } else if (n % 3 == 2) {
      ans.add(number.substring(n - 2))
    }
    return java.lang.String.join("-", ans)
  }
}
