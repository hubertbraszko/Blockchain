package blockchain;


import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain = new ArrayList<>();



    public void addBlock(int numOfZeros) {
        if( chain.size() == 0) {
            chain.add(new Block("0",numOfZeros));
        } else {
            String hashOfPrevious = chain.get(chain.size()-1).getHash();
            chain.add(new Block(hashOfPrevious,numOfZeros));
        }
    }

    public void validate() {
        //TODO
    }

    public void printBlockchain() {
        for(var block : chain) {
            System.out.println(block.toString());
        }
    }

}
