package block;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeBlockImpl implements CompositeBlock{
    private String color;
    private String material;
    private List<Block> blocks;

    public CompositeBlockImpl(String color, String material, List<Block> blocks){
        setColor(color);
        setMaterial(material);
        setBlocks(blocks);
    }
    
    @Override
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks.stream().map(b -> b.clone()).collect(Collectors.toList());

    }

    public void setBlocks(List<Block> blocks){
        this.blocks = blocks.stream().map(b -> b.clone()).collect(Collectors.toList());
    }

    public List<Block> populateBlocks(){
        return Arrays.asList(new BlockImpl("red", "brick"),
            new BlockImpl("brown", "wood"),
            new BlockImpl("grey", "concrete"));
    }

    @Override
    public CompositeBlockImpl clone() {
        return new CompositeBlockImpl(this.getColor(), this.getMaterial(), this.getBlocks());
    }


    @Override
    public String toString() {
        return "{" +
            " color='" + getColor() + "'" +
            ", material='" + getMaterial() + "'" +
            ", blocks='" + getBlocks() + "'" +
            "}";
    }

}
