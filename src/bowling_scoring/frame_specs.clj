(ns bowling-scoring.frame-specs
  (:require
   [clojure.spec.alpha :as s]))

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
