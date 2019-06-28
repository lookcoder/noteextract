package noteextract.core;

import noteextract.core.handler.NullHandler;
import noteextract.core.handler.ResultHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public abstract class NoteSpider {

    public void execute() {
        execute(new NullHandler());
    }

    public void execute(ResultHandler handler) {
        Map<String, String> chapterList = new HashMap<String, String>();
        Map<String, String> chapterContent = new HashMap<String, String>();
        String mainUrl = chapterListUrl();
        if (mainUrl == null || "".equals(mainUrl)) {
            return;
        }
        String headline = "";
        try {
            final Document chapterListDocument = Jsoup.connect(chapterListUrl()).get();
            headline = chapterListDocument.select(noteHeadLine()).text();
            final Elements chapterListElements = chapterListDocument.select(chapterListExtractPattern());
            for (Element chapterListElement : chapterListElements) {
                final String url = chapterListElement.attr("href");
                final String title = chapterListElement.text();
                chapterList.put(url, title);
                final Document chapterDocument = Jsoup.connect(getNextUrl(url)).get();
                final Elements chapterElements = chapterDocument.select(chapterExtractPattern());
                for (Element chapterElement : chapterElements) {
                    final String content = chapterHandler(chapterElement.html());
                    chapterContent.put(url, content);
                    handler.handlerChapter(clearSpace(headline), title, url, content);
                }
            }
        } catch (Exception e) {
            System.out.println("Jsoup run is error!");
        } finally {
            handler.handler(clearSpace(headline), chapterList, chapterContent);
        }
    }



    private String getNextUrl(String url){
        if (chapterListUrl().startsWith("/")) {
            return chapterListUrl() + url;
        }
        return chapterListUrl() + "/" + url;
    }

    private String clearSpace(String str) {
        return str == null ? "UNKNOWN" : str.trim();
    }

    protected abstract String chapterListUrl();

    protected abstract String noteHeadLine();

    protected abstract String chapterExtractPattern();

    protected abstract String chapterListExtractPattern();

    protected abstract String chapterHandler(String originalContent);
}




