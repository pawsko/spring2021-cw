package pl.javastart.healtycalc;

import org.springframework.stereotype.Service;

@Service
class BodyWeightCalculator {
    private static final int BMR_CONSTANT_MAN = 5;
    private static final int BMR_CONSTANT_WOMAN = -161;

    int calculateBMI(double weight, double height) {
        return (int)(weight / Math.pow(height / 100, 2));
    }

    int calculateBMR(double weight, double height, int age, String gender) {
        int s = switch (gender) {
            case "man" -> BMR_CONSTANT_MAN;
            case "woman" -> BMR_CONSTANT_WOMAN;
            default -> throw new IllegalArgumentException("Invalid gender " + gender);
        };
        return (int)(10 * weight + (6.25 * height) - (5 * age) + s);
    }
}
