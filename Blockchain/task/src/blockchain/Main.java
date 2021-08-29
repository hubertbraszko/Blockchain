package blockchain;

public class Main {
    public static void main(String[] args) {

        int numOfZeros = UserInterface.getNumOfZeros();

        Blockchain blockchain = new Blockchain();

        for (int i = 0;i<5;i++) {
            blockchain.addBlock(numOfZeros);
        }

        blockchain.printBlockchain();

    }
}
