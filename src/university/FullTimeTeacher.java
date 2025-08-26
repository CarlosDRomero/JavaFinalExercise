package university;

public class FullTimeTeacher extends Teacher{
    float experienceYears;

    public FullTimeTeacher(String name, float baseSalary, float experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    float calculateSalary() {
        return getBaseSalary() * experienceYears * 1.1f;
    }
}
