(ns slack-gen.mygen
  (:require [clojure.test.check.generators :as gen]
            [slack-schema.schemas :as t]))


(def message (gen/hash-map :text gen/string-alphanumeric))


;;
;; Channel name
;;

(def channel-name-char (gen/elements t/channel-name-allowed-chars))
(def disallowed? (partial contains? #{"_" "-"}))

;; Can't be all underscores, or all dashes. Can be a combo of the two
;; (by observation)
(defn disallowed? [channel-name]
  (or (t/all-underscores? channel-name) (t/all-dashes? channel-name)))

(def channel-name (gen/no-shrink
                  (gen/such-that (complement disallowed?)
                                 (gen/fmap (partial apply str)
                                           (gen/vector channel-name-char 1 21)))))
