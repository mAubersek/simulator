void main() {
    Machine machine = new Machine();
    machine.getDevice(3).write((byte) 'A');
    machine.getDevice(3).write((byte) 'B');
    System.out.println(machine.getDevice(3).read());
    System.out.println(machine.getDevice(3).read());
    System.out.println(machine.getDevice(3).read());
    System.out.println(machine.getDevice(3).read());
    int a = 21;
}