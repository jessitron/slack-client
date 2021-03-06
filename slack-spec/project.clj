(defproject slack-spec "0.1.0-SNAPSHOT"
  :description "specifications for slack client"
  :url "http://github.com/jessitron/slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; really all dependencies here are test dependencies
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/test.check "0.6.2"]
                 [prismatic/schema "0.3.3"]
                 [jessitron/slack "0.1.0-SNAPSHOT"]
                 [jessitron/slack-gen "0.1.0-SNAPSHOT"]]
)


