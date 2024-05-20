//package jpabook.jpashop;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class) // JUnit5는 RunWith X, ExtendWith 사용
//@SpringBootTest
//public class MemberRepositoryTest {
//
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false) // 이거 넣으면 디비에 저장된 정보 롤백 안 하므로 확인 ㄴ가능
//    public void testMember() throws Exception {
//        Member member = new Member();
//        member.setUserName("memberA");
//
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//        assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
//        assertThat(findMember).isEqualTo(member);
//     }
//}