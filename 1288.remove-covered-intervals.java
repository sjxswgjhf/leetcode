/*
 * @lc app=leetcode id=1288 lang=java
 *
 * [1288] Remove Covered Intervals
 */

// @lc code=start
/*
Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.

Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li <= ri <= 10^5
All the given intervals are unique.


[1,5][2,3],[3,4]
[1,5][3,4]
[1,5]

[1,5][2,4][4,6]
[1,5][4,6]
[1,5],[4,6]

[[1,4],[2,3]]

[[1,2],[1,4],[3,4]]

Key Idea: Sort array 1st element increasing and 2nd element decreasing.
Then we can loop it and update left and right boundary accordingly.
if rightBoundary cover next[0], then check next[1]
if not cover, we increase count and update left boundary and right boundary,
if cover, contiue
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int res = 1;
        int leftBoundary = intervals[0][0];
        int rightBoundary = intervals[0][1];
        for(int i = 1;i < intervals.length; i++){
            if(rightBoundary >= intervals[i][0]){
                if(rightBoundary < intervals[i][1]){
                    leftBoundary = intervals[i][0];
                    rightBoundary = intervals[i][1];
                    res++;
                }
            }else{
                res++;
            }
        }
        return res;      
    }
}
// @lc code=end

