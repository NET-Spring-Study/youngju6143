package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // MemberServiceImpl의 인스턴스인지 검증
        System.out.println("memberService = " + memberService);
        // 출력  : memberService = hello.core.member.MemberServiceImpl@772485dd
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // 출력 : memberService.getClass() = class hello.core.member.MemberServiceImpl
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // MemberServiceImpl의 인스턴스인지 검증
        System.out.println("memberService = " + memberService);
        // 출력  : memberService = hello.core.member.MemberServiceImpl@772485dd
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // 출력 : memberService.getClass() = class hello.core.member.MemberServiceImpl
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // MemberServiceImpl의 인스턴스인지 검증
        System.out.println("memberService = " + memberService);
        // 출력  : memberService = hello.core.member.MemberServiceImpl@772485dd
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // 출력 : memberService.getClass() = class hello.core.member.MemberServiceImpl
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
//        ac.getBean("xxxxx", MemberService.class);
        // error : NoSuchBeanDefinitionException
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
        // 이 예외가 터져야만 성공
    }
}
