import java.util.Scanner;

public class Deputy extends Human {

    String name;
    String surname;
    Boolean bribler ;
    double sizeOfbribe = 0;

    public Deputy(float weight, float height, String name, String surname, Boolean bribler) {
        super(weight, height);
        this.name = name;
        this.surname = surname;
        this.bribler = bribler;
    }

    public Deputy( String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    void takeBrible(){

        if (!bribler){
            System.out.println("Цей депутат не бере хабарів");
        }
        else {
            System.out.println("Введіть суму хабаря: ");
            Scanner scanner =  new Scanner(System.in);
            double temp=0;
            try{temp = scanner.nextDouble();
                this.sizeOfbribe += temp;}
            catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
            if (temp>5000){
                System.out.println("Поліція увязнить депутата");
            }

        }

    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getBribler() {
        return bribler;
    }

    public double getSizeOfbribe() {
        return sizeOfbribe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBribler(Boolean bribler) {
        this.bribler = bribler;
    }

    public void setSizeOfbribe(double sizeOfbribe) {
        this.sizeOfbribe = sizeOfbribe;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
