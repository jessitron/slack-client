(ns slack.core-test
  (:require [clojure.test :refer :all]
            [slack.core :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [schema.test]))

(use-fixtures :once schema.test/validate-schemas)

(deftest a-test
  (testing "yaya"
    (is (= 1 1))))
