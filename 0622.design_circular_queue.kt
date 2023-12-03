internal class MyCircularQueue(k: Int) {
  private val q: IntArray
  private var front = 0
  private var size = 0
  private val capacity: Int

  init {
    q = IntArray(k)
    capacity = k
  }

  fun enQueue(value: Int): Boolean {
    if (isFull) {
      return false
    }
    val idx = (front + size) % capacity
    q[idx] = value
    ++size
    return true
  }

  fun deQueue(): Boolean {
    if (isEmpty) {
      return false
    }
    front = (front + 1) % capacity
    --size
    return true
  }

  fun Front(): Int {
    return if (isEmpty) {
      -1
    } else q[front]
  }

  fun Rear(): Int {
    if (isEmpty) {
      return -1
    }
    val idx = (front + size - 1) % capacity
    return q[idx]
  }

  val isEmpty: Boolean
    get() = size == 0
  val isFull: Boolean
    get() = size == capacity
}
