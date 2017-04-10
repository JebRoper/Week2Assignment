import java.io.IOException;

/**
 * Created by admin on 4/7/17.
 */
public interface Telematics {

    void report(VehicleInfo vehicleInfo) throws IOException;

    String HTML = "<html>\n" +
            "<title>Vehicle Telematics Dashboard</title>\n" +
            "<body>\n" +
            "<h1 align=\"center\">Averages for num_vehicles vehicles</h1>\n" +
            "<table align=\"center\">\n" +
            "    <tr>\n" +
            "        <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td align=\"center\">odometer_average</td><td align=\"center\">consumption_average</td><td align=\"center\">oc_average</td align=\"center\"><td align=\"center\">es_average</td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "<h1 align=\"center\">History</h1>\n" +
            "<table align=\"center\" border=\"1\">\n" +
            "    <tr>\n" +
            "        <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td align=\"center\">0123456</td><td align=\"center\">111.1</td><td align=\"center\">222.2</td><td align=\"center\">333.3</td align=\"center\"><td align=\"center\">2.0</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "</body>\n" +
            "</html>\n";


}
