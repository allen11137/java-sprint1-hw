class MonthData {
    int [] days = new int[30];

    void printDaysAndStepsFromMonth() {
        System.out.println("количество пройденных шагов по дням");
        for (int i = 0; i < 30; i++) {
            int steps = days[i];
            System.out.printf("%d день: %d.\n", i + 1, steps);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            int steps = days[i];
            if (maxSteps < steps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        int day = 0;
        for (int i = 0; i < 30; i++) {
            int steps = days[i];
            if (steps >= goalByStepsPerDay && bestSession < 1) {
                bestSession = 1;
                day = i;
            } else if (steps >= goalByStepsPerDay && day == i - 1) {
                bestSession += 1;
                day = i;
            } else if (bestSession >= 1 && day != i - 1) {
                bestSession = 0;
            }
            if (countBest < bestSession) {
                countBest = bestSession;
            }
        }
        return countBest;
    }

    int middleCountSteps() {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps += days[i];
        }
        return sumSteps / 30;
    }
}