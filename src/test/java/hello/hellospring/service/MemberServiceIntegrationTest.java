package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 테스트 끝나면 롤백 -> db에 있는 데이터 다 사라짐
               // -> 다음 테스트 또 반복해서 실행 가능
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    // Ctrl+R : 이전꺼 누적해서 run
    // 테스트는 그냥 필드 기반으로 오토와이어 걸어도 됨

    @Test
    @Commit
    // 함수명 한글로 적어도 됨!!
    public void 회원가입() {
        // given : 이게 주어지면 (데이터)
        Member member = new Member();
        member.setName("spring1234");

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

    }
}