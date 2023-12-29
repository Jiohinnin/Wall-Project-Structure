package wall;

import java.util.List;
import java.util.Optional;

import block.Block;

public interface Structure {
    Optional<Block> findBlockByColor(String color);
    List<Block> findBlocksByMaterial(String material);
    int count();
    int countWithCompositeBlocksComponents();
}
