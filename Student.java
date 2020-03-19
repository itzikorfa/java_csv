public class Student extends Person {
    private float gpa;

    public Student(String id, String name, int age, float gpa) throws InputErrorException {
        super(id, name, age);
        this.gpa = gpa;
    }


    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) throws InputErrorException{
        if (gpa >0 || gpa <=5)
            this.gpa = gpa;
        else throw new InputErrorException("gpa error");
    }

    public String   toString(){
        return super.toString()+";"+this.gpa;
    }
}
