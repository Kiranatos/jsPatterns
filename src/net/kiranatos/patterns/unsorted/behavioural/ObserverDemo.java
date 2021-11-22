package net.kiranatos.patterns.unsorted.behavioural;

import java.util.LinkedList;
import java.util.Random;

interface IObserver{
    void Update(ISubject subject);
}
//
class RiskyPlayer implements IObserver{
    private String boxerToPutMoneyOn;
    public void Update(ISubject subject){
        BoxFight boxFight = (BoxFight)subject;
        if (boxFight.getBoxerAScore() > boxFight.getBoxerBScore())
            boxerToPutMoneyOn = "I put on boxer B, if he win I get more!";
        else boxerToPutMoneyOn = "I put on boxer A, if he win I get more!";
        System.out.printf("RISKYPLAYER: %s\n", boxerToPutMoneyOn);
    }
    public String getBoxerToPutMoneyOn() {
        return boxerToPutMoneyOn;
    }
    public void setBoxerToPutMoneyOn(String boxerToPutMoneyOn) {
        this.boxerToPutMoneyOn = boxerToPutMoneyOn;
    }
}
//
class ConservativePlayer implements IObserver{
    private String boxerToPutMoneyOn;
    public void Update(ISubject subject){
        BoxFight boxFight = (BoxFight)subject;
        if (boxFight.getBoxerAScore() < boxFight.getBoxerBScore())
            boxerToPutMoneyOn = "I put on boxer B, better be safe!";
        else boxerToPutMoneyOn = "I put on boxer A, better be safe!";
        System.out.printf("CONSERVATIVEPLAYER:%s\n", boxerToPutMoneyOn);
    }

    public String getBoxerToPutMoneyOn() {
        return boxerToPutMoneyOn;
    }

    public void setBoxerToPutMoneyOn(String boxerToPutMoneyOn) {
        this.boxerToPutMoneyOn = boxerToPutMoneyOn;
    }
}

interface ISubject
{
    void AttachObserver(IObserver observer);
    void DetachObserver(IObserver observer);
    void Notify();
}
class BoxFight implements ISubject{
    private LinkedList<IObserver> observers;
    private int roundNumber;
    private Random random = new Random();

    private int boxerAScore;
    private int boxerBScore;

    public BoxFight(){
        observers = new LinkedList<IObserver>();
    }
    public void AttachObserver(IObserver observer){
        observers.add(observer);
    }
    public void DetachObserver(IObserver observer){
        observers.remove(observer);
    }
    public void NextRound(){
        roundNumber++;
        setBoxerAScore(getBoxerAScore() + random.nextInt(5));
        setBoxerBScore(getBoxerBScore() + random.nextInt(5));
        Notify();
    }
    public void Notify(){
        for(IObserver observer: observers)
        {
            observer.Update(this);
        }
    }
    public int getBoxerAScore() {
        return boxerAScore;
    }
    public void setBoxerAScore(int boxerAScore) {
        this.boxerAScore = boxerAScore;
    }
    public int getBoxerBScore() {
        return boxerBScore;
    }
    public void setBoxerBScore(int boxerBScore) {
        this.boxerBScore = boxerBScore;
    }
}
public class ObserverDemo
{
    public static void Run()
    {
        BoxFight boxFight = new BoxFight();

        RiskyPlayer riskyPlayer = new RiskyPlayer();
        ConservativePlayer conservativePlayer = new ConservativePlayer();


        boxFight.AttachObserver(riskyPlayer);
        boxFight.AttachObserver(conservativePlayer);


        boxFight.NextRound();
        System.out.println();
        boxFight.NextRound();
        System.out.println();
        boxFight.NextRound();
        System.out.println();
        boxFight.NextRound();
        System.out.println();
    }
}