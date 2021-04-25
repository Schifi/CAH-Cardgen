package de.schifi.cahcardgen.generator;

public class Card {

    // Card attributes
    private int width;
    private int height;
    private CardType cardType;
    private String text;
    private String packname;

    // Constructors
    public Card(int width, int height, CardType cardType) {
        this.width = width;
        this.height = height;
        this.cardType = cardType;
    }

    public Card(int width, int height) {
        this(width, height, CardType.WHITE);
    }

    public Card() {
        this(1000, 1000);
    }

    // Getters and Setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPackname() {
        return packname;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }

}
