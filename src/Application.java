import java.util.Scanner;

public class Application {

    VerhovnaRada verhovnaRada = new VerhovnaRada();

    void menu() {
        System.out.println("\n Введіть 1 щоб додати фракцію(Рекомендую спочатку обрати цей пунк і створити декілька партій)\n " +
                " Введіть 2 щоб видалити конкретну фракцію\n" +
                " Введіть 3 щоб вивести усі  фракції\n" +
                " Введіть 4 щоб очистити конкретну фракцію\n" +
                " Введіть 5 щоб вивести конкретну фракцію\n" +
                " Введіть 6 щоб додати депутата в фракцію(Другим пунктом рекомендую створити депутатів для фракцій)\n" +
                " Введіть 7 щоб видалити депутата з фракції\n"+
                " Введіть 8 щоб вивести найбільшого хабарника з яоїсь партії(Спочатку рекомендую спробувати дати взятку :) )\n"+
                " Введіть 9 щоб дати взятку певному депутату\n"

        );

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "1": {
                verhovnaRada.addFaction();
                break;
            }
            case "2": {
                verhovnaRada.removeFaction();
                break;
            }
            case "3": {
                verhovnaRada.seeAllFactions();
                break;
            }
            case "4":{
                verhovnaRada.clearSomeFaction();
                break;
            }
            case "5":{
                verhovnaRada.seeAllDeputiesInSomeFaction();
                break;

            }
            case "6":{
                verhovnaRada.addDeputyInSomeFaction();
                break;
            }
            case "7":{
                verhovnaRada.removeDeputyFromSomeFaction();
                break;
            }
            case "8":{
                verhovnaRada.theBiggestSizeOfBribleInSomeFaction();
                break;
            }
            case "9":{
                verhovnaRada.giveBribleToDeputyFromSomeFaction();
                break;
            }
            default:{
                try{throw new IllegalArgumentException();}
                catch (IllegalArgumentException exception){
                    System.out.println("Команди на цю кнопку не запрограмовано. Виберіть зі списку: ");
                }
            }
        }
    }

    
    public static void main(String[] args) {
        Application application = new Application();
        while (true){
            application.menu();
        }
    }

}






