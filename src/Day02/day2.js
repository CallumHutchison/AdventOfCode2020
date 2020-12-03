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

        var occurencesStr = split[0].split("-");
        var minOccurrences = parseInt(occurencesStr[0]);
        var maxOccurrences = parseInt(occurencesStr[1]);
        var passwordGiven = split[2];
        var letterOccurences = (passwordGiven.match(new RegExp(letter, "g")) || []).length

        if (letterOccurences >= minOccurrences && letterOccurences <= maxOccurrences) {
            rulesFollowed++;
        }
    });

    console.log(rulesFollowed);
});