package utils;

import java.security.SecureRandom;
import java.util.Random;

public class Util {
    private static final String WRIKE_EMAIL_SUFFIX = "+wpt@wriketask.qaa";
    public static final int MAX_WAIT_IN_SECONDS = 20;
    public static final String TWITTER_WRIKE_LINK = "https://twitter.com/wrike";
    public static final String TWITTER_ICON_CONTENT_HREF = "/content/themes/wrike" +
            "/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter";

    public static String generateRandomWrikeTestEmail(){
        return generateRandomAlphabeticalString(8) + WRIKE_EMAIL_SUFFIX;
    }

    public static String generateRandomAlphabeticalString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        var chars = "abcdefghijklmnopqrstuvwxyz";
        var random = new SecureRandom();
        var sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            var randomCharAt = random.nextInt(chars.length());
            var randomChar = chars.charAt(randomCharAt);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public enum TwoQuestionOptions {
        Option1,
        Option2;
        private static final TwoQuestionOptions[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static TwoQuestionOptions getRandomOption()  {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

    public enum ThreeQuestionOptions {
        Option1,
        Option2,
        Option3;
        private static final ThreeQuestionOptions[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static ThreeQuestionOptions getRandomOption()  {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

    public enum FiveQuestionOptions {
        Option1,
        Option2,
        Option3,
        Option4,
        Option5;
        private static final FiveQuestionOptions[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static FiveQuestionOptions getRandomOption()  {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }
}
