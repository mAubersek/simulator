import java.io.IOException;
import java.io.InputStream;

public class InputDevice extends Device {
    private final InputStream ins;

    public InputDevice(InputStream ins) {
        this.ins = ins;
    }

    @Override
    public int read() {
        try {
            int val = ins.read();
            if (val == -1) {
                return 0;
            }
            return val;
        } catch (IOException e) {
            return 0;
        }
    }
}
