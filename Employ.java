public class Employ extends Person {
    private int salery;

    public Employ(String id, String name, int age, int salery) throws InputErrorException {
        super(id, name, age);
        this.salery = salery;
    }

    @Override
    public String toString() {
        return super.toString()+";"+ this.salery;
    }
}
