import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Arrays;

/**
 * Created by admin on 4/7/17.
 */
public class TelematicsImpl implements Telematics {

    private ObjectMapper mapper = new ObjectMapper();
    private VehicleInfo[] vehicleInfos = new VehicleInfo[10];

    @Override
    public void report(VehicleInfo vehicleInfo) throws IOException {

        String json = mapper.writeValueAsString(vehicleInfo);
        System.out.println("\n\tThe vehicle json is:\n\t " + json);

        //TODO put this is a try-with resource to close
        try (PrintWriter pw = new PrintWriter(new FileWriter(vehicleInfo.getVin() + ".json"))) {
            pw.printf(json);
            pw.flush();
        }

        int counter = 0;
        double odometerTotal = 0.0;
        double consumptionTotal = 0.0;
        double oilChangeTotal = 0.0;


        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                String jsonFromFile;
                VehicleInfo vehicleInfo2;
                try (BufferedReader br = new BufferedReader(new FileReader(f.getName()))) {
                    jsonFromFile = br.readLine();
                    System.out.println("\n\tVehicle info back from the file is:\n\t " + jsonFromFile);
                    br.close();
                }

                vehicleInfo2 = mapper.readValue(jsonFromFile, VehicleInfo.class);
                System.out.println("\n\tVehicle info creates another: \n\t " + vehicleInfo2);
                vehicleInfos[counter] = vehicleInfo2;
                counter++;
                odometerTotal += vehicleInfo2.getOdometer();
                consumptionTotal += vehicleInfo2.getConsumption();
                oilChangeTotal += vehicleInfo2.getLastOilChange();
            }
        }
        System.out.println(Arrays.toString(vehicleInfos));


        String temp = Telematics.HTML.replace("num_vehicles", "" + counter);
        temp = temp.replace("odometer_average", "" + (odometerTotal / counter));
        temp = temp.replace("consumption_average", "" + (consumptionTotal / counter));
        temp = temp.replace("oc_average", "" + (oilChangeTotal / counter));

        try (PrintWriter pw = new PrintWriter(new FileWriter("dashboard.html"))) {
            pw.printf(temp);
            pw.flush();
        }

    }
}