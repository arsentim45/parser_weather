import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class reader {
    private static StringBuilder reading(Reader myReader) throws IOException {
        StringBuilder myStringBuilder = new StringBuilder();
        while (myReader.read() != -1) {
            int page = myReader.read();
            myStringBuilder.append((char) page);
        }
        return myStringBuilder;
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException, IOException {
        InputStream myInputStream = new URL(url).openStream();
        BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(myInputStream, Charset.forName("UTF-8")));
        String jsonText = String.valueOf(reading(myBufferedReader));
        myInputStream.close();
        return new JSONObject(jsonText);
    }
}
