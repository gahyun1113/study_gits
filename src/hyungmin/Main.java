package hyungmin;

import java.util.*;

class UserTodoRecord {
    String userName;
    Map<Integer, Todo> todoMap;
    // 차후 리팩토링하여 userTodoMapStorage 대신 사용가능할 것으로 판단
}


class Todo {
    String content;
    boolean status;

    public Todo(String content, boolean status) {
        this.content = content;
        this.status = status;
    }
    @Override
    public String toString() {
        return content + "(" +(status ?"완료":"미정") +")";
    }
}

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static void displayInputExplanation() {
        System.out.println("Status 기호 : 완료, 미정 -> 번호 선택 시 자동 부여 ");
        System.out.println("진행 기호 : c - 계속 입력, q - 다음 참여자로 넘기기, x - 모든 입력 종료");
    }
    private static void displaySelectOption() {
        System.out.println("ToDo List 중 하나 선택 하세요 !");
        System.out.println("1. 주간 보고서 작성, 2. 이메일 확인 및 응답, 3. 회의 준비, 4. 프로젝트 계획서 수정, 5. 팀 멤버와의 1:1 면담");
    }
    private static String displayGetTitleNumStr() {
        System.out.print("Title 번호: ");
        String inputStr = scanner.nextLine();
        if(inputStr.equals("q") || inputStr.equals("Q") || inputStr.equals("ㅂ")) return "q";
        if(inputStr.equals("x") || inputStr.equals("X") || inputStr.equals("ㅌ")) return "x";
        if(inputStr.equals("c") || inputStr.equals("C") || inputStr.equals("ㅊ")) return "c";
        return inputStr;
    }

    private static String displayGetUserName() {
        System.out.print("Input Your Name: ");
        return scanner.nextLine();
    }

    private static int validateInputTitleNum(String titleNumStr) {
        int titleNum;
        try{
            titleNum = Integer.parseInt(titleNumStr);
        } catch(Exception e){
            return -1;
        }
        return titleNum;
    }

    private static String displayGetContinueOrQuitOrExit() {
        while(true){
            System.out.print("종료 여부: ");
            String inputStr = scanner.nextLine();
            if(inputStr.equals("c") || inputStr.equals("C") || inputStr.equals("ㅊ")) {
                return "c";
            }
            if(inputStr.equals("q") || inputStr.equals("Q") || inputStr.equals("ㅂ")){
                return "q";
            }
            if(inputStr.equals("x") || inputStr.equals("X") || inputStr.equals("ㅌ")){
                return "x";
            }
            System.out.println("잘못된 입력입니다.");
            displayInputExplanation();
            System.out.println("--------------------");
        }
    }

    private static void displayUserTodoMapStorageContent(Map<String, Map<Integer, Todo>> userTodoMapStorage, String userName) {
        System.out.println("- " + userName+ ": ");
        Map<Integer, Todo> todoMapPerPerson = userTodoMapStorage.get(userName);
        System.out.print("1. "+todoMapPerPerson.get(1).toString()+", ") ;
        System.out.print("2. "+todoMapPerPerson.get(2).toString()+", ") ;
        System.out.print("3. "+todoMapPerPerson.get(3).toString()+", ") ;
        System.out.print("4. "+todoMapPerPerson.get(4).toString()+", ") ;
        System.out.print("5. "+todoMapPerPerson.get(5).toString()) ;
        System.out.println();
    }

    public static void main(String[] args) {

        List<String> userNameList = new ArrayList<>(); // 사용자 이름 저장
        Map<String, Map<Integer, Todo>> userTodoMapStorage = new HashMap<>(); // 사용자별 할 일 정보 저장

        String inputStr = "";
        boolean running = true;

        displayInputExplanation();
        System.out.println("==========START==========");

        // 입력받는 부분
        while(running) {
            String userName= displayGetUserName();
            userNameList.add(userName);
            Map<Integer, Todo> individualTodoMap = new HashMap<>(); // 개인별 todoMap 리셋
            individualTodoMap.put(1, new Todo("주간 보고서 작성", false));
            individualTodoMap.put(2, new Todo("이메일 확인 및 응답", false));
            individualTodoMap.put(3, new Todo("회의 준비", false));
            individualTodoMap.put(4, new Todo("프로젝트 계획서 수정", false));
            individualTodoMap.put(5, new Todo("팀 멤버와의 1:1 면담", false));

            while(true) {
                displaySelectOption();

                // 타이틀 번호 입력받음
                inputStr = displayGetTitleNumStr();
                if(inputStr.equals("c")) {
                    System.out.println("---------- 계속 진행 ----------");
                    continue;
                }
                if(inputStr.equals("q")) {
                    userTodoMapStorage.put(userName, individualTodoMap); // 사용자 정보 저장
                    System.out.println("---------- 사용자 전환 -----------");
                    break;
                }
                if(inputStr.equals("x")) {
                    userTodoMapStorage.put(userName, individualTodoMap); // 사용자 정보 저장
                    running = false;
                    System.out.println("---------- 입력 종료 ----------");
                    break;
                }

                // 입력값이 숫자로 변환될 수 있는지 확인. 문자의 경우 -1로 반환
                int inputTitleNum = validateInputTitleNum(inputStr);
                if(inputTitleNum < 1 || inputTitleNum > 5) {
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("--------------------");
                    continue;
                }

                // 올바른 입력일 경우
                individualTodoMap.get(inputTitleNum).status = true;
                System.out.println("Status: "+individualTodoMap.get(inputTitleNum).toString());

                // 종료 여부 입력받음
                inputStr = displayGetContinueOrQuitOrExit(); // 예외처리 포함
                if(inputStr.equals("c")) {
                    System.out.println("---------- 계속 진행 ----------");
                    continue;
                }
                if(inputStr.equals("q")) {
                    userTodoMapStorage.put(userName, individualTodoMap); // 사용자 정보 저장
                    System.out.println("---------- 사용자 전환 -----------");
                    break;
                }
                if(inputStr.equals("x")) {
                    userTodoMapStorage.put(userName, individualTodoMap); // 사용자 정보 저장
                    running = false;
                    System.out.println("---------- 입력 종료 ----------");
                    break;
                }
            }
        }
        // 결과 출력
        System.out.println("참여자별 ToDo list 진행상황");
        // if(userNameList.isEmpty()) System.out.println("### 입력된 사용자가 없습니다. ###"); // 무조건 1명은 받게 되어있어 불필요
        for(String userName : userNameList) {
            displayUserTodoMapStorageContent(userTodoMapStorage, userName);
        }
        System.out.println("==========FINISH==========");
    }
}

