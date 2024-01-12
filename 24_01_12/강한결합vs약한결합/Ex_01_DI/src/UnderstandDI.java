import java.util.Date;

public class UnderstandDI {
    public static void main(String[] args) {
        //날짜를 구하기 위해서는 Date 클래스에 의존해야 한다.
        Date date = new Date();
        System.out.println(date);

        memberUser1();
    }

    public static void memberUser1(){
        //강한 결합 : 직접생성
        Member m1 = new Member();
        System.out.println("강결합");
    }
    public static void memberUser2(Member m){
        //약한 결합 : 생성된 것을 주입 받음 - 의존 주입(Dependency Injection)
        Member m2 = m;
        System.out.println("약결합");
    }

}
