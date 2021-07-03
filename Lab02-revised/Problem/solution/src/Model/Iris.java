package Model;
public class Iris {
    private double s_length;
    private double s_width;
    private double p_length;
    private double p_width;
    private String type;

    public Iris(double value1, double value2, double value3, double value4, String type) {
        this.s_length = value1;
        this.s_width = value2;
        this.p_length = value3;
        this.p_width = value4;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getS_length() {
        return s_length;
    }

    public double getS_width() {
        return s_width;
    }

    public double getP_length() {
        return p_length;
    }

    public double getP_width() {
        return p_width;
    }

    @Override
    public String toString() {
        return "Iris [" + 
                "type=" + type + 
                ", value1=" + s_length + 
                ", value2=" + s_width + 
                ", value3=" + p_length + 
                ", value4=" + p_width + 
            "]";
    }
    
}
