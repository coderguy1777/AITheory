

public class DataSetReader {
    public String classnumber = "";
    public int Datapoint = 0;
    public double DataDecimal = 0.0;
    public int inputx;
    public int inputy;


    public DataSetReader(String classnumber, int Datapoint, double DataDecimal) {
        this.classnumber = classnumber;
        this.Datapoint = Datapoint;
        this.DataDecimal = DataDecimal;
    }
    public int EquationSolver() {
        return inputx/inputy * inputx/inputy/2;
    }

    public  String toString() {
        return (classnumber + "\n" + inputx/inputy + "\t" + Datapoint/inputx + inputy * 2 *  Math.exp(DataDecimal));
    }
}


