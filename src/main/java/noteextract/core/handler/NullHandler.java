package noteextract.core.handler;

import java.util.Map;

public class NullHandler implements ResultHandler {

    public void handlerChapter(String headline, String title, String url, String content) {
        System.out.print(headline);
        System.out.print(title);
        System.out.print(url);
        System.out.println(content);
    }

    public void handler(String headline, Map<String, String> chapterList, Map<String, String> chapterContentList) {
        System.out.print(headline);
        for (Map.Entry<String, String> chapter : chapterList.entrySet()) {
            System.out.println(chapter.getKey());
            System.out.println(chapter.getValue());
        }
    }
}
