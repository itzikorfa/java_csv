import java.util.Objects;

public abstract class Person {
    private String id;
    private String name;
    private int age;


    public Person(String id, String name, int age) throws InputErrorException{
        this(id,name);
        this.age = age;
    }

    public Person(String id, String name) throws InputErrorException{
        this.setId(id);
        this.setName(name);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) throws InputErrorException {
        if (id.length()>0)
            this.id = id;
        else throw new InputErrorException("ID error");
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InputErrorException{
        if (id.length()>0)
            this.name = name;
        else throw new InputErrorException("name input error");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InputErrorException{
        if (age < 0)
            this.age = age;
        else throw new InputErrorException("age input error");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder db = new StringBuilder();
        db.append(this.id);
        db.append(";");
        db.append(this.name);
        db.append(";");
        db.append(this.age);

        return db.toString();
    }

}
