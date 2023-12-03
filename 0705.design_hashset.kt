internal class MyHashSet {
  private val data = BooleanArray(1000001)
  fun add(key: Int) {
    data[key] = true
  }

  fun remove(key: Int) {
    data[key] = false
  }

  operator fun contains(key: Int): Boolean {
    return data[key]
  }
}
