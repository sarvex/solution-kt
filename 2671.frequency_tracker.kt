class FrequencyTracker {
  private val cnt: Map<Int, Int> = HashMap()
  private val freq: Map<Int, Int> = HashMap()
  fun add(number: Int) {
    val f = cnt[number] ?: 0
    if (freq[f] ?: 0 > 0) {
      freq.merge(f, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    cnt.merge(number, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    freq.merge(f + 1, 1) { a: Int, b: Int -> Integer.sum(a, b) }
  }

  fun deleteOne(number: Int) {
    val f = cnt[number] ?: 0
    if (f == 0) {
      return
    }
    freq.merge(f, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    cnt.merge(number, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    freq.merge(f - 1, 1) { a: Int, b: Int -> Integer.sum(a, b) }
  }

  fun hasFrequency(frequency: Int): Boolean {
    return freq[frequency] ?: 0 > 0
  }
}
