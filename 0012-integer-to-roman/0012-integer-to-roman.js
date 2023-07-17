/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    const symbols = ['M', 'CM', 'D', 'CD','C', 'XC', 'L', 'XL','X', 'IX', 'V', 'IV', 'I'];
    const values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
    const roman = [];
    for (let i = 0; i < symbols.length; i++) {
        const temp = parseInt(num / values[i]);
        if (temp >= 1 && num !== 0) {
            roman.push(symbols[i].repeat(temp));
            num = num % values[i];
        }
    }
    return roman.join('');
};