package block;

public class BlockImpl implements Block{
    private String color;
    private String material;
    
   
    public BlockImpl(String color, String material) {
        setColor(color);;
        setMaterial(material);
    }

    @Override
    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    @Override
    public BlockImpl clone() {
        return new BlockImpl(this.getColor(), this.getMaterial());
    }  


    @Override
    public String toString() {
        return "{" +
            " color='" + getColor() + "'" +
            ", material='" + getMaterial() + "'" +
            "}";
    }

}
