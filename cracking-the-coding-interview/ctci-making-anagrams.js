process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function main() {
    var a = readLine();
    var b = readLine();

    var aMap = {};
    var bMap = {};
    a.split('').forEach(function(c) {
        aMap[c] = aMap[c] ? aMap[c] + 1 : 1;
    });
    b.split('').forEach(function(c) {
        bMap[c] = bMap[c] ? bMap[c] + 1 : 1;
    });

    var count = 0;
    for (key in aMap) {
        var val1 = aMap[key] ? aMap[key] : 0;
        var val2 = bMap[key] ? bMap[key] : 0;
        count += Math.abs(val1 - val2);
        delete aMap[key];
        delete bMap[key];
    }
    for (key in bMap) {
        var val1 = aMap[key] ? aMap[key] : 0;
        var val2 = bMap[key] ? bMap[key] : 0;
        count += Math.abs(val1 - val2);
    }
    console.log(count);
}
