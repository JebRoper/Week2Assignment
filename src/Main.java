import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Telematics telematics = new TelematicsImpl();

        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVin("123456");
        vehicleInfo.setOdometer(48888);
        vehicleInfo.setConsumption(25000);
        vehicleInfo.setLastOilChange(45000);
        vehicleInfo.setEngineSize("engine is 4.5");

        System.out.println("the vehicle info is:\n\t " + vehicleInfo);
        telematics.report(vehicleInfo);


        vehicleInfo = new VehicleInfo();
        vehicleInfo.setVin("223456");
        vehicleInfo.setOdometer(65000);
        vehicleInfo.setConsumption(35000);
        vehicleInfo.setLastOilChange(60000);
        vehicleInfo.setEngineSize("engine is 4.5");

        System.out.println("the vehicle info is:\n\t " + vehicleInfo);
        telematics.report(vehicleInfo);

    }
}
