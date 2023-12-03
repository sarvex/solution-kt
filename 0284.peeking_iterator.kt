// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
internal class PeekingIterator // initialize any member here.
  (private val iterator: Iterator<Int>) : Iterator<Int?> {
  private var hasPeeked = false
  private var peekedElement: Int? = null

  // Returns the next element in the iteration without advancing the iterator.
  fun peek(): Int? {
    if (!hasPeeked) {
      peekedElement = iterator.next()
      hasPeeked = true
    }
    return peekedElement
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  override fun next(): Int? {
    if (!hasPeeked) {
      return iterator.next()
    }
    val result = peekedElement
    hasPeeked = false
    peekedElement = null
    return result
  }

  override fun hasNext(): Boolean {
    return hasPeeked || iterator.hasNext()
  }
}
