package Model;

public class Adult {
    private double age;
    private String workclass;
    private int fnlwgt;
    private String education;
    private int educationNum;
    private String materialStatus;
    private String occupation;
    private String relationship;
    private String race;
    private String sex;
    private double capitalGain;
    private double capitalLoss;
    private double hourPerWeek;
    private String nativeCountry;
    private String salary;
    public Adult(
            double age,
            String workclass, 
            int fnlwgt, 
            String education, 
            int educationNum, 
            String materialStatus,
            String occupation, 
            String relationship, 
            String race, 
            String sex, 
            double capitalGain,
            double capitalLoss,
            double hourPerWeek,
            String nativeCountry,
            String salary
    ) {
        this.age = age;
        this.workclass = workclass;
        this.fnlwgt = fnlwgt;
        this.education = education;
        this.educationNum = educationNum;
        this.materialStatus = materialStatus;
        this.occupation = occupation;
        this.relationship = relationship;
        this.race = race;
        this.sex = sex;
        this.capitalGain = capitalGain;
        this.capitalLoss = capitalLoss;
        this.hourPerWeek = hourPerWeek;
        this.nativeCountry = nativeCountry;
        this.salary = salary;
    }

    public double getAge() {
        return age;
    }
    
    public String getWorkclass() {
        return workclass;
    }
    
    public int getFnlwgt() {
        return fnlwgt;
    }
    
    public String getEducation() {
        return education;
    }
    
    public int getEducationNum() {
        return educationNum;
    }
    
    public String getMaterialStatus() {
        return materialStatus;
    }
    
    public String getOccupation() {
        return occupation;
    }
    
    public String getRelationship() {
        return relationship;
    }
    
    public String getRace() {
        return race;
    }
    
    public String getSex() {
        return sex;
    }
    
    public double getCapitalGain() {
        return capitalGain;
    }
    
    public double getCapitalLoss() {
        return capitalLoss;
    }
    
    public double getHourPerWeek() {
        return hourPerWeek;
    }
    
    public String getNativeCountry() {
        return nativeCountry;
    }
    
    public String getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Adult [age=" + age + ", capitalGain=" + capitalGain + ", capitalLoss=" + capitalLoss + ", education="
                + education + ", educationNum=" + educationNum + ", fnlwgt=" + fnlwgt + ", hourPerWeek=" + hourPerWeek
                + ", materialStatus=" + materialStatus + ", nativeCountry=" + nativeCountry + ", occupation="
                + occupation + ", race=" + race + ", relationship=" + relationship + ", salary=" + salary + ", sex="
                + sex + ", workclass=" + workclass + "]";
    }

    
}