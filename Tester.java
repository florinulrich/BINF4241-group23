public class Tester {

    public static void main(String[] args) throws Exception {

        testGameClass();
    }

    private static void testGameClass() throws Exception {
        Game game = new Game(20);

        //Land on square 8, which is not last
        ISquare landedSquare = game.findSquare(4,4);
        if (landedSquare.isLastSquare()) {throw new Exception("Middle element is set as last");}
    }

    private static void testGameRunnerClass() {}
}
