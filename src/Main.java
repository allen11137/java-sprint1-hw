import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                System.out.println("Выполняется команда 1");
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                System.out.println("Выполняется команда 2");
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                System.out.println("Выполняется команда 3");
                stepTracker.printStatistic();
            } else if (i == 4) {
                System.out.println("До новых встреч!");
                scanner.close();
                return;

            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("1 - ввести количество шагов за определённый день;\n" +
                "2 - изменить цель по количеству шагов в день;\n" +
                "3 - напечатать статистику за определённый месяц;\n" +
                "4 - выйти из приложения.");
    }
}