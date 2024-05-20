package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    // ORDINAL : 숫자(인덱스처럼),STRING : 문자
    // ORDINAL을 사용하면 status enum 데이터의 순서가 바뀔 때,
    // 바뀐 순서에 따라 숫자가 매핑되므로 큰일남
    // STRING 사용하면 문제 해결
    private DeliveryStatus status;
}
