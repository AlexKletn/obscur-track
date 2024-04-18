package space.obscur.obscurtrack.common.itemsList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@EqualsAndHashCode
public class ItemsListRequest {
//    @Min(1)
//    @Max(500)
    private Integer count = 10;
//    @Min(1)
    private Integer page = 1;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortField = "id";
}
