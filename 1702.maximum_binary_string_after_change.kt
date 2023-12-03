class Solution {
  fun maximumBinaryString(binary: String): String {
    var k = binary.indexOf('0')
    if (k == -1) {
      return binary
    }
    val n = binary.length
    for (i in k + 1 until n) {
      if (binary[i] == '0') {
        ++k
      }
    }
    val ans = binary.toCharArray()
    Arrays.fill(ans, '1')
    ans[k] = '0'
    return String(ans)
  }
}
