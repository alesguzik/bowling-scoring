(ns bowling-scoring.core-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
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

(deftest open-frame-spec-test
  (testing "Valid open frames"
    (are [frame] (s/valid? ::bs/open-frame frame)
      [0 0]
      [0 1]
      [4 5]
      [9 0]))

  (testing "Invalid open frames"
    (are [frame] (not (s/valid? ::bs/open-frame frame))
      [9]
      [10 0]
      [9 1]
      [11 -5]
      [0 10]))
  )

