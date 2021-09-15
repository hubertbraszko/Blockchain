package blockchain;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {


    private List<Block> chain = new ArrayList<>();
    private long delta;
    private long LastBlockTimeAsSeconds = LocalTime.now().toSecondOfDay();
    int numOfZeros = 2;
    long desiredDeltaTime = 10;


    public synchronized boolean addBlock(Block block) {
        if(validateNewBlock(block)) {

            delta = LocalTime.now().toSecondOfDay() - LastBlockTimeAsSeconds;
            LastBlockTimeAsSeconds = LocalTime.now().toSecondOfDay();

            block.setNumOfZerosMessage(regulate());

            chain.add(block);
;
            return true;
        }
        return false;
    }

    private boolean validateNewBlock(Block block) {

        for (int i = 0 ; i < numOfZeros ; i++) {
            if(block.getHash().charAt(i) != '0') {return false;}
        }

        if(getLatestBlockHash().equals(block.getHashOfPrevious())) {
            return true;
        }
        return false;

    }



    private String regulate() {
        String message = "N stays the same";
        if(delta > desiredDeltaTime + 5) {
            numOfZeros--;
            message = "N decreased by 1";
        }
        else if (delta < desiredDeltaTime - 5){
            numOfZeros++;
            message = "N increased to " + numOfZeros;
        }
        return message;
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

    public int getNumOfZeros() {
        return numOfZeros;
    }

    public void setNumOfZeros(int numOfZeros) {
        this.numOfZeros = numOfZeros;
    }
}
