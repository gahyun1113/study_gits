package gahyun;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        Map<String, User> userMap = new HashMap<>();

        boolean exit = true;

        while (exit) {
            System.out.print("Input Your Name: ");
            String name = scanner.nextLine();
            User user = new User(name, new Todo());
            users.add(user);
            userMap.put(name, user);

            while (true) {
                System.out.println("====================");
                System.out.println("ToDo List 중 하나 선택 하세요 !");
                System.out.println("1. 주간 보고서 작성, 2. 이메일 확인 및 응답, 3. 회의 준비, 4. 프로젝트 계획서 수정, 5.팀 멤버와의 1:1 면담");

                System.out.print("Title 번호 : ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        userMap.get(name).getTodo().setTodoMap(Todo.todoTitle[0]);
                        break;

                    case 2:
                        userMap.get(name).getTodo().setTodoMap(Todo.todoTitle[1]);
                        break;

                    case 3:
                        userMap.get(name).getTodo().setTodoMap(Todo.todoTitle[2]);
                        break;

                    case 4:
                        userMap.get(name).getTodo().setTodoMap(Todo.todoTitle[3]);
                        break;

                    case 5:
                        userMap.get(name).getTodo().setTodoMap(Todo.todoTitle[4]);
                        break;

                    default:
                        break;

                }

                System.out.println("Status:  완료");

                System.out.print("종료 여부 : ");
                String quit = scanner.nextLine();

                if (quit.equals("q")) break;
                if (quit.equals("x")) {
                    exit = false;
                    break;

                }

            }



        }

        System.out.println("==========================");
        System.out.println("참여자별 ToDo list 진행 현황");

        for (User user : users) {
            System.out.println("-" + user.getName());

            for (int i = 0; i < Todo.todoTitle.length; i++) {
                System.out.println(Todo.todoTitle[i]+" : " + user.getTodo().isCompleted(Todo.todoTitle[i]));
            }

            System.out.println();
        }

    }
}