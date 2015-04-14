(ns slack-gen.libbit.sample-one-test
  (:require [clojure.test :refer [deftest is testing]]
            [slack-gen.libbit.sample-one :as subject]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [schema.test]
            [schema.core :as s]))

(clojure.test/use-fixtures :once schema.test/validate-schemas)

(deftest returns-one
  (is (= 1 (subject/sample-one (gen/return 1)))))
