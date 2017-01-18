package com.cstructor.androidinterfaces;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;

public class WebHelper {
    protected URL baseUrl;

    public WebHelper(String baseUrl) throws Exception {
        this.baseUrl = new URL(baseUrl);
    }

    public String PostQuery(Map<String, String> queryParams, String path, String body, String contentType) throws Exception {
        HttpURLConnection urlConnection = null;
        try {
            String query = BuildQuery(queryParams);
            URL url = new URL(baseUrl + path + "?" + query);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", contentType);
            urlConnection.setRequestProperty("User-Agent", getUserAgent());

            // POST
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            out.write(body.getBytes("UTF-8"));
            out.flush();

            int httpResult = urlConnection.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String output;
            StringBuffer sb = new StringBuffer();

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //int size = in.available();
            //byte[] buffer = new byte[size];
            //in.read(buffer);

            out.close();
            //in.close();

            String result = sb.toString();
            return result;
        } catch (Exception ex) {
            String s = ex.toString();
        }
        finally{
            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }

        return null;
    }

    private String getUserAgent()
    {
        String httpAgentString = "";
        Properties properties = System.getProperties();

        String httpAgent = System.getProperty("http.agent");
        if (httpAgent != null) {
            httpAgentString = httpAgent.replace(")", "").replace(" (", "; ");
        }
        else {
            String osName = System.getProperty("os.name");
            String osArch = System.getProperty("os.arch");
            String javaVersion = System.getProperty("java.version");

            httpAgentString = String.format("%s; %s; Java %s", osName, osArch, javaVersion);
        }

        return httpAgentString;
    }

    private String BuildQuery(Map<?, ?> queryParams) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<?, ?> entry : queryParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }

        return sb.toString();
    }

    static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
