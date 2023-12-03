class Solution {
  fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
    val cnt: Map<String, Int> = HashMap()
    val n = senders.size
    for (i in 0 until n) {
      var v = 1
      for (j in 0 until messages[i].length) {
        if (messages[i][j] == ' ') {
          ++v
        }
      }
      cnt.merge(senders[i], v) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = senders[0]
    for (e in cnt.entrySet()) {
      val sender: String = e.getKey()
      if (cnt[ans]!! < cnt[sender]!! || cnt[ans] === cnt[sender] && ans.compareTo(sender) < 0) {
        ans = sender
      }
    }
    return ans
  }
}
