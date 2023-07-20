/**
 * @param {number} n
 * @return {number}
 */
const dp = new Map();

var climbStairs = function(n) {
    if (dp.has(n)) {
        return dp.get(n);
    }
    
    if (n === 0) {
        return 1;
    }

    if (n <= 0) {
        return 0;
    }

    dp.set(n, climbStairs(n - 1) + climbStairs(n - 2));
    
    return dp.get(n);
};