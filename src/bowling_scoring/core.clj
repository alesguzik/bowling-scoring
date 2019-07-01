(ns bowling-scoring.core
  (:require [clojure.spec.alpha :as s]))

(defn strike-throw? [n] (= n 10))

(defn non-strike-throw? [n]
  (and (int? n)
       (<= 0 n 9)))

(defn valid-throw? [n]
  (or (non-strike-throw? n) (strike-throw? n)))

(s/def ::open-frame
  (s/and (s/cat :first-throw valid-throw? :second-throw valid-throw?)
         #(< (+ (:first-throw %) (:second-throw %)) 10)))

(s/def ::regular-strike #(= [10] %))

(s/def ::regular-spare
  (s/and (s/cat :first-throw valid-throw? :second-throw valid-throw?)
         #(not= (:first-throw %) 10)
         #(= (+ (:first-throw %) (:second-throw %)) 10)))

(s/def ::regular-frame
  (s/or :open-frame ::open-frame
        :spare ::regular-spare
        :strike ::regular-strike))

(s/def ::last-spare
  (s/and
   (s/cat :first-throw non-strike-throw? :second-throw valid-throw? :third-throw valid-throw?)
   #(= (+ (:first-throw %) (:second-throw %)) 10)))

(s/def ::last-strike
  (s/and
   (s/cat :regular-strike #(= % 10)
          :second-throw valid-throw?
          :third-throw valid-throw?)
   #(or (= (:second-throw %) 10)
        (<= (+ (:second-throw %) (:third-throw %)) 10))))

(s/def ::last-frame
  (s/or :open-frame ::open-frame
        :last-spare ::last-spare
        :last-strike ::last-strike))

(defn validate [spec data]
  (let [result (s/conform spec data)]
    (when (not= result ::s/invalid)
      result)))

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
