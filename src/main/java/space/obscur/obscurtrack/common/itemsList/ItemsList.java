package space.obscur.obscurtrack.common.itemsList;

import lombok.Data;

import java.util.List;

@Data
public class ItemsList<Item> {
    private List<Item> items;
    private Integer total;

    public Integer getCount() {
        return items.size();
    }
}
