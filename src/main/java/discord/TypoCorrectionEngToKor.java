package discord;

import discord.hangul.CodeType;
import discord.hangul.HangulBuilder;
import discord.hangul.HangulCode;

public class TypoCorrectionEngToKor {
    StringManager str;

    public TypoCorrectionEngToKor(String eng) {
        str = new StringManager(eng);
    }

    public String translate() {
        StringBuilder sb = new StringBuilder();
        while (!str.isOutOfRange())
            sb.append(getNextChar());
        return sb.toString();
    }

    private char getNextChar() {
        char tar = str.peek();
        if (!Character.isAlphabetic(tar))
            return str.next();
        return getNextHangul();
    }

    private char getNextHangul() {
        HangulCode first, middle, last;
        HangulCode next;
        middle = new HangulBuilder(CodeType.JUNGSUNG, str).build();
        // When there is one 중성
        if (middle != null) return middle.toSingleHangul();
        first = new HangulBuilder(CodeType.CHOSUNG, str).build();
        // when there is one 종성
        if (first == null) {
            last = new HangulBuilder(CodeType.JONGSUNG, str).build();
            return last == null ? str.next() : last.toSingleHangul();
        }

        middle = new HangulBuilder(CodeType.JUNGSUNG, str).build();
        // when there is one 초성
        if (middle == null) return first.toSingleHangul();
        last = new HangulBuilder(CodeType.JONGSUNG, str).build();
        // when there are 초성 + 중성
        if (last == null) return new HangulAssembler().setFirst(first.getCode()).setMiddle(middle.getCode()).build();
        // when there are 초성 + 중성 + 종성 + 중성 so 초성 + 중성
        next = new HangulBuilder(CodeType.JUNGSUNG, str).build();
        if (next != null) {
            // 종성이이 next한 수 + 중성이 next한 수 만큼 back
            // 종성이 자음 2개로 이루어져있으면 하나는 받침 하나는 다음 글자로 간다.
            for (int i = 0; i < last.countCode() + next.countCode(); i++)
                str.back();
            if (last.countCode() == 2) {
                last = new HangulBuilder(CodeType.JONGSUNG, str).onlySingle().build();
                return new HangulAssembler().setFirst(first.getCode()).setMiddle(middle.getCode()).setLast(last.getCode()).build();
            }
            return new HangulAssembler().setFirst(first.getCode()).setMiddle(middle.getCode()).build();
        }
        // when there are 초성 + 중성 + 종성
        return new HangulAssembler().setFirst(first.getCode()).setMiddle(middle.getCode()).setLast(last.getCode()).build();
    }
}
