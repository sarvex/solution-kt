import java.util.*

internal open class Node {
  @JvmField
  var `val` = 0
  var prev: Node? = null
  var next: Node? = null

  constructor()
  constructor(`val`: Int) {
    this.`val` = `val`
  }
}

internal class DoubleLinkedList {
  private val head = Node()
  private val tail = Node()

  init {
    head.next = tail
    tail.prev = head
  }

  fun append(`val`: Int): Node {
    val node = Node(`val`)
    node.next = tail
    node.prev = tail.prev
    tail.prev = node
    node.prev!!.next = node
    return node
  }

  fun pop(): Node? {
    return remove(tail.prev)
  }

  fun peek(): Int {
    return tail.prev!!.`val`
  }

  companion object {
    fun remove(node: Node?): Node? {
      node!!.prev!!.next = node.next
      node.next!!.prev = node.prev
      return node
    }
  }
}

internal class MaxStack {
  private val stk = DoubleLinkedList()
  private val tm: TreeMap<Int, List<Node>> = TreeMap()
  fun push(x: Int) {
    val node = stk.append(x)
    tm.computeIfAbsent(x) { k -> ArrayList() }.add(node)
  }

  fun pop(): Int {
    val node = stk.pop()
    val nodes = tm[node!!.`val`]!!
    val x: Int = nodes.remove(nodes.size() - 1).`val`
    if (nodes.isEmpty()) {
      tm.remove(node.`val`)
    }
    return x
  }

  fun top(): Int {
    return stk.peek()
  }

  fun peekMax(): Int {
    return tm.lastKey()
  }

  fun popMax(): Int {
    val x = peekMax()
    val nodes = tm[x]!!
    val node: Node = nodes.remove(nodes.size() - 1)
    if (nodes.isEmpty()) {
      tm.remove(x)
    }
    DoubleLinkedList.remove(node)
    return x
  }
}
