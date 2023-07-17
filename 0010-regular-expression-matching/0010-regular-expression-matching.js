/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    return regex(s, p, 0, 0);
};

let regex = function(s, p, i, j) {
    if (j === p.length) {
        return i === s.length;
    }
    const firstMatch = i < s.length && (s[i] === p[j] || p[j] === '.');
    if (j < p.length - 1 && p[j + 1] === '*') {
        return regex(s, p, i, j + 2) || (firstMatch && regex(s, p, i + 1, j));
    } else {
        return firstMatch && regex(s, p, i + 1, j + 1);
    }
};