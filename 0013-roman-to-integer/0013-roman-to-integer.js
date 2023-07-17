/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    const map = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000,
    };
    
    let result = 0;
    let index = 0;
    let n = s.length;
    
    while (index < n) {
        if ((index !== n - 1 && map[s[index]] >= map[s[index + 1]]) || index === n - 1) {
            result += map[s[index]];
            index++;
        } else {
            result += (map[s[index + 1]] - map[s[index]]);
            index += 2;
        }
    }
    
    return result;
};