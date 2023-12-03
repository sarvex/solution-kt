import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun sequenceReconstruction(nums: IntArray, sequences: List<List<Int?>>): Boolean {
    val n = nums.size
    val indeg = IntArray(n)
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (seq in sequences) {
      for (i in 1 until seq.size()) {
        val a = seq[i - 1] - 1
        val b = seq[i] - 1
        g[a].add(b)
        indeg[b]++
      }
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    while (!q.isEmpty()) {
      if (q.size() > 1) {
        return false
      }
      val i = q.poll()
      for (j in g[i]!!) {
        if (--indeg[j] == 0) {
          q.offer(j)
        }
      }
    }
    return true
  }
}
