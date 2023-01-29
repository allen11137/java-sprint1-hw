public class Converter {
    final double STEP_LENGTH = 0.75;
    final int KM = 1000;
    final int CAL_TO_STEP = 50;
    final int KCAL = 1000;

    int convertToKm(int steps) {
        return (int) (steps * STEP_LENGTH / KM);
    }

    int convertStepsToKilocalories(int steps) {
        return steps * CAL_TO_STEP / KCAL;
    }
}
