(ns slack-gen.libbit.sample-one
  (:require [clojure.test.check.generators :as gen]
            [schema.core :as s]))

;; TODO - this is where I want to say "generator of A" and "this returns an A"
(defn sample-one [g :- (s/record clojure.test.check.generators.Gen)]
  (last (gen/sample g)))
