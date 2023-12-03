class Solution {
  fun kidsWithCandies(extraCandies: Int): vector<bool> {
    var mx: Int
    max_element(candies.begin(), candies.end())
    var res: vector<bool>
    for (candy in candies) {
      res.push_back(candy + extraCandies >= mx)
    }
    return res
  }
}
