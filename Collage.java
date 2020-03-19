import java.util.ArrayList;
import java.util.HashMap;

public class Collage {
    private HashMap<String,String > prop;
    private ArrayList<Employ> employes;
    private ArrayList<Student> students;
    private String name;

    public Collage(String name) throws InputErrorException {
        this.name = name;
        init();
    }

    private void init() throws InputErrorException {
        prop = FileHandler.readProperties(ConstNames.PROP_FILE_NAME);
        if (prop.isEmpty()){
            create_properties();
            prop = FileHandler.readProperties(ConstNames.PROP_FILE_NAME);
        }
        //read students
        getStudentents();
        getEmploys();
    }


    private void getStudentents() throws InputErrorException {
        String stuData = FileHandler.readFile(prop.get(ConstNames.STUDENTS));
        students = new ArrayList<Student>();
        if(stuData.length()>0){
            String[] records = stuData.split("\n");
            for (String rec: records) {
                String[] dat = rec.split(";");
                students.add(new Student(dat[0],dat[1],
                        Integer.parseInt(dat[2]),
                        Float.parseFloat(dat[3])));
            }
        }
    }
    private void getEmploys() throws InputErrorException {
        String data = FileHandler.readFile(prop.get(ConstNames.EMPLOYS));
        employes = new ArrayList<Employ>();
        if(data.length()>0) {
            String[] records = data.split("\n");
            for (String rec: records) {
                String[] dat = rec.split(";");
                employes.add(new Employ(dat[0],dat[1],
                        Integer.parseInt(dat[2]),
                        Integer.parseInt(dat[3])));
            }
        }
    }

    public void add_student(String id, String name, int age, float gpa) throws InputErrorException {
        Student temp = new Student(id,name,age,gpa);
        students.add(temp);
        FileHandler.saveArrayListToFile(students, prop.get(ConstNames.STUDENTS));
        getStudentents();

    }

    public void add_employ(String id, String name, int age, int salary) throws InputErrorException {
        Employ temp = new Employ(id,name,age,salary);
        employes.add(temp);
        FileHandler.saveArrayListToFile(employes,prop.get(ConstNames.EMPLOYS));
        getEmploys();

    }


    public static void create_properties(){
        HashMap<String, String> prop = new HashMap<>();
        prop.put(ConstNames.STUDENTS,"students.csv");
        prop.put(ConstNames.EMPLOYS,"employs.csv");
        FileHandler.setProperties(prop,ConstNames.PROP_FILE_NAME);

    }


}
