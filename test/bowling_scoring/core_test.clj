(ns bowling-scoring.core-test
  (:require [clojure.test :refer :all]
            [bowling-scoring.core :as bs]))

(deftest valid-throw-test
  (testing "Valid throws"
    (are [n] (bs/valid-throw? n)
      0
      6
      10))

  (testing "Invalid throws"
    (are [n] (not (bs/valid-throw? n))
      -1
      11
      "2"
      nil)))

(deftest score-cards
  (testing "Basic usage example"
    (is (= (-> (make-score-card)
               (add-throw 1)
               (add-throw 4)
               (add-throw 5)
               (add-throw 2)
               (add-throw 10)
               (add-throw 4))
           {}))))
