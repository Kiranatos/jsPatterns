package net.kiranatos.patterns.unsorted.behavioural;

import java.util.Scanner;

public class MediatorDemo{
    public static void Run()    {
        Brain human = new Brain();
        String line;
        AskForInput();
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).isEmpty())
        {
            switch (line)
            {
                case "Ear":
                    human.getEar().HearSomething();
                    break;
                case "Eye":
                    human.getEye().SeeSomething();
                    break;
                case "Hand":
                    human.getHand().FeelSomething();
                    break;
            }
            AskForInput();
        }
    }

    private static void AskForInput(){
        System.out.println("Enter body part ('Ear','Eye','Hand' or empty to exit):");
    }
}
// Mediator
class Brain{
    public Brain(){
        CreateBodyParts();
    }
    private void CreateBodyParts()    {
        setEar(new Ear(this));
        setEye(new Eye(this));
        setFace(new Face(this));
        setHand(new Hand(this));
        setLeg(new Leg(this));
    }
    private Ear ear;
    private Eye eye;
    private Face face;
    private Hand hand;
    private Leg leg;

    public void SomethingHappenedToBodyPart(BodyPart bodyPart){
        if (bodyPart instanceof Ear){
            String heardSounds = ((Ear)bodyPart).GetSounds();
            if (heardSounds.contains("stupid")){
                // attacking offender
                getLeg().StepForward();
                getHand().HitPersonNearYou();
                getLeg().Kick();
            }
            else if (heardSounds.contains("cool")){
                getFace().Smile();
            }
        }
        else if (bodyPart instanceof Eye){
            // brain can analyze what you see and
            // can react appropriately using different body parts
        }
        else if (bodyPart instanceof Hand){
            Hand hand = (Hand)bodyPart;
            boolean hurtingFeeling = hand.DoesItHurt();
            if (hurtingFeeling){
                getLeg().StepBack();
            }
            boolean itIsNice = hand.IsItNice();
            if (itIsNice){
                getLeg().StepForward();
                hand.Embrace();
            }
        }
        else if (bodyPart instanceof Leg){
            // leg can also feel something if you would like it to
        }
    }
    public Ear getEar() {
        return ear;
    }
    public void setEar(Ear ear) {
        this.ear = ear;
    }
    public Eye getEye() {
        return eye;
    }
    public void setEye(Eye eye) {
        this.eye = eye;
    }
    public Face getFace() {
        return face;
    }
    public void setFace(Face face) {
        this.face = face;
    }
    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public Leg getLeg() {
        return leg;
    }
    public void setLeg(Leg leg) {
        this.leg = leg;
    }
}
// Collegue
class BodyPart{
    private final Brain _brain;
    public BodyPart(Brain brain){
        _brain = brain;
    }
    public void Changed(){
        _brain.SomethingHappenedToBodyPart(this);
    }
}
class Ear extends BodyPart{
    private String _sounds = "";
    public Ear(Brain brain){
        super(brain);
    }
    public void HearSomething(){
        System.out.println("Enter what you hear:");
        Scanner scanner = new Scanner(System.in);
        _sounds = scanner.nextLine();
        Changed();
    }
    public String GetSounds(){
        return _sounds;
    }
}
class Face extends BodyPart{
    public Face(Brain brain){
        super(brain);
    }
    public void Smile(){
        System.out.println("FACE: Smiling...");
    }
}
class Eye extends BodyPart{
    private String _thingsAround = "";
    public Eye(Brain brain){
        super(brain);
    }
    public void SeeSomething(){
        System.out.println("Enter what you see:");
        Scanner scanner = new Scanner(System.in);
        _thingsAround = scanner.nextLine();
        Changed();
    }
}
class Hand extends BodyPart{
    private boolean _isSoft;
    private boolean _isHurting;
    public Hand(Brain brain){
        super(brain);
    }
    public void FeelSomething(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What you feel is soft? (Yes/No)");
        String answer = scanner.nextLine();
        if (answer != null && answer.charAt(0) == 'Y'){
            _isSoft = true;
        }
        System.out.println("What you feel is hurting? (Yes/No)");
        answer = scanner.nextLine();
        if (answer != null && answer.charAt(0) == 'Y'){
            _isHurting = true;
        }
        Changed();
    }
    public void HitPersonNearYou(){
        System.out.println("HAND: Just hit offender...");
    }
    public void Embrace(){
        System.out.println("HAND: Embracing what is in front of you...");
    }
    public boolean DoesItHurt(){
        return _isHurting;
    }
    public boolean IsItNice(){
        return !_isHurting && _isSoft;
    }
}
class Leg extends BodyPart{
    public Leg(Brain brain){
        super(brain);
    }
    public void Kick(){
        System.out.println("LEG: Just kicked offender in front of you..");
    }
    public void StepBack(){
        System.out.println("LEG: Stepping back...");
    }
    public void StepForward(){
        System.out.println("LEG: Stepping forward...");
    }
}