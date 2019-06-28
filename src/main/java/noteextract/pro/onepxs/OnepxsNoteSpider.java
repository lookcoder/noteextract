package noteextract.pro.onepxs;

import noteextract.core.NoteSpider;

public class OnepxsNoteSpider extends NoteSpider {

    @Override
    public String chapterListUrl() {
        return "http://www.1pxs.com/read/43/43209/";
    }

    protected String noteHeadLine() {
        return "div.quanwen div.book_info div.xiaoshuo h1";
    }

    @Override
    public String chapterExtractPattern() {
        return "div.yuedu_zhengwen";
    }

    @Override
    public String chapterListExtractPattern() {
        return "div.novel_list dl.book_article_listtext dd a";
    }

    @Override
    protected String chapterHandler(String originalContent) {
        return originalContent.replace("&nbsp;", "").replace("<br>", "");
    }
}
