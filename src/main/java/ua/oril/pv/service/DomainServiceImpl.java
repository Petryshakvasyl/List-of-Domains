package ua.oril.pv.service;

import org.springframework.stereotype.Service;
import ua.oril.pv.entity.Domain;
import ua.oril.pv.entity.DomainStatus;

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

    public void addDomain(Domain domain) throws IOException {

        if(isDomainSafe(domain)){
            domain.setDomainStatus(DomainStatus.SAFE);
            System.out.println(domain.getName() + " is SAFE");
        }else {
            domain.setDomainStatus(DomainStatus.DANGEROUS);
            System.out.println(domain.getName() + " is DANGEROUS");
        }
        domainDao.create(domain);
    }
    private boolean isDomainSafe(Domain domain) throws IOException {

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
        String receive = "";
        int code = con.getResponseCode();
        do {
            String line = in.readLine();
            if (line == null)
                break;
            receive += line;
        } while (true);
        in.close();
       return  receive.equals("{}");
    }
}
