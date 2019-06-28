package noteextract.pro.qu_la;

import noteextract.core.NoteSpider;

public class QuLaNoteSpider extends NoteSpider {

    @Override
    public String chapterListUrl() {
        return "https://www.qu.la/book/3137/";
    }

    protected String noteHeadLine() {
        return "div.box_con div#maininfo div#info h1";
    }

    @Override
    public String chapterExtractPattern() {
        return "div#content";
    }

    @Override
    public String chapterListExtractPattern() {
        return "div.box_con div#list dl dd a";
    }

    @Override
    protected String chapterHandler(String originalContent) {
        return originalContent.replace("&nbsp;", "").replace("<br>", "");
    }
}
