package net.kiranatos.patterns.unsorted.behavioural;

import java.util.Stack;

class Caretaker{
    private GameOriginator game = new GameOriginator();
    private Stack<GameMemento> quickSaves = new Stack<>();
    public void ShootThatDumbAss(){
        game.Play();
    }
    public void F5(){
        quickSaves.push(game.GameSave());
    }
    public void F9(){
        game.LoadGame(quickSaves.pop());
    }
}
class GameOriginator{
    private GameState state = new GameState(100, 0);//Health & Killed Monsters
    public void Play(){
        //During this Play method game's state is continuously changed
        System.out.println(state);
        state = new GameState((int)(state.getHealth() * 0.9), state.getKilledMonsters() + 2);
    }
    public GameMemento GameSave(){
        return new GameMemento(state);
    }
    public void LoadGame(GameMemento memento){
        state = memento.GetState();
    }

}
class GameMemento{
    private GameState state;
    public GameMemento(GameState state){
        this.state = state;
    }
    protected GameState GetState(){
        return state;
    }
}
class GameState{
    public GameState(double health, int killedMonsters){
        this.health = health;
        this.killedMonsters = killedMonsters;
    }
    private double health;
    private int killedMonsters;
    public String toString(){
        return String.format("Health: %f Killed Monsters: %d", getHealth(), getKilledMonsters());
    }
    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public int getKilledMonsters() {
        return killedMonsters;
    }
    public void setKilledMonsters(int killedMonsters) {
        this.killedMonsters = killedMonsters;
    }
}
public class MementoDemo{
    public static void Run(){
        Caretaker caretaker = new Caretaker();
        caretaker.F5();
        caretaker.ShootThatDumbAss();
        caretaker.F5();
        caretaker.ShootThatDumbAss();
        caretaker.ShootThatDumbAss();
        caretaker.ShootThatDumbAss();
        caretaker.ShootThatDumbAss();
        caretaker.F9();
        //caretaker.ShootThatDumbAss();
        caretaker.F9();
        caretaker.ShootThatDumbAss();
    }
}
/*
class Originator {
    private String state;
    // The class could also contain additional data that is not part of the
    // state saved in the memento..

    public void set(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

    public static class Memento {
        private final String state;

        public Memento(String stateToSave) {
            state = stateToSave;
        }

        public String getSavedState() {
            return state;
        }
    }
}

class Caretaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();

        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");
        // We can request multiple mementos, and choose which one to roll back to.
        savedStates.add(originator.saveToMemento());
        originator.set("State4");

        originator.restoreFromMemento(savedStates.get(1));
    }
}
*/