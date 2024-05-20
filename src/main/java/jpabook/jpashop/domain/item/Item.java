package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
// InheritanceType : SINGLE_TABLE(하나의 테이블에 모아둠), TABLE_PER_CLASS(아이템 하나씩 테이블 나눔), JOINED(가장 정교화)
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany
    private List<Category> categories = new ArrayList<>();
}
