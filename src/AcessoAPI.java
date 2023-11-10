import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

public class AcessoAPI {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        useClient();
    }

    

    private static void useClient() throws IOException, InterruptedException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL"); // OR TLS
        sslContext.init(null, new TrustManager[]{MOCK_TRUST_MANAGER}, new SecureRandom());

        HttpClient client = HttpClient.newBuilder().sslContext(sslContext)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://nunki.mba.corp/api/v1/azha/clients"))
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJmaWJyYWxpbmsubmV0LmJyIiwiYXVkIjoiYXpoYS5maWJyYWxpbmsubmV0LmJyIiwic3ViIjoiNiIsIm5hbWUiOiJhemhhIiwiaWF0IjoxNjkzNDAyNTU3fQ.1oWdZ-A21rGIliJnzd0wF8Ep3v20BnA5rwgdwraSOYQ")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println("Status using headers: {}" + response.statusCode());
    }

    /**
     *
     */
    private static final TrustManager MOCK_TRUST_MANAGER = new X509ExtendedTrustManager() {
        
        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
            // empty method
        }

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'checkClientTrusted'");
        }

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'checkClientTrusted'");
        }

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
                throws CertificateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'checkClientTrusted'");
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'checkServerTrusted'");
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
                throws CertificateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'checkServerTrusted'");
        }

        // ... Other void methods
    };
}
