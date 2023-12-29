package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @Data 주의해서 쓸 것
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // null인 경우를 처리하기 위해 int 대신 Integer 사

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
