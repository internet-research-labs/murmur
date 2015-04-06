(defproject murmur "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.google.guava/guava "15.0"]
                 [junit/junit "4.11"]]

  ;; Source stuff
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  :java-source-paths ["src/main/java" "src/test/java"]
  :junit ["src/test/java"]

  ;; Compilation stuff
  :javac-options ["-target" "1.7" "-source" "1.7" "-Xlint:-options" "-Xlint:unchecked" "-XDignore.symbol.file"]
  :jvm-opts ["-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector" "-Djava.library.path=."]
  :resource-paths ["src/test/resources"]

  :plugins [[venantius/ultra "0.1.9"]
            [s3-wagon-private "1.1.2"]
            [lein-environ "1.0.0"]
            [lein-junit "1.1.8"]]

  :main murmur.core
  :license {:name "UNLICENSE" :url "http://unlicense.org/"}
  :profiles {:dev {:dependencies [[junit/junit "4.11"]]}})
