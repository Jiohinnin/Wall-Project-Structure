package wall;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import block.Block;
import block.CompositeBlockImpl;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks){
        setBlocks(blocks);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().filter(b -> b.getColor().equals(color)).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().filter(b -> b.getMaterial().equals(material)).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }


    @Override
    public int countWithCompositeBlocksComponents() {
        int counter = 0;
        for (int i = 0; i < blocks.size(); i++) {  
        if(blocks.get(i) instanceof CompositeBlockImpl){
            CompositeBlockImpl compositeBlockImpl = (CompositeBlockImpl) blocks.get(i);
            counter++;
            for (int j = 0; j < compositeBlockImpl.getBlocks().size() ; j++) {
                counter++;
            }
        } else {
        counter++;
        }
    }
        return counter;
    }

    public void setBlocks(List<Block> blocks){
        this.blocks = blocks.stream().map(b -> b.clone()).collect(Collectors.toList());
    }

}
