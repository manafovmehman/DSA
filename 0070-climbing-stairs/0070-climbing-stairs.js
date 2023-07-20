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
    
    const first = climbStairs(n - 1);
    const second = climbStairs(n - 2)
    
    dp.set(n - 1, first);

    dp.set(n - 2, second);
    
    return dp.get(n - 1) + dp.get(n - 2);
};