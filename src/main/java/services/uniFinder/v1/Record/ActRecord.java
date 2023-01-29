package services.uniFinder.v1.Record;

public class ActRecord {
    int english;
    int writing;
    int math;

    public ActRecord(int critical_reading, int writing, int math) {
        this.english = critical_reading;
        this.writing = writing;
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public int getWriting() {
        return writing;
    }

    public int getMath() {
        return math;
    }

    @Override
    public String toString() {
        return "ActRecord{" +
                "English=" + english +
                ", Writing=" + writing +
                ", Math=" + math +
                '}';
    }
}
