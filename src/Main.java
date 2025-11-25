void main() {
    Machine machine = new Machine();
    machine.setByte(0, 0x12);
    machine.setByte(1, 0x34);
    machine.setByte(2, 0x56);
    machine.setWord(3, 0x123456);
    System.out.println(machine.getWord(3));
}