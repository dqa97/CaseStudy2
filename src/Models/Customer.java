package Models;

public class Customer {
    private String name;
    private String age;
    private String cmt;


    public Customer(){}

    public Customer(String name, String age, String cmt){
        this.name = name;
        this.age = age;
        this.cmt = cmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

}
