import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Не верный ввод.");
            return;
        }
        MonthData monthToDatum = monthToData[month];

        System.out.println("Введите день от 1 до 30(включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Не верный ввод.");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Не верный ввод.");
            return;
        }
        monthToDatum.days[day - 1] = steps;
    }

    void changeStepGoal() {
        int stepGoals = scanner.nextInt();
        if (stepGoals < 1) {
            System.out.println("Не верный ввод.");
            return;
        }
        goalByStepsPerDay = stepGoals;
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Не верный ввод.");
            return;
        }
        MonthData monthToDatum = monthToData[month];

        monthToDatum.printDaysAndStepsFromMonth();

        int sumSteps = monthToDatum.sumStepsFromMonth();
        System.out.printf("общее количество шагов за месяц: %d. \n", sumSteps);

        int maxSteps = monthToDatum.maxSteps();
        System.out.printf("максимальное количество шагов в месяце было: %d. \n", maxSteps);

        int middleCountSteps = monthToDatum.middleCountSteps();
        System.out.printf("среднее количество шагов: %d. \n", middleCountSteps);

        System.out.printf("пройденная дистанция (в км): %d. \n", new Converter().convertToKm(sumSteps));

        System.out.printf("количество сожжённых килокалорий: %d. \n", new Converter().convertStepsToKilocalories(sumSteps));

        int bestSeries = monthToDatum.bestSeries(goalByStepsPerDay);
        System.out.printf("лучшая серия: %d. \n", bestSeries);
    }
}