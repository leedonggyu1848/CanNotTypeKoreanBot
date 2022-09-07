package discord;

public class StringManager {
    private int cur;
    private final String str;

    public StringManager(String str) {
        this.str = str;
        cur = 0;
    }

    public char next() {
        if (isOutOfRange())
            return 0;
        return str.charAt(cur++);
    }

    public char peek() {
        if (isOutOfRange())
            return 0;
        return str.charAt(cur);
    }

    public char peekNext() {
        cur++;
        if (isOutOfRange()) {
            cur--;
            return 0;
        }
        return str.charAt(cur--);
    }

    public void back() {
        cur--;
        if (isOutOfRange()) cur++;
    }

    public boolean isOutOfRange() {
        return str.length() <= cur || cur < 0;
    }
}
