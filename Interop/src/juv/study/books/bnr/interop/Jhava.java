package juv.study.books.bnr.interop;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class Jhava {

    // public int hitPoints = 21342314;
    private int hitPoints = 21342314;
    private String greeting = "BLARGH";

    @NotNull
    public String utterGreeting() {
        // return "BLARGH";
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void offerFood() {
        Hero.handOverFood("Pizza");
    }

    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            System.out.println("Caught!");
        }
    }

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());

        System.out.println("Spells:");
        SpellBook spellBook = new SpellBook();
        for (String spell : spellBook.spells) {
            System.out.println(spell);
        }

        System.out.println("Max spell count: " + SpellBook.MAX_SPELL_COUNT);
        SpellBook.getSpellBookGreeting();

        Function1<String, Unit> translatorJ = Hero.getTranslator();
        translatorJ.invoke("TRUCE");
    }
}
