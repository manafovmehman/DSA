/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let max = -Infinity;
    let localMax = 0;

    for (const num of nums) {
        if (localMax < 0) {
            localMax = 0;
        }
        
        localMax += num;

        if (localMax > max) {
            max = localMax;
        }
    }

    return max;
};