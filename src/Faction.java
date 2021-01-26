import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Faction {

    List <Deputy>   deputies  = new ArrayList<>();
    String name;

    public Faction(String name) {
        this.name = name;
    }

    Supplier<Deputy> getDeputy = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть імя");
        String name = scanner.next();
        System.out.println("Введіть прізвище");
        String surname = scanner.next();
        return new Deputy(name,surname);
    };


    Supplier<Deputy> fullInfoDeputy =()->{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть імя депутата");
        String name = scanner.nextLine();
        System.out.println("Введіть прізвище депутата");
        String surname = scanner.nextLine();
        System.out.println("Введіть бере від взятки чи ні(true або false)");
        boolean bribler =  scanner.nextBoolean();
        System.out.println("Введіть ріст депутата");
        float height = scanner.nextFloat();
        System.out.println("Введіть вагу депутата");
        float weight = scanner.nextFloat();
      return new Deputy(weight,height,name,surname,bribler);
    };


    void    addDeputy(){
            Deputy deputy = fullInfoDeputy.get();
            deputies.add(deputy);
    }


    void removeDeputy(){
        if (deputies.size()<1){
            System.out.println("У вашій фракції ще немає депутатів! Спочатку добавте їх!");
        }
        else{
            Deputy DP = getDeputy.get();
            Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(DP.getSurname()) && deputy.getName().equalsIgnoreCase(DP.getName());
            Optional<Deputy> deputyFound = deputies.stream().filter(isEqualSurnameName).findFirst();
            if (deputyFound.isPresent()) {
                deputies.remove(deputyFound.get());
                System.out.println("Депутат " + deputyFound.get().toString() + " видалений.");
            } else {
                System.out.println("Такого депутата немає");
            }
        }
    }

    void seeAllBriblers(){
        List<Deputy> briblers = deputies.stream().filter(Deputy::getBribler).collect(Collectors.toList());
        briblers.forEach(System.out::println);
    }

    void seeAllDeputies(){
        deputies.forEach(System.out::println);
    }

    void theBiggestSizeOfBribe(){
        Comparator<Deputy> deputyBribeSizeComparator = (deputy1, deputy2) ->
                (deputy1.getSizeOfbribe() > deputy2.getSizeOfbribe()) ? 1
                : (deputy1.getSizeOfbribe() == deputy2.getSizeOfbribe()) ? 0 : -1;
        Optional<Deputy> thebiggestBribler = deputies.stream().filter(Deputy::getBribler)
                .max(deputyBribeSizeComparator);
        if (thebiggestBribler.isPresent()){
            System.out.println("найбільший взяточник " + thebiggestBribler.get().toString());
        } else {
            System.out.println("В данной партии взяточников нет!");
        }
        }

    void deleteAllDeputiesFromFaction(){
        if (deputies.size()<1){
            System.out.println("Ви не можете очистити фракцію оскільки вона і так пуста :( ");
        }
        else {
            deputies.clear();
            System.out.println("Фракцію успішно  очищено.");
        }


    }

    void brible(){
        Deputy DP = getDeputy.get();
        Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(DP.getSurname()) && deputy.getName().equalsIgnoreCase(DP.getName());
        Optional<Deputy> deputyFound = deputies.stream().filter(isEqualSurnameName).findFirst();
        if (deputyFound.isPresent()) {
            deputyFound.get().takeBrible();
        }
        else System.out.println("нема такого депутата");
    }

    public List<Deputy> getDeputies() {
        return deputies;
    }

    public String getName() {
        return name;
    }

    public Supplier<Deputy> getGetDeputy() {
        return getDeputy;
    }

    public Supplier<Deputy> getFullInfoDeputy() {
        return fullInfoDeputy;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "name='" + name + '\'' +
                '}';
    }
}
