public class Machine {
    private static final int MAX_ADDRESS = 0xFFFFF;
    private static final int NUMBER_OF_DEVICES = 256;
    private int regA;
    private int regX;
    private int regL;
    private int regB;
    private int regS;
    private int regT;
    private double regF;
    private int regPC;
    private int regSW;
    private final byte[] memory = new byte[MAX_ADDRESS];
    private Device[] devices = new Device[NUMBER_OF_DEVICES];

    public Machine() {
        devices[0] = new InputDevice(System.in);
        devices[1] = new OutputDevice(System.out);
        devices[2] = new OutputDevice(System.err);
        for (int i = 3; i < NUMBER_OF_DEVICES; i++) {
            try {
                devices[i] = new FileDevice(i + ".dev");
            } catch (Exception _) {}
        }
    }

    public int getA() {
        return regA;
    }

    public void setA(int regA) {
        this.regA = regA;
    }

    public int getX() {
        return regX;
    }

    public void setX(int regX) {
        this.regX = regX;
    }

    public int getL() {
        return regL;
    }

    public void setL(int regL) {
        this.regL = regL;
    }

    public int getB() {
        return regB;
    }

    public void setB(int regB) {
        this.regB = regB;
    }

    public int getS() {
        return regS;
    }

    public void setS(int regS) {
        this.regS = regS;
    }

    public int getT() {
        return regT;
    }

    public void setT(int regT) {
        this.regT = regT;
    }

    public double getF() {
        return regF;
    }

    public void setF(double regF) {
        this.regF = regF;
    }

    public int getPC() {
        return regPC;
    }

    public void setPC(int regPC) {
        this.regPC = regPC;
    }

    public int getSW() {
        return regSW;
    }

    public void setSW(int regSW) {
        this.regSW = regSW;
    }

    public int getReg(int reg) {
        return switch (reg) {
            case 0 -> regA;
            case 1 -> regX;
            case 2 -> regL;
            case 3 -> regB;
            case 4 -> regS;
            case 5 -> regT;
            case 6 -> (int) regF; //TODO
            case 8 -> regPC;
            case 9 -> regSW;
            default -> throw new IllegalArgumentException("Invalid register index");
        };
    }

    private void checkAddress(int address) {
        if (address < 0 || address > MAX_ADDRESS) {
            throw new IllegalArgumentException("Invalid register index");
        }
    }

    public int getByte(int address) {
        checkAddress(address);
        return memory[address] & 0xFF;
    }

    public void setByte(int address, int val) {
        checkAddress(address);
        memory[address] = (byte) val;
    }

    public int getWord(int address) {
        return (getByte(address) << 16)
             | (getByte(address + 1) << 8)
             |  getByte(address + 2);
    }

    public void setWord(int address, int val) {
        setByte(address, val >> 16);
        setByte(address + 1, val >> 8);
        setByte(address + 2, val);
    }

    public Device getDevice(int ix) {
        return devices[ix];
    }

    public void setDevice(int ix, Device device) {
        devices[ix] = device;
    }

    //TODO setFloat, getFloat
    /*
    Definirajte še metodi za dostop do pomnilnka po floatih. Kako velik je float v SIC/XE?
    double getFloat(int addr)
    void setFloat(int addr, double val)
    Namig: v Javi znata biti koristni metodi Double.doubleToLongBits() in Double.longBitsToDouble(…).
    */
}
