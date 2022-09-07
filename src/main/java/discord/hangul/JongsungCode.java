package discord.hangul;

public class JongsungCode extends HangulCode {
    public JongsungCode(int code) {
        super(code);
    }

    @Override
    protected String getKorSheet() {
        return "ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ";
    }

    @Override
    protected String[] getEngSheet() {
        return new String[]{"r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft", "fx", "fv", "fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g"};
    }
}
