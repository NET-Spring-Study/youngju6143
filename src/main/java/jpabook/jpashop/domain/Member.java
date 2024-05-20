package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") // PKL 이름
    private Long id;

    private String name;

    @Embedded // 내장 타입을 포함했다는 뜻의 애노테이션
    private Address address;

    @OneToMany(mappedBy = "member") // member 입장 : order와 일대다 관계
    // mappedBy : "member"에 의해 맵핑당한 존재
    private List<Order> orders = new ArrayList<>();
}
