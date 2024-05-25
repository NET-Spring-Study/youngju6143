package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException{
    @Override
    public String getMessage() {
        return "재고가 모자랍니다";
    }
}