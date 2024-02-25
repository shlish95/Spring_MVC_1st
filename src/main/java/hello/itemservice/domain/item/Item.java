package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter @Setter
@Data   //많은 기능이 있기 때문에 잘 알고 사용해야함
public class Item {

    private Long id;
    private String itemName;
    private Integer price;      //null이 들어갈 수 도 있게
    private Integer quantity;   //int가 아닌 Integer로 선언

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
