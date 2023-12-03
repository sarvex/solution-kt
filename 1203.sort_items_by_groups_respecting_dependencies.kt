import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
    var idx = m
    val groupItems: Array<List<Int>?> = arrayOfNulls(n + m)
    val itemDegree = IntArray(n)
    val groupDegree = IntArray(n + m)
    val itemGraph: Array<List<Int>?> = arrayOfNulls(n)
    val groupGraph: Array<List<Int>?> = arrayOfNulls(n + m)
    Arrays.setAll(groupItems) { k -> ArrayList() }
    Arrays.setAll(itemGraph) { k -> ArrayList() }
    Arrays.setAll(groupGraph) { k -> ArrayList() }
    for (i in 0 until n) {
      if (group[i] == -1) {
        group[i] = idx++
      }
      groupItems[group[i]].add(i)
    }
    for (i in 0 until n) {
      for (j in beforeItems[i]) {
        if (group[i] == group[j]) {
          ++itemDegree[i]
          itemGraph[j].add(i)
        } else {
          ++groupDegree[group[i]]
          groupGraph[group[j]].add(group[i])
        }
      }
    }
    var items: List<Int>? = ArrayList()
    for (i in 0 until n + m) {
      items.add(i)
    }
    val groupOrder = topoSort(groupDegree, groupGraph, items)
    if (groupOrder.isEmpty()) {
      return IntArray(0)
    }
    val ans: List<Int> = ArrayList()
    for (gi in groupOrder) {
      items = groupItems[gi]
      val itemOrder = topoSort(itemDegree, itemGraph, items)
      if (itemOrder.size() !== items!!.size()) {
        return IntArray(0)
      }
      ans.addAll(itemOrder)
    }
    return ans.stream().mapToInt(Integer::intValue).toArray()
  }

  private fun topoSort(degree: IntArray, graph: Array<List<Int>?>, items: List<Int>?): List<Int> {
    val q: Deque<Int> = ArrayDeque()
    for (i in items!!) {
      if (degree[i] == 0) {
        q.offer(i)
      }
    }
    val ans: List<Int> = ArrayList()
    while (!q.isEmpty()) {
      val i = q.poll()
      ans.add(i)
      for (j in graph[i]!!) {
        if (--degree[j] == 0) {
          q.offer(j)
        }
      }
    }
    return if (ans.size() === items.size()) ans else List.of()
  }
}
