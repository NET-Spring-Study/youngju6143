package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    // Ctrl+R : 이전꺼 누적해서 run

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        // memberRepository가 MemberService에 넣음 -> 생성
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }



    @Test
    // 함수명 한글로 적어도 됨!!
    void 회원가입() {
        // given : 이게 주어지면 (데이터)
        Member member = new Member();
        member.setName("hello");

        // when : 이걸 실행했을 때 (검증)
        Long saveId = memberService.join(member); // 해당 멤버가 리포지토리에 있나?

        // then : 이게 발생함 (결과)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    } // Option+Enter : static import 단축키

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        // when
        Member member2 = new Member();
        member2.setName("spring");

        // then
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // assertThrows : 오른쪽 로직 실행하면 예외 발생
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try { // 가입하려는 회원이 중복인지 확인
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//            // MemberService - validateDuplicateMember 안에서 throw한 메시지와 일치해야함
//        }
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}