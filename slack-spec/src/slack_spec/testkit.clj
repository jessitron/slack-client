(ns slack-spec.testkit
  (:require [slack.core :as slack]
            [schema.core :as s]
            [clojure.test.check.generators :as gen]
            [slack-schema.schemas :as t]
            [schematron.core :refer [defgen]]
            [slack-spec.libbit.sample-one :refer [sample-one]]
            [slack-gen.mygen :as slgen]))

(s/defn nonexistent? [ch :- t/ChannelName]
  "Not implemented"
  true)

;; TODO: stick a :- in defgen's expected args
(defgen new-channel-name t/ChannelName (gen/such-that nonexistent? slgen/channel-name))

(s/defn populate [ch :- t/ChannelId
                  messages :- [t/Message]]
  (doseq [m messages]
    (slack/send ch m)))

;; TODO: specify relationships
(s/defn with-new-channel [_ :- (s/eq :containing)
                          messages
                          f :- => s/Any t/ChannelId]
  (let [channel-name (sample-one slgen/channel-name)
        channel-id (slack/create-channel channel-name)
        _ (populate channel-id messages)]
    (f channel-id)))
