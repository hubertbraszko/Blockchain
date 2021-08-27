package blockchain;


import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain = new ArrayList<>();



    public void addBlock() {
        if( chain.size() == 0) {
            chain.add(new Block("0"));
        } else {
            String hashOfPrevious = chain.get(chain.size()-1).getHash();
            chain.add(new Block(hashOfPrevious));
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
