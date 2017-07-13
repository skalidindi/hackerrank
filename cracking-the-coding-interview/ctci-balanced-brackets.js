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
  var t = parseInt(readLine());
  for(var a0 = 0; a0 < t; a0++){
    var expression = readLine();
    var stack = [];
    var pairs = {
      '{': '}',
      '[': ']',
      '(': ')'
    };

    var result = expression.split('').every(function(c) {
      if (c === '{' || c === '[' || c === '(') {
        stack.push(c);
      } else if (c === '}' || c === ']' || c === ')') {
        if (c === pairs[stack[stack.length - 1]]) {
          stack.pop();
        } else {
          return false;
        }
      } else {
        return false;
      }
      return true;
    });
    if (result && stack.length === 0) {
      console.log('YES');
    } else {
      console.log('NO');
    }
  }

}
