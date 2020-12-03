fs = require('fs');
os = require('os');

fs.readFile('input.txt', function (err,data) {
    if (err) {
        throw err;
    }

    var rulesFollowed = 0;
    var lines = data.toString().split("\n");
    var rules = lines.forEach(ruleString => {
        var split = ruleString.split(" ");
        if(split.length < 3) return;

        var letter = split[1].charAt(0);

        var positionStr = split[0].split("-");
        var pos1 = parseInt(positionStr[0]) - 1;
        var pos2 = parseInt(positionStr[1]) - 1;
        var passwordGiven = split[2];

        var isCharAtPos1 = passwordGiven.charAt(pos1) == letter;
        var isCharAtPos2 = passwordGiven.charAt(pos2) == letter;

        if ((isCharAtPos1 || isCharAtPos2) && !(isCharAtPos1 && isCharAtPos2)) {
            rulesFollowed++;
        }
    });

    console.log(rulesFollowed);
});