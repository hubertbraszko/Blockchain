package blockchain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        //int numOfZeros = UserInterface.getNumOfZeros();
        int poolSize = Runtime.getRuntime().availableProcessors();

        ExecutorService miners = Executors.newFixedThreadPool(poolSize);

        Blockchain blockchain = new Blockchain();

        for (int i = 0;i<5;i++) {

            miners.submit(() -> {
                blockchain.addBlock(BlockFactory.newBlock(blockchain.getLatestBlockHash(), blockchain.getNumOfZeros()));
            });

        }


        blockchain.printBlockchain();

        miners.shutdown();


    }
}
