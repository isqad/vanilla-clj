(defproject vanilla "0.1.0-SNAPSHOT"
  :description "Vanilla is open social network"
  :url "http://vanilla.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.3-1104-jdbc41"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]
                 [selmer "0.9.3"]]
                 
  :plugins      [[lein-ring "0.9.7"]]
  :ring {:handler vanilla.handler/app}
  :main ^:skip-aot vanilla.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
