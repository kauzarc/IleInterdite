package Controller;

public class UserActionState {
    public enum Mode {
        moving, drying
    }

    private Mode mode;
    private int actionCount;

    private static final UserActionState instance = new UserActionState();

    private UserActionState() {
        reset();
    }

    public static UserActionState getInstance() {
        return instance;
    }

    public Mode getMod() {
        return this.mode;
    }

    public void setMod(Mode mod) {
        this.mode = mod;
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

    public void reset() {
        this.mode = Mode.moving;
        this.actionCount = 0;
    }
}
