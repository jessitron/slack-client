(defproject jessitron/slack-schema "0.1.0-SNAPSHOT"
  :description "schemas that describe the Slack APIs"
  :url "http://github.com/jessitron/slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/test.check "0.7.0"]
                 [clj-time "0.9.0"]
                 [jessitron/var-schema "0.1.0"]
                 [prismatic/schema "0.3.7"]])
