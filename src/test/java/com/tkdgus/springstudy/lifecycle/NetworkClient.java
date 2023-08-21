package com.tkdgus.springstudy.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
    private String url;

    /**
     * 스프링은 3가지 방법으로 빈 생명주기 콜백을 지원
     * 인터페이스 - InitializingBean, DisposableBean(종료)
     * Bean 설정 시 메소드 이름 지정
     * @PostConstruct, @PreDestroy - 해당 어노테이션들은 JSR이라는 자바 표준이다
     */

    public NetworkClient() {
        System.out.println("생성자 호출 / url : " + url);
    }

    public void setUri(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message : " + message);
    }
    
    public void disconnect() {
        System.out.println("종료");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
