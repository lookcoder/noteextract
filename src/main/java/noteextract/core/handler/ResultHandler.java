package noteextract.core.handler;

import java.util.Map;

public interface ResultHandler {
    void handlerChapter(String headline, String title, String url, String content);

    void handler(String headline, Map<String, String> chapterList, Map<String, String> chapterContentList);
}
