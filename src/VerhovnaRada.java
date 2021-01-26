import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VerhovnaRada {

    List<Faction> factions  = new ArrayList<>();

    Supplier<Faction> getFaction = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції: ");
        String faction = scanner.next();

        return new Faction(faction);
    };


    public Optional<Faction> findDeputyGroup() {
        Faction DeputyGroupTyped = getFaction.get();

        Predicate<Faction> isEqualDeputyGroupName = faction -> faction.getName().equalsIgnoreCase(DeputyGroupTyped.getName());
        Optional<Faction> deputyGroupFound = factions.stream().filter(isEqualDeputyGroupName).findFirst();

        return deputyGroupFound;
    }

    void addFaction(){
            factions.add(getFaction.get());
            System.out.println("Фракція успішно створена");
    }

    void removeFaction(){
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            factions.remove(faction.get());
            System.out.println(faction.get().toString() + " видалена");
        } else {
            System.out.println("Такої фракції немає");
        }
    }

    void seeAllFactions(){
        System.out.println("Всі фракції що є у верховінй раді:");
        factions.forEach(System.out::println);
    }

    void addDeputyInSomeFaction(){
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().addDeputy();
        }
        else System.out.println("Немає такої фракції ");

    }

    void removeDeputyFromSomeFaction(){
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().removeDeputy();
        }
        else System.out.println("Немає такої фракції ");

    }

    void seeAllBriblesInSomeFaction(){
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().seeAllBriblers();
        }
        else System.out.println("Немає такої фракції ");

    }

    void theBiggestSizeOfBribleInSomeFaction(){

        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().theBiggestSizeOfBribe();
        }
        else System.out.println("Немає такої фракції ");

    }

    void seeAllDeputiesInSomeFaction(){
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().seeAllDeputies();
        }
        else System.out.println("Немає такої фракції ");
    }

    void clearSomeFaction(){
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().deleteAllDeputiesFromFaction();
        }
        else System.out.println("Немає такої фракції");
    }

    void giveBribleToDeputyFromSomeFaction() {
        Optional<Faction> faction = findDeputyGroup();
        if (faction.isPresent()) {
            faction.get().brible();
        } else System.out.println("Немає такої фракції ");
    }
}
