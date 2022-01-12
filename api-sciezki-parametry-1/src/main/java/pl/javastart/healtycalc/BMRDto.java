package pl.javastart.healtycalc;

class BMRDto {
    private final String gender;
    private final double weight;
    private final double height;
    private final int age;
    private final int bmr;

    public BMRDto(String gender, double weight, double height, int age, int bmr) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.bmr = bmr;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getBmr() {
        return bmr;
    }
}
