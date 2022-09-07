package discord.hangul;

import discord.StringManager;

public class HangulBuilder {
    private int code;
    private final CodeType type;
    private final String[][] sheet = {
            {"r", "R", "s","e","E","f","a","q","Q","t","T","d","w","W","c","z","x","v","g"},
            {"k", "o", "i", "O", "j", "p", "u", "P", "h", "hk", "ho", "hl", "y", "n", "nj", "np", "nl", "b", "m", "ml", "l"},
            {"r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft", "fx", "fv", "fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g"}
    };
    private final StringManager str;
    private boolean flag;

    private int getSingleCode() {
        String tar = String.valueOf(str.peek());
        String[] curSheet = sheet[type.getValue()];
        for (int i=0; i < curSheet.length; ++i) {
            if (curSheet[i].equals(tar)) {
                str.next();
                return i;
            }
        }
        return -1;
    }

    private int getDoubleCode() {
        if (type.equals(CodeType.CHOSUNG) || !Character.isAlphabetic(str.peekNext()))
            return -1;
        String tar = new String(new char[]{str.peek(), str.peekNext()});
        String[] curSheet = sheet[type.getValue()];
        for (int i=0; i < curSheet.length; ++i) {
            if (curSheet[i].equals(tar)) {
                str.next();
                str.next();
                return i;
            }
        }
        return -1;
    }

    public HangulBuilder(CodeType type, StringManager str) {
        this.str = str;
        code = -1;
        flag = true;
        this.type = type;

    }

    public HangulBuilder onlySingle() {
        flag = false;
        switch (type) {
            case JUNGSUNG, JONGSUNG -> {
                code = getSingleCode();
            }
        }
        return this;
    }

    public HangulCode build() {
        if (flag) {
            switch (type) {
                case CHOSUNG -> {
                    code = getSingleCode();
                }
                case JUNGSUNG, JONGSUNG -> {
                    code = getDoubleCode();
                    if (code == -1)
                        code = getSingleCode();
                }
            }
        }

        if (code == -1)
            return null;
        switch (type) {
            case CHOSUNG -> {
                return new ChosungCode(code);
            }
            case JUNGSUNG -> {
                return new JungsungCode(code);
            }
            case JONGSUNG -> {
                return new JongsungCode(code);
            }
        }
        return null;
    }
}
