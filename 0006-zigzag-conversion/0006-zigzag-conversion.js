/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if (numRows === 1) {
        return s;
    }
    const rows = [];
    for (let i = 0; i < Math.min(numRows, s.length); i++) {
        rows.push([]);
    }
    
    let curRow = 0;
    let goingDown = false;
    for (let i = 0; i < s.length; i++) {
        rows[curRow].push(s[i]);
        if (curRow === 0 || curRow === numRows - 1) {
            goingDown = !goingDown;
        }
        curRow += goingDown ? 1 : -1;
    }

    return rows.reduce((result, row) => {
        return result = result + '' + row.join('');
    }, '');
};