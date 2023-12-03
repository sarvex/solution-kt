internal class Solution {
  fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
    for (row in image) {
      var i = 0
      var j = row.size - 1
      while (i < j) {
        if (row[i] == row[j]) {
          row[i] = row[i] xor 1
          row[j] = row[j] xor 1
        }
        ++i
        --j
      }
      if (i == j) {
        row[i] = row[i] xor 1
      }
    }
    return image
  }
}
