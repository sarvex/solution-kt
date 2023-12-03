class Solution {
  fun removeTrailingZeros(num: String): String {
    var i = num.length - 1
    while (num[i] == '0') {
      --i
    }
    return num.substring(0, i + 1)
  }
}
