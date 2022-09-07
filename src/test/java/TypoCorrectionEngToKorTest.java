import discord.TypoCorrectionEngToKor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TypoCorrectionEngToKorTest {
    @Test
    public void translateNormalTest() {
        assertEquals("ㅁㄴㅇㄹ", new TypoCorrectionEngToKor("asdf").translate());
        assertEquals("동해물과 백두산이", new TypoCorrectionEngToKor("ehdgoanfrhk qorentksdl").translate());
        assertEquals("", new TypoCorrectionEngToKor("").translate());
    }

    @Test
    public void translateSpecialTest() {
        assertEquals("이것 ! 저것 @ #$%^&*()_+-=", new TypoCorrectionEngToKor("dlrjt ! wjrjt @ #$%^&*()_+-=").translate());
    }
}
