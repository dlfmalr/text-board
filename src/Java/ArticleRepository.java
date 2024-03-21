package Java;

import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article> articlelist = new ArrayList<>();
    CommonUtil commonUtil = new CommonUtil();
    int latestArticleId = 4;

    public ArticleRepository() {
        makeTestData();
    }

    public void makeTestData() {
        Article a1 = new Article(1, "안녕하세요. 반갑습니다. 자바 공부중에요.", "냉무", 0, commonUtil.getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문 좀 할게요.", "냉무", 0, commonUtil.getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야하나요?", "냉무", 0, commonUtil.getCurrentDateTime());
        articlelist.add(a1);
        articlelist.add(a2);
        articlelist.add(a3);
    }
    public ArrayList<Article> findArticleByKeyword(String keyword) {
        ArrayList<Article> searchedList = new ArrayList<>();
        for (int i = 0; i < articlelist.size(); i++) {
            Article article = articlelist.get(i);
            if (article.getTitle().contains(keyword)) {
                searchedList.add(article);
            }
        }
        return searchedList;
    }

    public Article findArticleById(int id) {
        for (int i = 0; i < articlelist.size(); i++) {
            Article article = articlelist.get(i);
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public void deleteArticle(Article article) {
        articlelist.remove(article);
    }

    public void updateArticle(Article article, String newTitle, String newBody) {
        article.setTitle(newTitle);
        article.setBody(newBody);
    }
    public ArrayList<Article> findAll() {
        return articlelist;
    }
    public Article saveArticle(String title, String body) {
        Article article = new Article(latestArticleId, title, body, 0, commonUtil.getCurrentDateTime());
        articlelist.add(article);
        latestArticleId++;

        return article;
    }
}
