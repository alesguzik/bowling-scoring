(ns bowling-scoring.specs
  (:require
   [bowling-scoring.frame-specs :as fs]
   [clojure.spec.alpha :as s]))

(defn validate [spec data]
  (let [result (s/conform spec data)]
    (when (not= result ::s/invalid)
      result)))

(defn regular-frame? [data] (validate ::fs/regular-frame data))
(defn last-frame? [data] (validate ::fs/last-frame data))
