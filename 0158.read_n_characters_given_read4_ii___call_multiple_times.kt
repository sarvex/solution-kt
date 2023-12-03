/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */
class Solution : Reader4() {
  private val buf4 = CharArray(4)
  private var i = 0
  private var size = 0

  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  fun read(buf: CharArray, n: Int): Int {
    var j = 0
    while (j < n) {
      if (i == size) {
        size = read4(buf4)
        i = 0
        if (size == 0) {
          break
        }
      }
      while (j < n && i < size) {
        buf[j++] = buf4[i++]
      }
    }
    return j
  }
}
