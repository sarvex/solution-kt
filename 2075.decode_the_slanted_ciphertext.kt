internal class Solution {
  fun decodeCiphertext(encodedText: String, rows: Int): String {
    val ans = StringBuilder()
    val cols = encodedText.length / rows
    for (j in 0 until cols) {
      var x = 0
      var y = j
      while (x < rows && y < cols) {
        ans.append(encodedText[x * cols + y])
        ++x
        ++y
      }
    }
    while (ans.length > 0 && ans[ans.length - 1] == ' ') {
      ans.deleteCharAt(ans.length - 1)
    }
    return ans.toString()
  }
}
