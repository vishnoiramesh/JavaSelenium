package ramesh.coreJava.practice.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
	public static void main(String args[]) {
		// String to be scanned to find the pattern.
		String matcherLine = "This order was places for QT3000! OK?";
		String patternLine = "(.*)(\\d+)(.*)";
		// Create a Pattern object
		Pattern pattern = Pattern.compile(patternLine);
		// Now create matcher object.
		Matcher matcher = pattern.matcher(matcherLine);
		if (matcher.find()) {
			System.out.println("Found value: " + matcher.group(0));
			System.out.println("Found value: " + matcher.group(1));
			System.out.println("Found value: " + matcher.group(2));
		} else {
			System.out.println("NO MATCH");
		}
	}

}
