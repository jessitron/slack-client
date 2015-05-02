(ns slack-spec.libbit.sample-one
  (:require [clojure.test.check.generators :as gen]
            [schema.core :as s]))

;; TODO - this is where I want to say "generator of A" and "this returns an A"
(s/defn sample-one
  [g :- (s/record clojure.test.check.generators.Generator {:gen s/Any})]
  (last (gen/sample g)))
