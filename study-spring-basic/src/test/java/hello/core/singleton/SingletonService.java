package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){ //외부에서 조회시 사용
        return instance;
    }

    private SingletonService(){ //다른 곳에서 new로 객체를 생성하지 못하게 private으로 생성자를 설정해준다 -> 싱글톤

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
