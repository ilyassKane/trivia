package com.adaptionsoft.games.uglytrivia;

public class Player {
    String name;
    int place = 0;
    int purses = 0;
    boolean inPenaltyBox = false;
    boolean gettingOutOfPenaltyBox;

    public Player(String name) {
        this.name = name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return gettingOutOfPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        this.gettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }

    public String currentCategory() {
        if (getPlace() == 0) return "Pop";
        if (getPlace() == 4) return "Pop";
        if (getPlace() == 8) return "Pop";
        if (getPlace() == 1) return "Science";
        if (getPlace() == 5) return "Science";
        if (getPlace() == 9) return "Science";
        if (getPlace() == 2) return "Sports";
        if (getPlace() == 6) return "Sports";
        if (getPlace() == 10) return "Sports";
        return "Rock";
    }

    public void setCurrentPosition(int roll) {
        setPlace(getPlace() + roll);
        if (getPlace() > 11) setPlace(getPlace() - 12);

        System.out.println(getName()
                + "'s new location is "
                + getPlace());
        System.out.println("The category is " + currentCategory());
    }

    public boolean isWinner(String s) {
        System.out.println(s);
        setPurses(getPurses() + 1);
        System.out.println(getName()
                + " now has "
                + getPurses()
                + " Gold Coins.");
        return didPlayerWin();
    }

    private boolean didPlayerWin() {
        return !(getPurses() == 6);
    }
}
