package blockchain;

public class BlockFactory {



    public static Block newBlock(String hashOfPrevious, int numOfZeros) {
        return new Block(hashOfPrevious, numOfZeros, Thread.currentThread().getId());

    }

}
