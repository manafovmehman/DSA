/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function(s) {
    let index = 0;
    const n = s.length;
    let result = 0;
    let sign = 1;
    const INT_MAX = Math.pow(2, 31) - 1;
    const INT_MIN = -Math.pow(2, 31);
    
    while (index < n && s[index] === ' ') {
        index++;
    }
    
    if (index < n && s[index] === '+') {
        index++;
    } else if (index < n && s[index] === '-') {
        sign = -1;
        index++;
    }
    
    while (index < n && /\d/.test(s[index])) {
        let digit = parseInt(s[index]);
        if (result > Math.floor(INT_MAX / 10) || (result === Math.floor(INT_MAX / 10) && digit > 7)) {
            return sign === 1 ? INT_MAX : INT_MIN;
        }
        result = result * 10 + digit;
        index++;
    }
    
    return sign * result;
};