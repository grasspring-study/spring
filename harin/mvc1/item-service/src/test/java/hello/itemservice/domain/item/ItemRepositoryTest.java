package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    //테스트 끝날때마다 실행
    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("ItemA", 1000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem); //저장된 값이랑 조회한 값이 같다
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("ItemA", 1000, 10);
        Item item2 = new Item("ItemB", 7000, 5);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void update() {
        //given
        Item item = new Item("item", 2000, 10);
        Item item1 = new Item("item1", 300, 20);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updatedParam = new Item("item1", 300, 20);
        itemRepository.update(itemId, updatedParam);

        //then
        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updatedParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updatedParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updatedParam.getQuantity());
    }

    @Test
    void clearStore() {
    }
}