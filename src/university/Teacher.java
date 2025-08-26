package university;

public abstract class Teacher {
    // Aqui lo hago final porque teóricamente no se cambiaría el nombre de un profesor (creo 🤔)
    private final String name;
    private float baseSalary;

    public Teacher(String name, float baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    abstract float calculateSalary();
}
