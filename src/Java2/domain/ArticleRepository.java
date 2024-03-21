package Java2.domain;

import Java.base.CommonUtil;
import Java2.domain.Article;

import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article> articleList = new ArrayList<>();
    CommonUtil commonUtil = new CommonUtil();
    int latestArticleId = 4;

    public ArticleRepository() {
        makeTestData();
    }

    public void makeTestData() {
        //id, title, body, hit, regDate
        Article a1 = new Article(1, "안녕하세요", "자바", 0, commonUtil.getCurrentDateTime());
        Article a2 = new Article(2, "반갑습니다.", "자바", 0, commonUtil.getCurrentDateTime());
        Article a3 = new Article(3, "안녕히가세요.", "정처기", 0, commonUtil.getCurrentDateTime());

        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }

    public ArrayList<Article> findArticleByKeyword(String Keyword) {
        ArrayList<Article> searchList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getTitle().contains(Keyword)); {
                searchList.add(article);
            }
        }
        return searchList;
    }

    public Article findArticleById(int id) { // 해당하는 게시물을 찾아서 반환
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public void deleteArticle(Article article) {
        articleList.remove(article);
    }

    public void updateArticle(Article article, String newtitle, String newbody) {
        article.setTitle(newtitle);
        article.setBody(newbody);
    }

    public ArrayList<Article> findAll() {
        return articleList;
    }

}
