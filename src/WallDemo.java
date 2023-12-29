import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import block.Block;
import block.BlockImpl;
import block.CompositeBlockImpl;
import wall.Wall;

public class WallDemo {
    public static void main(String[] args) {
        Wall wall = new Wall(populateWallWithData());

        System.out.println("\n\n1. Number of blocks in the wall: " + wall.count());

        System.out.println("\n\n2. Number of blocks in the wall with composite blocks components included: " + wall.countWithCompositeBlocksComponents());

        List<Block> filteredBlocks = wall.findBlocksByMaterial("brick");
        List<Block> filteredCompositeBlocks = wall.findBlocksByMaterial("Multiple Materials");

        Optional<Block> redBlock = wall.findBlockByColor("red");
        Optional<Block> orangeBlock = wall.findBlockByColor("orange");

        System.out.println("\n\n3. Blocks found by material (brick): " + filteredBlocks.toString());
        System.out.println("\n\n4. Composite blocks found by material (Multiple Materials): " + filteredCompositeBlocks.toString());

        if (redBlock.isPresent()) {
            System.out.println("\n\n5. Single block found by red color: " + redBlock.get());
        }

        if(orangeBlock.isPresent()){
            System.out.println("\n\n6. Single block found by orange color: " + orangeBlock.get());
        }
    }

    public static List<Block> populateWallWithData(){
        return Arrays.asList(new BlockImpl("red", "brick"),
        new BlockImpl("red", "brick"),
        new BlockImpl("red", "brick"),
        new BlockImpl("red", "brick"),
        new BlockImpl("brown", "wood"),
        new BlockImpl("grey", "concrete"),
        new BlockImpl("grey", "concrete"),
        new CompositeBlockImpl("orange", "Multiple Materials", populateCopositeBlocks()),
        new CompositeBlockImpl("yellow", "Multiple Materials", populateCopositeBlocks())
    );
    }
    
    public static List<Block> populateCopositeBlocks(){
        return Arrays.asList(new BlockImpl("white", "stone"),
            new BlockImpl("green", "stone"),
            new BlockImpl("silver", "steel"));
    }

}
