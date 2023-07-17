/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let rev = 0;
    const INT_MAX = 2147483647;
    const INT_MIN = -2147483648;
    while (x !== 0) {
        const pop = x % 10;
        x = parseInt(x / 10);
        if ( rev > INT_MAX / 10) {
            return 0;
        }
        
        if (rev < INT_MIN / 10) {
            return 0;
        }
        rev = rev * 10 + pop;
    }
    
    return rev;
};