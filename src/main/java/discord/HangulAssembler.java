package discord;

public class HangulAssembler {
    int first=0, middle=0, last=-1;


    public HangulAssembler setFirst(int first) {
        this.first = first;
        return this;
    }

    public HangulAssembler setLast(int last) {
        this.last = last;
        return this;
    }

    public HangulAssembler setMiddle(int middle) {
        this.middle = middle;
        return this;
    }
    public char build() {
        return ((char) (0xAC00 + first*(21*28) + middle*28 + last+1));
    }
}
