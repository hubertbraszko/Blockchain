package blockchain;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Block {

    private int id;
    private long timestamp;
    private String hashOfPrevious;
    private String hash;
    private static int numOfBlocks;
    private long magicNumber = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    private long generationTime;


    Block(String hashOfPrevious,int numOfZeros) {

        this.id = ++numOfBlocks;
        this.timestamp = new Date().getTime();
        this.hashOfPrevious = hashOfPrevious;
        this.hash = StrUtil.applySha256(getStringToHash());

        while(!hasNumOfZeros(numOfZeros)) {
            magicNumber = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
            this.hash = StrUtil.applySha256(getStringToHash());
        }

        generationTime = new Date().getTime() - timestamp;

    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getHashOfPrevious() {
        return hashOfPrevious;
    }

    public String getHash() {
        return hash;
    }

    public static int getNumOfBlocks() {
        return numOfBlocks;
    }

    private String getStringToHash(){
        String ret = String.valueOf(id)
                + String.valueOf(timestamp)
                + String.valueOf(magicNumber)
                + hashOfPrevious;

        return ret;
    }

    @Override
    public String toString() {
        String block = "Block:" + "\n"
                + "Id: " + String.valueOf(id) + "\n"
                + "Timestamp: " + timestamp + "\n"
                + "Magic number: " + magicNumber + "\n"
                + "Hash of the previous block: " + "\n" + hashOfPrevious + "\n"
                + "Hash of the block: " + "\n" + hash + "\n"
                + "Block was generating for " + generationTime/1000 +  " seconds" + "\n";
        return block;
    }

    private boolean hasNumOfZeros(int numOfZeros) {
        for (int i = 0 ; i < numOfZeros ; i++) {
            if(this.hash.charAt(i) != '0') {return false;}
        }
        return true;
    }

}
