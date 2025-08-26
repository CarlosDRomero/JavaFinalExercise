package university;

public class PartTimeTeacher extends Teacher{
    float activeHoursPerWeek;

    public PartTimeTeacher(String name, float baseSalary, float activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    float calculateSalary() {
        return getBaseSalary() * activeHoursPerWeek;
    }
    public String toString() {
        return super.toString() + ", por horas semanales";
    }
}
