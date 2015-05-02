(ns slack-spec.testkit-test
  (:require [clojure.test :refer [deftest is testing]]
            [slack-gen.testkit :as subject]))

;; test something, at least it'll catch compile errors

(deftest nonexistent?-test
  (testing "this one always exists"
    (is (not (nonexistent? "general")))))
