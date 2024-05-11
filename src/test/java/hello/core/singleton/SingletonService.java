package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    // 객체 생성 -> 인스턴스 참조 영역에 넣음
    public static SingletonService getInstance() {
        return instance;
    }

    // new로 객체 생성하는 거 막음
    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱클톤 객체 로직 호출");
    }
}
