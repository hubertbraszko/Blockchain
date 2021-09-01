package blockchain;


import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain = new ArrayList<>();



    public boolean addBlock(Block block) {
        if(validateNewBlock(block)) {
            chain.add(block);
            return true;
        }
        return false;
    }

    private boolean validateNewBlock(Block block) {
        //TODO
        if(getLatestBlockHash().equals(block.getHashOfPrevious())) {
            return true;
        }
        return false;

    }

    public String getLatestBlockHash() {
        if(chain.isEmpty()) {return "0";}
        return chain.get(chain.size() - 1).getHash();

    }

    public void printBlockchain() {
        for(var block : chain) {
            System.out.println(block.toString());
        }
    }

}
