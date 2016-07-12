package minchpy.entity;

public class Player {
    @Override
    protected Player clone() throws CloneNotSupportedException {
        Player playerClone = new Player();
        playerClone.setPlayer(this.getPlayer());
        return playerClone;
    }

    int player;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Player(int player) {
        super();
        this.player = player;
    }

    public Player() {
        super();
    }
    
}
