package Java;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    public void run() {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> titlelist = new ArrayList<>();
        ArrayList<String> bodylist = new ArrayList<>();
        ArrayList<Integer> idlist = new ArrayList<>();
        int latesarticleId = 1;

        while (true) {
            System.out.println("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if (cmd.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                titlelist.add(title);

                System.out.println("게시물 내용을 입력해주세요 : ");
                String body = scan.nextLine();
                bodylist.add(body);

                idlist.add(latesarticleId);
                latesarticleId++;
                System.out.println("게시물이 등록되었습니다.");
            }
            else if (cmd.equals("list")) {
                System.out.println("====================");
                for (int i = 0; i < titlelist.size(); i++) {
                    String title = titlelist.get(i);
//                    System.out.println("번호 : " + (i + 1));
                    int id = idlist.get(i);
                    System.out.println("번호 : " + id);
                    System.out.printf("제목 : %s\n", title);

//                    String body = bodylist.get(i);
//                    System.out.printf("내용 : %s\n", body);

                    System.out.println("====================");
                }
            }
            else if (cmd.equals("update")) {
                System.out.println("수정할 게시물 번호를 입력해주세요 : ");
                int id = Integer.parseInt(scan.nextLine());

                System.out.println("새로운 제목을 입력해주세요 : ");
                String newtitle = scan.nextLine();

                System.out.println("새로운 내용을 입력해주세요 : ");
                String newbody = scan.nextLine();

                titlelist.set(id - 1, newtitle);
                bodylist.set(id - 1, newbody);

                System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
            }
            else if (cmd.equals("delete")) {
                System.out.println("삭제할 게시물 번호 : ");
//                int id = Integer.parseInt(scan.nextLine());
                int inputid = Integer.parseInt(scan.nextLine());

                for (int i = 0; i < idlist.size(); i++) {
                    int targetId = idlist.get(i);

                    if (targetId == inputid) {
                        idlist.remove(i);
                        titlelist.remove(i);
                        bodylist.remove(i);
                    }
                }
//                titlelist.remove(id - 1);
//                bodylist.remove(id - 1);

                System.out.printf("%d 게시물이 삭제되었습니다.\n", inputid);
            }
        }
    }
}
