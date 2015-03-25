(ns slack-spec.core-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [slack-gen.mygen :as slgen]
            [slack.core :as slack]
            [slack-gen.testkit :refer [with-new-channel]]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(defspec reads-the-stuff
  (prop/for-all [list-o-messages (gen/vector slgen/message)]
                (with-new-channel :containing list-o-messages
                  (fn [ch]
                    (let [messages (slack/read-all ch)]
                      (is (= list-o-messages messages)))))))
