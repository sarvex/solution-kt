/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */
class Solution : Reader4() {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  fun read(buf: CharArray, n: Int): Int {
    val buf4 = CharArray(4)
    var i = 0
    var v = 5
    while (v >= 4) {
      v = read4(buf4)
      for (j in 0 until v) {
        buf[i++] = buf4[j]
        if (i >= n) {
          return n
        }
      }
    }
    return i
  }
}
