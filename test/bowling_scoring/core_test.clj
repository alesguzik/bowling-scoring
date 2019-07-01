(ns bowling-scoring.core-test
  (:require [clojure.test :refer :all]
            [bowling-scoring.core :refer :all]))

(deftest valid-throw-test
  (testing "Valid throws"
    (is (valid-throw? 0))
    (is (valid-throw? 6))
    (is (valid-throw? 10)))

  (testing "Invalid throws"
    (is (not (valid-throw? -1)))
    (is (not (valid-throw? 11)))
    (is (not (valid-throw? "2")))
    (is (not (valid-throw? nil)))))

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
