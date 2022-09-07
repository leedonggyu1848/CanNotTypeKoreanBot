package discord.hangul;

public class ChosungCode extends HangulCode{

    public ChosungCode(int code) {
        super(code);
    }

    @Override
    protected String getKorSheet() {
        return "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ";
    }

    @Override
    protected String[] getEngSheet() {
        return new String[]{"r", "R", "s","e","E","f","a","q","Q","t","T","d","w","W","c","z","x","v","g"};
    }

}
