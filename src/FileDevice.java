import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDevice extends Device {
    private static final String PATH = "./files/";
    private RandomAccessFile file = null;
    private final String filename;

    public FileDevice(String filename) {
        this.filename = filename;
    }

    private void createFile() {
        try {
            file = new RandomAccessFile(PATH + filename, "rw");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int read() {
        if (file == null) {
            createFile();
        }
        try {
            int val = file.read();
            if (val == -1) {
                return 0;
            }
            return val; // TODO & 0xFF??
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public void write(byte val) {
        if (file == null) {
            createFile();
        }
        try {
            file.write(val & 0xFF);
        } catch (IOException _) {}
    }
}
