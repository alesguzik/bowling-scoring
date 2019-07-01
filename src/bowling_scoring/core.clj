(ns bowling-scoring.core
  (:require [clojure.spec.alpha :as s]))

(defn valid-throw? [n]
  (and (int? n)
       (<= 0 n 10)))

(s/def ::open-frame
  (s/and (s/cat :first-throw valid-throw? :second-throw valid-throw?)
         #(< (+ (:first-throw %) (:second-throw %)) 10)))

(defn make-score-card []
  {:accept :new-frame ; :new-frame :current-frame :done
   :frames []})

(defn add-throw [card throw-result]
  )

(defn valid-regular-frame? [frame]
  (and
   (= 2 (count frame))
   ))

(defn valid-last-frame? [frame]
  )

(defn valid-frame? [frame-number frame]
  (if (< frame-number 10)
    (valid-regular-frame? frame)
    (valid-last-frame? frame)))

(defn add-frame [card frame]
  )

(comment
  (-> (make-score-card)
      (add-throw 1)
      (add-throw 4)
      (add-throw 5)
      (add-throw 2)
      (add-throw 10)
      (add-throw 4)
      ))
