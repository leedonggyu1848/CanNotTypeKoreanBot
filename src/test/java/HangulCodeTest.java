import discord.StringManager;
import discord.hangul.ChosungCode;
import discord.hangul.CodeType;
import discord.hangul.HangulBuilder;
import discord.hangul.HangulCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HangulCodeTest {
    @Test
    public void singleHangulTest() {
        HangulCode code1 = new HangulBuilder(CodeType.CHOSUNG, new StringManager("a")).build();
        HangulCode code2 = new HangulBuilder(CodeType.CHOSUNG, new StringManager("p")).build();
        HangulCode code3 = new HangulBuilder(CodeType.JUNGSUNG, new StringManager("p")).build();
        HangulCode code4 = new HangulBuilder(CodeType.JUNGSUNG, new StringManager("a")).build();
        HangulCode code5 = new HangulBuilder(CodeType.JONGSUNG, new StringManager("qt")).build();
        assertEquals('ㅁ', code1.toSingleHangul());
        assertNull(code2);
        assertEquals('ㅔ', code3.toSingleHangul());
        assertNull(code4);
        assertEquals('ㅄ', code5.toSingleHangul());
    }
}
