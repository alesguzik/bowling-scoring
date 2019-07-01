(ns bowling-scoring.frame-specs-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [bowling-scoring.specs :as specs-common]
            [bowling-scoring.frame-specs :as specs]))

(deftest valid-throw-test
  (testing "Valid throws"
    (are [n] (specs/valid-throw? n)
      0
      6
      10))

  (testing "Invalid throws"
    (are [n] (not (specs/valid-throw? n))
      -1
      11
      "2"
      nil)))

(deftest frame-spec-test
  (testing "Valid open frames"
    (are [frame] (s/valid? ::specs/open-frame frame)
      [0 0]
      [0 1]
      [4 5]
      [9 0]))

  (testing "Invalid open frames"
    (are [frame] (not (s/valid? ::specs/open-frame frame))
      [9]
      [10 0]
      [9 1]
      [11 -5]
      [0 10]))

  (testing "Regular frames"
    (are [frame frame-type] (= (first (specs-common/validate ::specs/regular-frame frame)) frame-type)
      [9] nil
      [-5] nil
      ["2"] nil
      [1 2 3 3] nil
      [10] :strike
      [8 2] :spare
      [0 10] :spare
      [10 0] nil
      ))

  (testing "Last frames"
    (are [frame frame-type] (= (first (specs-common/validate ::specs/last-frame frame)) frame-type)
      [9] nil
      [-5] nil
      [1 2 3 3] nil
      [10] nil
      ["2"] nil
      [2 8] nil
      [2 7] :open-frame
      [10 0 0] :last-strike
      [8 2 3] :last-spare
      [0 10 9] :last-spare
      ))
  )
