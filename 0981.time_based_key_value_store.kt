import java.util.*

class TimeMap {
  private val ktv: Map<String, TreeMap<Int, String>> = HashMap()
  operator fun set(key: String?, value: String?, timestamp: Int) {
    ktv.computeIfAbsent(key) { k -> TreeMap() }.put(timestamp, value)
  }

  operator fun get(key: String, timestamp: Int): String {
    if (!ktv.containsKey(key)) {
      return ""
    }
    val tv: Unit = ktv[key]
    val t: Int = tv.floorKey(timestamp)
    return if (t == null) "" else tv.get(t)
  }
}
