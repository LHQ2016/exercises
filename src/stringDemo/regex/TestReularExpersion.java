package stringDemo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReularExpersion {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uasge:\njava TestRegularExpersion " + "characterSequence regurlarExpersion");
            System.exit(0);
        }
        System.out.print("Input:<" + args[0] + ">");
        for (String arg :
                args) {
            System.out.println("Regular expersion:<"+arg+">");
            Pattern pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher(args[0]);
            while (matcher.find())
            {
                System.out.println("Match :<"+matcher.group()+"> at Positions "+
                                    matcher.start()+"-"+matcher.end());
            }
        }

    }
}
