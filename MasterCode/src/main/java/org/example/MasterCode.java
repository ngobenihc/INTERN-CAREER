package org.example;

public class MasterCode {

    private final Player thePlayer;
    private final String masterMindCode;

    private static int digitInCorrectPlace = 0;
    private static int digitInWrongPlace = 0;
    int numberOfLives = ;

    public MasterCode(GeneratorRanNumCode generator, Player player) {
        this.masterMindCode = generator.generateCode();
        this.thePlayer = player;

    }

    public MasterCode() {
        this(new GeneratorRanNumCode(), new Player());
    }

    public void isCorrect(String guess) {
        digitInCorrectPlace = 0;
        digitInWrongPlace = 0;
        for (int i = 0; i < 4; i++) {
            if (masterMindCode.charAt(i) == guess.charAt(i)) {
                digitInCorrectPlace += 1;
            } else if (masterMindCode.contains(String.valueOf(guess.charAt(i)))) {
                digitInWrongPlace += 1;
            }
        }
    }

    public void runGame() {

        System.out.println("4-digit Code has been set. Digits in range 1 to 8. You have 10 turns to break it.");

        while (true) {
            String guess = thePlayer.getGuess();
            isCorrect(guess);

            if (guess.equals(masterMindCode)) {
                System.out.println("Number of correct digits in correct place: " + digitInCorrectPlace);
                System.out.println("Number of correct digits not in correct place: " + digitInWrongPlace);
                System.out.println("Congratulations! You are a codebreaker!");
                System.out.println("The code was: " + masterMindCode);
                break;
            } else if (numberOfLives <= 1) {
                System.out.println("Number of correct digits in correct place: " + digitInCorrectPlace);
                System.out.println("Number of correct digits not in correct place: " + digitInWrongPlace);
                System.out.println("No more turns left.");
                System.out.println("The code was: " + masterMindCode);
                break;
            } else if (guess.equalsIgnoreCase("quit") || guess.equalsIgnoreCase("exit")) {
                break;
            } else {
                numberOfLives -= 1;
                System.out.println("Number of correct digits in correct place: " + digitInCorrectPlace);
                System.out.println("Number of correct digits not in correct place: " + digitInWrongPlace);
                System.out.println("Turns left: " + numberOfLives);
                //System.out.println("The code was: " + masterMindCode);

            }

        }
    }
}
