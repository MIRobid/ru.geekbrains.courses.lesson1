package lesson1;

public class Employee {
    private String name;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, long phone, int salary, int age){
        this.name=name;
        this.position=position;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
    }

    public Employee(){
        this.name="Unknown";
        this.position="Unknown";
        this.email="info@company.com";
        this.phone=998900000000L;
        this.salary=0;
        this.age=30;
    }

    public void info() {
        System.out.format("Name: %s\nPosition: %s\nEmail: %s\nPhone: %d\nSalary: %d\nAge: %s\n", name,position,email,phone,salary,age);
        System.out.println();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        if(age>=0&&age<=130){
            this.age=age;
        }else{
            System.out.println(age+" is incorrect. Using default age: "+this.age);
        }
    }

    public static void main(String[] args) {
        Employee ivan = new Employee();
        ivan.setAge(150);
        ivan.info();

        Employee[] empArray=new Employee[5];
        empArray[0]=new Employee("Ivan", "Founder", "i@mail.ru", 998900000001L, 100000, 30);
        empArray[1]=new Employee("Masha", "Account", "m@mail.ru", 998900000002L, 80000, 28);
        empArray[2]=new Employee("John", "CTO", "j@mail.ru", 998900000003L, 120000, 42);
        empArray[3]=new Employee("Katya", "Marketing", "k@mail.ru", 998900000004L, 90000, 27);
        empArray[4]=new Employee("Chester", "Administrator", "c@mail.ru", 998900000005L, 70000, 45);

        for(int i=0;i<empArray.length;i++){
            if(empArray[i].getAge()>40) {
                empArray[i].info();
            }
        }
    }

}
