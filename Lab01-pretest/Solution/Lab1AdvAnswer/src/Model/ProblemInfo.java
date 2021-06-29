package Model;

public class ProblemInfo {
    private String vendorName;
    private String modelName;
    private int MYCT;
    private int MMIN;
    private int MMAX;
    private int CACH;
    private int CHMIN;
    private int CHMAX;
    private int PRP;
    private int ERP;
    public ProblemInfo(
        String vendorName, 
        String modelName, 
        int mYCT, 
        int mMIN, 
        int mMAX,
        int cACH, 
        int cHMIN,
        int cHMAX, 
        int pRP, 
        int eRP
    ) {
        this.vendorName = vendorName;
        this.modelName = modelName;
        this.MYCT = mYCT;
        this.MMIN = mMIN;
        this.MMAX = mMAX;
        this.CACH = cACH;
        this.CHMIN = cHMIN;
        this.CHMAX = cHMAX;
        this.PRP = pRP;
        this.ERP = eRP;
    }

    public int getERP() {
        return ERP;
    }

    public int getPRP() {
        return PRP;
    }
    
    public String getVendorName() {
        return vendorName;
    }

    public int getCACH() {
        return CACH;
    }

    @Override
    public String toString() {
        return "ProblemInfo [" + 
                    "CACH=" + CACH + 
                  ", CHMAX=" + CHMAX + 
                  ", CHMIN=" + CHMIN + 
                  ", ERP=" + ERP + 
                  ", MMAX=" + MMAX +
                  ", MMIN=" + MMIN + 
                  ", MYCT=" + MYCT + 
                  ", PRP=" + PRP + 
                  ", modelName=" + modelName + 
                  ", vendorName="+ vendorName + "]";
    }
    

}
