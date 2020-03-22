package ua.lviv.iot.lab6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

    public String runPatterns(String textCheckDate) {

        String result = "";

        Pattern patternOfDate = Pattern.compile("\\b(0?[1-9]|[12]\\d|3[01])\\/((0?[13-9])|(1[012]))\\/\\d+\\b");
        Matcher matcher = patternOfDate.matcher(textCheckDate);
        while (matcher.find()) {
            result += matcher.group();
        }

        Pattern patternOfFebruary = Pattern.compile("\\b(0?[1-9]|[12]\\d)\\/2\\/\\d+\\b");
        Matcher matcherOfFebruary = patternOfFebruary.matcher(textCheckDate);

        while (matcherOfFebruary.find()) {
            Pattern patternOfFebruaryIntercalary = Pattern.compile(
                    "\\b29\\/2\\/(((([13579][01345789])|([02468][1235679]))00)|(\\d*(([02468][1235679])|([13579][01345789]))))\\b");
            Matcher matcherOfFebruaryIntercalary = patternOfFebruaryIntercalary.matcher(matcherOfFebruary.group());
            if (matcherOfFebruaryIntercalary.find() == false) {
                result += matcherOfFebruary.group();
            }
        }
        return result;
    }
}
