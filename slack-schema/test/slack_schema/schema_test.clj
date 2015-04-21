(ns slack-schema.schema-test
  (:require [slack-schema.schemas :as subject :refer [ChannelName
                                                      max-channel-name-len]]
            [clojure.test :refer [deftest is testing]]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.properties :as prop]
            [clj-time-gen.generators :as clj-time-gen]
            [schema.core :as s]))


;; Here, I mostly want to hit all the schemas at least once to see if they compile.
;; This is also a chance to double-check that they do what I want. And document them
;; with examples if that's helpful.

(deftest channel-name-test
  (testing "the canonical channel"
    (is (nil? (s/check ChannelName "general"))))
  (testing "lowercase and digits are cool"
    (is (nil? (s/check ChannelName "abcd01234567890xyz"))))
  (testing "underscores and dashes are fine"
    (is (nil? (s/check ChannelName "_yo-yo_yo-"))))
  (testing "Polish lowercase, not accepted"
    (is (not (nil? (s/check ChannelName "cześć")))))
  (testing "empty is bad"
    (is (not (nil? (s/check ChannelName "")))))
  (testing "21 chars is OK"
    (is (nil? (s/check ChannelName (apply str (repeat max-channel-name-len "x"))))))
  (testing "22 chars is not OK"
    (is (not (nil? (s/check ChannelName (apply str (repeat (inc max-channel-name-len) "x")))))))
  (testing "Combination of underscores and dashes, OK"
    (is (nil? (s/check ChannelName "_-"))))
  (testing "all underscores is not OK"
    (is (not (nil? (s/check ChannelName "____")))))
  (testing "all dashes is not OK"
    (is (not (nil? (s/check ChannelName "----"))))))

(deftest channel-test
  (let [one-valid-channel {:id "dfkjdk" :name "random"}]
    (testing "one valid channel"
      (is (nil? (s/check subject/ChannelInfo one-valid-channel))))
    (testing "must have id"
      (is (not (nil? (s/check subject/ChannelInfo (dissoc one-valid-channel :id))))))))

;; Timestamps

;; TODO: implement when I have internet
;; (or fix the functions so they round-trip OK)
#_(defn within-a-second? [d1 d2]
  (clj-time.core/interval d1 d2))
#_(defspec slack-timestamp-round-trip 30
         (prop/for-all [someday clj-time-gen/datetime]
                       (is (within-a-second? someday (subject/slack-timestamp->date (subject/date->slack-timestamp someday))))))
