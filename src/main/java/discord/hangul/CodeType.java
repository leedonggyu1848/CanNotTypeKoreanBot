package discord.hangul;

public enum CodeType {
    CHOSUNG(0), JUNGSUNG(1), JONGSUNG(2);
    private final int value;
    CodeType(int value) {this.value = value;}
    public int getValue() {return value;}
}
