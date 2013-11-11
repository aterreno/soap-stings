(defproject soap-stings "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "WTFPL"
            :url "http://www.wtfpl.net/txt/copying/"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [axis/axis "1.4"]
                 [javax.mail/mail "1.4.7"]
                 [stingray/stingray "1.2"]
                 [cheshire "5.2.0"]
                 [ring/ring-json "0.2.0"]
                 [compojure "1.1.6"]
                 [ring/ring-jetty-adapter "0.3.7"]]
  :source-paths ["src" "src/clojure"]
  :ring {:handler soap-stings.handler/app}
  :java-source-paths ["src/java"]
  :plugins [[lein-localrepo "0.5.2"]]
  :main soap-stings.main
  :aot [soap-stings.main]
  :wsimport { :wsdl-list [
    "wsdl/AFM.wsdl" "wsdl/AlertCallback.wsdl" "wsdl/Alerting.Action.wsdl" "wsdl/Alerting.EventType.wsdl" "wsdl/Catalog.Aptimizer.Profile.wsdl" "wsdl/Catalog.Authenticators.wsdl" "wsdl/Catalog.Bandwidth.wsdl"
    "wsdl/Catalog.JavaExtension.wsdl" "wsdl/Catalog.Monitor.wsdl" "wsdl/Catalog.Persistence.wsdl" "wsdl/Catalog.Protection.wsdl" "wsdl/Catalog.Rate.wsdl" "wsdl/Catalog.Rule.wsdl" "wsdl/Catalog.SLM.wsdl"
    "wsdl/Catalog.SSL.CertificateAuthorities.wsdl" "wsdl/Catalog.SSL.Certificates.wsdl" "wsdl/Catalog.SSL.ClientCertificates.wsdl" "wsdl/Catalog.SSL.DNSSEC.wsdl" "wsdl/Conf.Extra.wsdl" "wsdl/Conf.Extra_1_0.wsdl"
    "wsdl/Diagnose.wsdl" "wsdl/Diagnose_1_0.wsdl" "wsdl/GLB.Service.wsdl" "wsdl/GlobalSettings.wsdl" "wsdl/Location.wsdl" "wsdl/Pool.wsdl" "wsdl/System.AccessLogs.wsdl" "wsdl/System.Backups.wsdl" "wsdl/System.Cache.wsdl"
    "wsdl/System.Cache_1_0.wsdl" "wsdl/System.Cache_1_1.wsdl" "wsdl/System.CloudCredentials.wsdl" "wsdl/System.Connections.wsdl" "wsdl/System.LicenseKeys.wsdl" "wsdl/System.Log.wsdl" "wsdl/System.MachineInfo.wsdl"
    "wsdl/System.Management.wsdl" "wsdl/System.RequestLogs.wsdl" "wsdl/System.Stats.wsdl" "wsdl/System.Steelhead.wsdl" "wsdl/TrafficIPGroups.wsdl" "wsdl/Users.wsdl" "wsdl/VirtualServer.wsdl"]})
