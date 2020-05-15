package Controller;

public class UserActionState {
    private static UserActionState instance = new UserActionState();

    private UserActionState(){

    }

    public static UserActionState getInstance() {
        return instance;
    }
}
