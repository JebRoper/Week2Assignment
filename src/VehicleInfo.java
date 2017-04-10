/**
 * Created by admin on 4/7/17.
 */
public class VehicleInfo {

    private String vin;
    private double odometer;
    private double consumption;
    private double lastOilChange;
    private String engineSize;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getLastOilChange() {
        return lastOilChange;
    }

    public void setLastOilChange(double lastOilChange) {
        this.lastOilChange = lastOilChange;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "vin='" + vin + '\'' +
                ", odometer=" + odometer +
                ", consumption=" + consumption +
                ", lastOilChange=" + lastOilChange +
                ", engineSize='" + engineSize + '\'' +
                '}';
    }
}
