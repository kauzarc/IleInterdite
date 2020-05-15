package Controller;

public class UserActionState {
    public enum Mod {
        moving, drying
    }

    private Mod mod;
    private int actionCount;

    private static final UserActionState instance = new UserActionState();

    private UserActionState() {
        this.mod = Mod.moving;
        this.actionCount = 0;
    }

    public static UserActionState getInstance() {
        return instance;
    }

    public Mod getMod() {
        return this.mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }

    public void actionCountUp() {
        this.actionCount++;
    }

    public void actionCountReset() {
        this.actionCount = 0;
    }

    public int getActionCount() {
        return this.actionCount;
    }
}
