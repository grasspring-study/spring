package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; //null일 가능성도 생각하여 Integer로, int일 경우 0 이 들어가야함

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
