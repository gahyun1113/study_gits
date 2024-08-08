package gahyun;

import java.util.ArrayList;
import java.util.List;

public class Todo {

    public static String[] todoList = new String[] {
            "1. 주간 보고서 작성",
            "2. 이메일 확인 및 응답",
            "3. 회의 준비",
            "4. 프로젝트 계획서 수정",
            "5.팀 멤버와의 1:1 면담"
    };

    private boolean completed_01;
    private boolean completed_02;
    private boolean completed_03;
    private boolean completed_04;
    private boolean completed_05;

    public Todo(boolean completed_01, boolean completed_02, boolean completed_03, boolean completed_04, Boolean completed_05) {
        this.completed_01 = completed_01;
        this.completed_02 = completed_02;
        this.completed_03 = completed_03;
        this.completed_04 = completed_04;
        this.completed_05 = completed_05;
    }

    public String isCompleted_01() {
        if (completed_01) return "완료";
        return "미정";
    }

    public void setCompleted_01(boolean completed_01) {
        this.completed_01 = completed_01;
    }

    public String isCompleted_02() {
        if (completed_02) return "완료";
        return "미정";
    }

    public void setCompleted_02(boolean completed_02) {
        this.completed_02 = completed_02;
    }

    public String isCompleted_03() {
        if (completed_03) return "완료";
        return "미정";
    }

    public void setCompleted_03(boolean completed_03) {
        this.completed_03 = completed_03;
    }

    public String isCompleted_04() {
        if (completed_04) return "완료";
        return "미정";
    }

    public void setCompleted_04(boolean completed_04) {
        this.completed_04 = completed_04;
    }

    public String isCompleted_05() {
        if (completed_05) return "완료";
        return "미정";
    }

    public void setCompleted_05(boolean completed_05) {
        this.completed_05 = completed_05;
    }
}
