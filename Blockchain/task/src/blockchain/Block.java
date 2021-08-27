package blockchain;

import java.util.Date;

public class Block {

    private int id;
    private long timestamp;
    private String hashOfPrevious;
    private String hash;
    private static int numOfBlocks;

    Block(String hashOfPrevious) {

        this.id = ++numOfBlocks;
        this.timestamp = new Date().getTime();
        this.hashOfPrevious = hashOfPrevious;
        this.hash = StrUtil.applySha256(getStringToHash());

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
                + hashOfPrevious;
        return ret;
    }

    @Override
    public String toString() {
        String block = "Block:" + "\n"
                + "Id: " + String.valueOf(id) + "\n"
                + "Timestamp: " + timestamp + "\n"
                + "Hash of the previous block: " + "\n" + hashOfPrevious + "\n"
                + "Hash of the block: " + "\n" + hash + "\n";
        return block;
    }

}
