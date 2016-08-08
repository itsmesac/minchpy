package minchpy.entity;

public class Depth {
    int depthValue;
    
    @Override
    protected Depth clone() throws CloneNotSupportedException {
        Depth depthClone = new Depth();
        //TODO implement clone when variables are decided
        return depthClone;
    }

    public int getDepthValue() {
        return depthValue;
    }

    public void setDepthValue(int depthValue) {
        this.depthValue = depthValue;
    }
    
    public void decrementDepth() {
        this.depthValue--;
    }

    @Override
    public boolean equals(Object value) {
        if(this.depthValue == (Integer)value)
            return true;
        else
            return false;
    }
    
    
}
