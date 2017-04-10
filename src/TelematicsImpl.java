import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Arrays;

/**
 * Created by admin on 4/7/17.
 */
public class TelematicsImpl implements Telematics {

    private ObjectMapper mapper = new ObjectMapper();
    private VehicleInfo[] vehicleInfos = new VehicleInfo[2];

    @Override
    public void report(VehicleInfo vehicleInfo) throws IOException {

        String json = mapper.writeValueAsString(vehicleInfo);
        System.out.println("\n\tThe vehicle json is:\n\t " + json);

        //TODO put this is a try-with resource to close
        try (PrintWriter pw = new PrintWriter(new FileWriter(vehicleInfo.getVin() + ".json"))) {
            pw.println(json);
            pw.flush();
        }

        int counter = 0;
        double odometerTotal = 0.0;
        double consumptionTotal = 0.0;
        double oilChangeTotal = 0.0;
        double sizeTotal = 0.0;
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f". You can use this in the FileReader constructor
                // new FileReader(f)
                //CHANGE BACK TO VEHICLEINFO, MOVE INTO THE ARRAY
                BufferedReader br = new BufferedReader(new FileReader(f.getName()));
                String jsonFromFile = br.readLine();
                System.out.println("\n\tVehicle info back from the file is:\n\t " + jsonFromFile);
                br.close();

                VehicleInfo vehicleInfo2 = mapper.readValue(jsonFromFile, VehicleInfo.class);
                System.out.println("\n\tVehicle info creates another: \n\t " + vehicleInfo2);
                vehicleInfos[counter] = vehicleInfo2;
                counter++;
                odometerTotal += vehicleInfo2.getOdometer();
                consumptionTotal += vehicleInfo2.getConsumption();
                oilChangeTotal += vehicleInfo2.getLastOilChange();
                sizeTotal += vehicleInfo2.getEngineSize();
            }
        }
        System.out.println(Arrays.toString(vehicleInfos));



        String temp = Telematics.HTML.replace("num_vehicles", "" + counter);
        temp = temp.replace("odometer_average" , "" + (odometerTotal/vehicleInfos));
            //need to divide the total of the odometer by the number of vehicles in the array
        temp = temp.replace("consumption_average", "" + ("consumptionTotal/vehicleInfos"));
                //total consumption needs to be dvided by total number of vehicles
        temp = temp.replace("oc_average", "" + ("oilChangeTotal/vehicleInfos"));
                //oil change total divided number of vehicles in the array
        temp=temp.replace("es_average", "" + (sizeTotal/vehicleInfos));
                //size total divided by number of vehicles in the array

        try (PrintWriter pw = new PrintWriter(new FileWriter("dashboard.html"))) {
            pw.println(temp);
            pw.flush();
        }

    }
}