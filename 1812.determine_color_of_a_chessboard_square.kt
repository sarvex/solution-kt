class Solution {
  fun squareIsWhite(coordinates: String): Boolean {
    return (coordinates[0].code + coordinates[1].code) % 2 == 1
  }
}
