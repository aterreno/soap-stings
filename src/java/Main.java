import com.zeus.soap.zxtm._1_0.VirtualServerLocator;
import com.zeus.soap.zxtm._1_0.VirtualServerPort;

import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;

public class Main {

    public static void main( String[] args ) {
        Security.addProvider(new MyProvider());
        Security.setProperty( "ssl.TrustManagerFactory.algorithm", "TrustAllCertificates");
    }

    public static class MyProvider extends Provider {
        public MyProvider() {
            super( "MyProvider", 1.0, "Trust certificates" );
            put( "TrustManagerFactory.TrustAllCertificates", MyTrustManagerFactory.class.getName() );
        }
        protected static class MyTrustManagerFactory extends TrustManagerFactorySpi {
            public MyTrustManagerFactory() {}
            protected void engineInit( KeyStore keystore ) {}
            protected void engineInit(
                    ManagerFactoryParameters mgrparams ) {}
            protected TrustManager[] engineGetTrustManagers() {
                return new TrustManager[] { new MyX509TrustManager() };
            }
        }
        protected static class MyX509TrustManager implements X509TrustManager {
            public void checkClientTrusted( X509Certificate[] chain, String authType) {}
            public void checkServerTrusted( X509Certificate[] chain, String authType) {}
            public X509Certificate[] getAcceptedIssuers() { return null; }
        }
    }
}