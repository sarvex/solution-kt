/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 * // Return the width of char ch when fontSize is used.
 * public int getWidth(int fontSize, char ch) {}
 * // Return Height of any char when fontSize is used.
 * public int getHeight(int fontSize)
 * }
 */
internal class Solution {
  fun maxFont(text: String, w: Int, h: Int, fonts: IntArray, fontInfo: FontInfo): Int {
    var left = 0
    var right = fonts.size - 1
    while (left < right) {
      val mid = left + right + 1 shr 1
      if (check(text, fonts[mid], w, h, fontInfo)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return if (check(text, fonts[left], w, h, fontInfo)) fonts[left] else -1
  }

  private fun check(text: String, size: Int, w: Int, h: Int, fontInfo: FontInfo): Boolean {
    if (fontInfo.getHeight(size) > h) {
      return false
    }
    var width = 0
    for (c in text.toCharArray()) {
      width += fontInfo.getWidth(size, c)
    }
    return width <= w
  }
}
