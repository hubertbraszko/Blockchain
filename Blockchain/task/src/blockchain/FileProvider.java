package blockchain;

import java.io.File;
import java.io.IOException;

public class FileProvider {

    private File file;

    public boolean createNewFile() {
        file = new File("data.txt");
        boolean createdNew = false;
        try {
            createdNew = file.createNewFile();

        } catch (IOException e) {
            System.out.println("Cannot create the file: " + file.getPath());
        }
        return createdNew;
    }

    public File getFile() {
        return file;
    }

}
