class Solution {
  fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
    val v = length.toLong() * width * height
    val bulky = if (length >= 10000 || width >= 10000 || height >= 10000 || v >= 1000000000) 1 else 0
    val heavy = if (mass >= 100) 1 else 0
    val d = arrayOf("Neither", "Bulky", "Heavy", "Both")
    val i = heavy shl 1 or bulky
    return d[i]
  }
}
