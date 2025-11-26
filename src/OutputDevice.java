import java.io.IOException;
import java.io.OutputStream;

public class OutputDevice extends Device {
    private final OutputStream out;

    public OutputDevice(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(byte val) {
        try {
            out.write(val & 0xFF);
        } catch (IOException _) {}
    }

}
