/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if (x < 0 || (x % 10 === 0 && x !== 0)) {
        return false;
    }
    
    let reversedInteger = 0;
    while (x > reversedInteger) {
        const pop = x % 10;
        x = parseInt(x / 10);
        reversedInteger = reversedInteger * 10 + pop;
    }
    
    return reversedInteger === x || parseInt(reversedInteger / 10) === x;
};