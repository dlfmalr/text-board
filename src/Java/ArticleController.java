package Java;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {

    CommonUtil commonUtil = new CommonUtil();
    ArticleView articleViwe = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();

    Scanner scan = commonUtil.getScanner(); //
    int WRONG_VALUE = -1; //

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedList = articleRepository.findArticleByKeyword(keyword);
        //ArrayList<Article>형태로 변환       입력된 검색어 찾기
        articleViwe.printArticleList(searchedList); // 출력
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");

        int inputId = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        if (inputId == WRONG_VALUE) {
            return;
        }

        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }

        article.increaseHit();
        articleViwe.printArticleDetail(article);
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호를 입력해주세요 : ");

        int inputId = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        if (inputId == WRONG_VALUE) { //오류를 막기 위한 코드
            return;
        }

        Article article = articleRepository.findArticleById(inputId);
        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }

        articleRepository.deleteArticle(article);
        System.out.printf("%d 게시물이 삭제되었습니다.\n", inputId);
    }

    public void update() {
        System.out.print("수정할 게시물 번호를 입력해주세요 : ");

        int inputId = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        if (inputId == WRONG_VALUE) { // 숫자가 아닌 다른 문자를 입력했을때 오류를 막기 위한 코드
            return;
        }

        Article article = articleRepository.findArticleById(inputId);
        if (article == null) { // 숫자를 입력했을때 없는 코드를 나타내기 위한 것
            System.out.println("없는 게시물입니다.");
            return;
        }

        System.out.print("새로운 제목을 입력해주세요 : ");
        String newTitle = scan.nextLine();

        System.out.print("새로운 내용을 입력해주세요 :");
        String newBody = scan.nextLine();

        articleRepository.updateArticle(article, newTitle, newBody);
        System.out.printf("%d번 게시물이 수정되었습니다.\n", inputId);
    }

    public void list() {
        ArrayList<Article> articleList = articleRepository.findAll();
        articleViwe.printArticleList(articleList);
    }

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();

        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        articleRepository.saveArticle(title, body);
        System.out.println("게시물이 등록되었습니다.");
    }

    private int getParamAsInt(String param, int defaultValue) {
        try {
            return Integer.parseInt(param);
        }catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return defaultValue;
        }
    }
}
