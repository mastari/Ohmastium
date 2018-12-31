package Engine.States;

import Engine.renderEngine.Loader;
import Engine.renderEngine.MasterRenderer;

import java.util.Stack;

public class StateManager {
    public static Stack<State> States;

    public static State pendingState;

    public static State beginState;


    public static void init() {
        States = new Stack<State>();
        States.push(beginState);
        pendingState = null;
        States.peek().init();
    }

    public static void update() { States.peek().update(); }

    public static void render() {
        States.peek().render();
        MasterRenderer.masterRenderer.render(States.peek().sun, States.peek().camera);
        if(pendingState != null) {
            pushPending();
        }
    }

    public static void pushPending() {
        States.pop();
        beginState = pendingState;
        init();
        System.out.println("Pending state was pushed");
    }

    public static void setBeginState(State state) {
        beginState = state;
    }
}
