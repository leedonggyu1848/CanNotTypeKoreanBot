package discord.hangul;

public class JungsungCode extends HangulCode {
    public JungsungCode(int code) {
        super(code);
    }

    @Override
    protected String getKorSheet() {
        return "ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ";
    }

    @Override
    protected String[] getEngSheet() {
        return new String[] {"k", "o", "i", "O", "j", "p", "u", "P", "h", "hk", "ho", "hl", "y", "n", "nj", "np", "nl", "b", "m", "ml", "l"};
    }
}
