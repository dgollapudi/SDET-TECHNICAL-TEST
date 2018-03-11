package Utils;



import com.sun.corba.se.spi.ior.ObjectId;

import java.util.HashMap;

/**
 * Created by dgollapudi on 07/03/2018.
 */
public class Session {
    public static HashMap<String, Object> sessionVars;
    public static ObjectId sessionId;

    public static void createSession()
    {
        sessionVars = new HashMap<>();
        //testReport = new TestReport();

        //testReport.environment = System.getProperty("envConfig");
        //testReport.started = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(new Date().getTime());

        if(sessionId == null)
        {
            //sessionId = new PaymentsDatabase().createTestRunEntry(feature);
        }
    }

}
