class DataStream(private val `val`: Int, private val k: Int) {
  private var cnt = 0
  fun consec(num: Int): Boolean {
    cnt = if (num == `val`) cnt + 1 else 0
    return cnt >= k
  }
}
