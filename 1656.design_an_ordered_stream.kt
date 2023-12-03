class OrderedStream(n: Int) {
  private val data: Array<String?>
  private var ptr = 0

  init {
    data = arrayOfNulls(n)
  }

  fun insert(idKey: Int, value: String?): List<String> {
    data[idKey - 1] = value
    val ans: List<String> = ArrayList()
    while (ptr < data.size && data[ptr] != null) {
      ans.add(data[ptr++])
    }
    return ans
  }
}
