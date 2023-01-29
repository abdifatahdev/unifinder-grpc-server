package services.uniFinder.v1.Record;

public class SatRecord {
    int critical_reading;
    int writing;
    int math;

    public SatRecord(int critical_reading, int writing, int math) {
        this.critical_reading = critical_reading;
        this.writing = writing;
        this.math = math;
    }

    public int getCritical_reading() {
        return critical_reading;
    }

    public int getWriting() {
        return writing;
    }

    public int getMath() {
        return math;
    }

    @Override
    public String toString() {
        return "Act_record{" +
                "critical_reading=" + critical_reading +
                ", writing=" + writing +
                ", math=" + math +
                '}';
    }
}
