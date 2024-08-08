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
            User user = new User(name, new Todo(false, false, false, false, false));
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
                        userMap.get(name).getTodo().setCompleted_01(true);
                        break;

                    case 2:
                        userMap.get(name).getTodo().setCompleted_02(true);
                        break;

                    case 3:
                        userMap.get(name).getTodo().setCompleted_03(true);
                        break;

                    case 4:
                        userMap.get(name).getTodo().setCompleted_04(true);
                        break;

                    case 5:
                        userMap.get(name).getTodo().setCompleted_05(true);
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
            for (int i = 0; i < Todo.todoList.length; i++) {
                System.out.println(Todo.todoList[i]+" : ");
            }
            System.out.println("1. 주간 보고서 작성 : " +user.getTodo().isCompleted_01());
            System.out.println("2. 이메일 확인 및 응답 : " +user.getTodo().isCompleted_02());
            System.out.println("3. 회의 준비 : " +user.getTodo().isCompleted_03());
            System.out.println("4. 프로젝트 계획서 수정 : " +user.getTodo().isCompleted_04());
            System.out.println("5. 팀 멤버와의 1:1 면담 : " +user.getTodo().isCompleted_05());
            System.out.println();
        }

    }
}