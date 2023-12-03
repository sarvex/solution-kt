internal class Solution {
  fun multiply(num1: String, num2: String): String {
    if ("0" == num1 || "0" == num2) {
      return "0"
    }
    val m = num1.length
    val n = num2.length
    val arr = IntArray(m + n)
    for (i in m - 1 downTo 0) {
      val a = num1[i].code - '0'.code
      for (j in n - 1 downTo 0) {
        val b = num2[j].code - '0'.code
        arr[i + j + 1] += a * b
      }
    }
    for (i in arr.size - 1 downTo 1) {
      arr[i - 1] += arr[i] / 10
      arr[i] %= 10
    }
    var i = if (arr[0] == 0) 1 else 0
    val ans = StringBuilder()
    while (i < arr.size) {
      ans.append(arr[i])
      ++i
    }
    return ans.toString()
  }
}
