public class Runner {
    public static void main(String[] args) throws InputErrorException {
        Collage collage =  new Collage("My Collage");
        collage.add_student("123","jhon", 12,3.7f);
        collage.add_student("1234","jhon", 12,3.7f);
        collage.add_student("1235","jhon", 12,3.7f);
        collage.add_employ("222","theman",33,9000);
    }
}
