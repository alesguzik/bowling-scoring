(ns bowling-scoring.core-test
  (:require [clojure.test :refer :all]
            [bowling-scoring.core :refer :all]))

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
