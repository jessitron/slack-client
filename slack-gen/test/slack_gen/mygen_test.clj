(ns slack-gen.mygen-test
 (:require [clojure.test :refer [use-fixtures is]]
            [slack-gen.mygen :as subject]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [schema.test]
            [schema.core :as s]
            [slack-schema.schemas :as t]))


(defspec messages-spec 10
  (prop/for-all [msg subject/message]
                (is (nil? (s/check t/Message msg)))))

(defspec channel-name-spec 20
  (prop/for-all [chname subject/channel-name]
                (is (nil? (s/check t/ChannelName chname)))))
