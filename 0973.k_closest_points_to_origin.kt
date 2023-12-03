class Solution {
  fun kClosest(points: Array<IntArray?>?, k: Int): Array<IntArray> {
    Arrays.sort(points) { a, b ->
      val d1: Int = a.get(0) * a.get(0) + a.get(1) * a.get(1)
      val d2: Int = b.get(0) * b.get(0) + b.get(1) * b.get(1)
      d1 - d2
    }
    return Arrays.copyOfRange(points, 0, k)
  }
}
