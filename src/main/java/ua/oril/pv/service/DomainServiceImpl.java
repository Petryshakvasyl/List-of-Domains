package ua.oril.pv.service;

import org.springframework.stereotype.Service;
import ua.oril.pv.entity.Domain;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;


/**
 * Created by pevsat on 02.09.2016.
 */
@Service
public class DomainServiceImpl extends BaseServiceImpl<Domain>  implements DomainService{

      public boolean isDomainSafe(Domain domain) throws IOException {

        String portUrl = "https://safebrowsing.googleapis.com/v4/threatMatches:find?key=AIzaSyABZN36Ezh9x8apmfEtaNJTbjsj4k62oZE";
        URL url = new URL(portUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        String requestBody = "{'client':{" +
                " 'clientId':      'Oril.pv', " +
                " 'clientVersion': '1'" +
                "  }," +
                "        'threatInfo': {" +
                "        'threatTypes':      ['MALWARE', 'SOCIAL_ENGINEERING']," +
                "        'platformTypes':    ['WINDOWS']," +
                "        'threatEntryTypes': ['URL']," +
                "        'threatEntries': [" +
                "           {\"url\": \"http://" + domain.getName() + "\"}" +
                "       ]" +
                "    }" +
                " }";

        OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
        out.write(requestBody);
        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder receive = new StringBuilder("");
        do {
            String line = in.readLine();
            if (line == null)
                break;
            receive.append(line);
        } while (true);
        in.close();
        String responce = "{}";
       return  responce.equals(receive.toString());
    }
}
