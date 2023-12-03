import java.util.*

internal class Solution {
  fun minMutation(start: String?, end: String, bank: Array<String?>): Int {
    val s: Set<String> = HashSet()
    for (b in bank) {
      s.add(b)
    }
    val mp: Map<Char, String> = HashMap(4)
    mp.put('A', "TCG")
    mp.put('T', "ACG")
    mp.put('C', "ATG")
    mp.put('G', "ATC")
    val q: Deque<Pair<String, Int>> = LinkedList()
    q.offer(Pair(start, 0))
    while (!q.isEmpty()) {
      val p: Pair<String, Int> = q.poll()
      val t: String = p.getKey()
      val step: Int = p.getValue()
      if (end == t) {
        return step
      }
      for (i in 0 until t.length) {
        for (c in mp[t[i]]!!.toCharArray()) {
          val next = t.substring(0, i) + c + t.substring(i + 1)
          if (s.contains(next)) {
            q.offer(Pair(next, step + 1))
            s.remove(next)
          }
        }
      }
    }
    return -1
  }
}
