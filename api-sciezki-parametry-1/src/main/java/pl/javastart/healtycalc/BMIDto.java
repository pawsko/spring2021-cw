package pl.javastart.healtycalc;

class BMIDto {
    private final double weight;
    private final double height;
    private final int bmi;
    private final String type;

    public BMIDto(double weight, double height, int bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        if (bmi < 18.4) {
            this.type = "Underweight";
        } else if (bmi < 24.9) {
            this.type = "Normal";
        } else if (bmi < 29.9) {
            this.type = "Overweight";
        } else {
            this.type = "Obese";
        }
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getBmi() {
        return bmi;
    }

    public String getType() {
        return type;
    }
}
