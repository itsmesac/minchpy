package minchpy.entity;

public class Depth {
    int depthValue;
    
    public Depth(int depthValue) {
        super();
        this.depthValue = depthValue;
    }

    @Override
    protected Depth clone() throws CloneNotSupportedException {
        Depth depthClone = new Depth(depthValue);
        return depthClone;
    }

    public int getDepthValue() {
        return depthValue;
    }

    public void setDepthValue(int depthValue) {
        this.depthValue = depthValue;
    }
    
    public void incrementDepth() {
        this.depthValue++;
    }

    @Override
    public boolean equals(Object value) {
        if(this.depthValue == (Integer)value)
            return true;
        else
            return false;
    }
    
    
}
