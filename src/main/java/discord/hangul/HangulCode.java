package discord.hangul;

public abstract class HangulCode {
    private final int code;

    public HangulCode(int code) {
        this.code = code;
    }

    public boolean isValid() {
        String sheet = getKorSheet();
        return code >= 0 && sheet.length() > code;
    }

    public char toSingleHangul() {
        String sheet = getKorSheet();
        if (!isValid())
            return 0;
        return sheet.charAt(code);
    }

    abstract protected String getKorSheet();
    abstract protected String[] getEngSheet();
    public int countCode() {
        if (!isValid())
            return -1;
        return getEngSheet()[getCode()].length();
    }

    public int getCode() {
        return code;
    }
}
