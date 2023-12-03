import kotlin.math.max
import kotlin.math.min

class TextEditor {
  private val left = StringBuilder()
  private val right = StringBuilder()
  fun addText(text: String?) {
    left.append(text)
  }

  fun deleteText(k: Int): Int {
    var k = k
    k = min(k.toDouble(), left.length.toDouble()).toInt()
    left.setLength(left.length - k)
    return k
  }

  fun cursorLeft(k: Int): String {
    var k = k
    k = min(k.toDouble(), left.length.toDouble()).toInt()
    for (i in 0 until k) {
      right.append(left[left.length - 1])
      left.deleteCharAt(left.length - 1)
    }
    return left.substring(max((left.length - 10).toDouble(), 0.0).toInt())
  }

  fun cursorRight(k: Int): String {
    var k = k
    k = min(k.toDouble(), right.length.toDouble()).toInt()
    for (i in 0 until k) {
      left.append(right[right.length - 1])
      right.deleteCharAt(right.length - 1)
    }
    return left.substring(max((left.length - 10).toDouble(), 0.0).toInt())
  }
}
