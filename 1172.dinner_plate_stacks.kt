import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class DinnerPlates(private val capacity: Int) {
  private val stacks: List<Deque<Int>> = ArrayList()
  private val notFull: TreeSet<Int> = TreeSet()
  fun push(`val`: Int) {
    if (notFull.isEmpty()) {
      stacks.add(ArrayDeque())
      stacks[stacks.size() - 1].push(`val`)
      if (capacity > 1) {
        notFull.add(stacks.size() - 1)
      }
    } else {
      val index: Int = notFull.first()
      stacks[index].push(`val`)
      if (stacks[index].size() === capacity) {
        notFull.pollFirst()
      }
    }
  }

  fun pop(): Int {
    return popAtStack(stacks.size() - 1)
  }

  fun popAtStack(index: Int): Int {
    if (index < 0 || index >= stacks.size() || stacks[index].isEmpty()) {
      return -1
    }
    val `val` = stacks[index].pop()
    if (index == stacks.size() - 1 && stacks[stacks.size() - 1].isEmpty()) {
      while (!stacks.isEmpty() && stacks[stacks.size() - 1].isEmpty()) {
        notFull.remove(stacks.size() - 1)
        stacks.remove(stacks.size() - 1)
      }
    } else {
      notFull.add(index)
    }
    return `val`
  }
}
