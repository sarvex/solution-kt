internal class PhoneDirectory(maxNumbers: Int) {
  private val provided: BooleanArray

  /**
   * Initialize your data structure here
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  init {
    provided = BooleanArray(maxNumbers)
  }

  /**
   * Provide a number which is not assigned to anyone.
   * @return - Return an available number. Return -1 if none is available.
   */
  fun get(): Int {
    for (i in provided.indices) {
      if (!provided[i]) {
        provided[i] = true
        return i
      }
    }
    return -1
  }

  /** Check if a number is available or not.  */
  fun check(number: Int): Boolean {
    return !provided[number]
  }

  /** Recycle or release a number.  */
  fun release(number: Int) {
    provided[number] = false
  }
}
