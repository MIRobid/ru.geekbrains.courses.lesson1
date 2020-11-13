import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook implements Comparable{
    private String name;
    private int number;

    void add(String name, int number){
        this.name=name;
        this.number=number;
    }

    @Override
    public int compareTo(Object o){
        PhoneBook another = (PhoneBook) o;
        if(this.number>another.number){
            return 1;
        }
        if(this.number<another.number){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString(){
        return "PhoneBook: "+name;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> pb=new HashMap<>();
        pb.put("Trump",555223);
        pb.put("Baiden",1112233);
        pb.put("Harris",7773322);
        pb.put("Pence",2223344);
        System.out.println(pb);

    }
}
