internal class MyHashMap {
  private val data = IntArray(1000001)

  init {
    Arrays.fill(data, -1)
  }

  fun put(key: Int, value: Int) {
    data[key] = value
  }

  operator fun get(key: Int): Int {
    return data[key]
  }

  fun remove(key: Int) {
    data[key] = -1
  }
}
