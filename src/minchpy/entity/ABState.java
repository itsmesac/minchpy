package minchpy.entity;

public class ABState {
    State state;
    Depth depth;
    
    public ABState(State state) {
        super();
        this.state = state;
        this.depth = new Depth(0);
    }

    public ABState() {
        super();
    }
    
    @Override
    public ABState clone() throws CloneNotSupportedException {
        ABState abStateClone = new ABState();
        abStateClone.setState(this.getState().clone());
        abStateClone.setDepth(this.getDepth().clone());
        return abStateClone;
    }

    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public Depth getDepth() {
        return depth;
    }
    
    public void setDepth(Depth depth) {
        this.depth = depth;
    }
    
    public void updateState(State state) {
        this.state = state;
        depth.incrementDepth();
    }
}
