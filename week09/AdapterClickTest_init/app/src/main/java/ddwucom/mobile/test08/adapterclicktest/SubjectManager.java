package ddwucom.mobile.test08.adapterclicktest;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("햄버거");
        subjectList.add("피자");
        subjectList.add("떡볶이");
        subjectList.add("샌드위치");
        subjectList.add("케이크");
    }

//    값 반환
    public String getDataByPos(int pos) { return subjectList.get(pos); }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

//    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

//    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

//    수정
    public void updateData(int pos, String subject) { subjectList.set(pos, subject); }

}
