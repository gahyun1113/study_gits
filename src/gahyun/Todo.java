package gahyun;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Todo {

    public static String[] todoTitle = new String[] {
            "1. 주간 보고서 작성",
            "2. 이메일 확인 및 응답",
            "3. 회의 준비",
            "4. 프로젝트 계획서 수정",
            "5. 팀 멤버와의 1:1 면담"
    };

    private Map<String, Boolean> todoMap = new HashMap<>();

    public Todo() {
        for (int i = 0; i < todoTitle.length; i++) {
            todoMap.put(todoTitle[i], false);
        }
    }

    public String isCompleted(String todoTitle) {
        Boolean completed = todoMap.get(todoTitle);
        if (completed) {
            return "완료";
        }
        return "미정";
    }

    public void setTodoMap(String todoTitle) {
        todoMap.put(todoTitle, true);
    }


}
