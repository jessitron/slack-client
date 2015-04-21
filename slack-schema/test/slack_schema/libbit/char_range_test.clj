(ns slack-schema.libbit.char-range-test
  (:require [clojure.test :refer [deftest is testing]]
            [slack-schema.libbit.char-range :as subject]))

;; minimal pathetic example

(deftest better-than-nothing
  (is (= [\a \b \c] (subject/char-range \a \c))))



