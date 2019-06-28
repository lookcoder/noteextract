import noteextract.pro.qu_la.QuLaNoteSpider;
import org.junit.Test;

public class NoteExtractTest {

    @Test
    public void test() {
//        OnepxsNoteSpider ns = new OnepxsNoteSpider();
        QuLaNoteSpider ns = new QuLaNoteSpider();

        ns.execute();
    }
}
