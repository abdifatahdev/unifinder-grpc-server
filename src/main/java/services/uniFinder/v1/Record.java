package services.uniFinder.v1;

public class Record {
    private SatRecord satRecord;
    private ActRecord actRecord;

    public Record(SatRecord satRecord, ActRecord actRecord) {
        this.satRecord = satRecord;
        this.actRecord = actRecord;
    }

    public SatRecord getSatRecord() {
        return satRecord;
    }

    public ActRecord getActRecord() {
        return actRecord;
    }

    @Override
    public String toString() {
        return "Record{" +
                "satRecord=" + satRecord +
                ", actRecord=" + actRecord +
                '}';
    }
}
