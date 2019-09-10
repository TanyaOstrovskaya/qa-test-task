package utils;

import java.util.Random;

public class Util {

    public static final int MIN_WAIT_IN_SECONDS = 10;
    public static final int MAX_WAIT_IN_SECONDS = 30;
    public static final String TWITTER_IMAGE_SVG_PATH_CODE = "M14.2 3.2v.42A9.23 9.23 0 0" +
            " 1-.01 11.39a6.66 6.66 0 0 0 .78 0 6.5 6.5 0 0 0 4-1.38 3.25 3.25 0 0 1-3-2.25" +
            " 4.21 4.21 0 0 0 .61 0 3.42 3.42 0 0 0 .85-.11 3.24 3.24 0 0 1-2.6-3.18 3.27 3.27" +
            " 0 0 0 1.47.41 3.25 3.25 0 0 1-1-4.34 9.22 9.22 0 0 0 6.69 3.39 3.66 3.66 0 0 1-.08-." +
            "74A3.25 3.25 0 0 1 13.32.97a6.39 6.39 0 0 0 2.06-.78 3.23 3.23 0 0 1-1.43 1.79 6.5 6.5 0" +
            " 0 0 1.87-.5A7 7 0 0 1 14.2 3.2z";
    public static final String TWITTER_ICON_CONTENT_HREF = "/content/themes/wrike" +
            "/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter";
    public static final String TWITTER_WRIKE_LINK = "https://twitter.com/wrike";

    public static String generateRandomWrikeTestEmail(){
        // TODO: write norm random method
        return "abcdef+wpt@wriketask.qaa";
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
