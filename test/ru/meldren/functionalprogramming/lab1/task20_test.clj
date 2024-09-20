(ns ru.meldren.functionalprogramming.lab1.task20-test
  (:require [clojure.test :refer :all]
            [ru.meldren.functionalprogramming.lab1.task20 :refer :all]))

(deftest test-factorial-rec
  (is (= (factorial-rec 1) 1))
  (is (= (factorial-rec 5) 120))
  (is (= (factorial-rec 10) 3628800)))

(deftest test-factorial-tail-rec
  (is (= (factorial-tail-rec 1) 1))
  (is (= (factorial-tail-rec 5) 120))
  (is (= (factorial-tail-rec 10) 3628800)))

(deftest test-factorial-reduce
  (is (= (factorial-reduce 1) 1))
  (is (= (factorial-reduce 5) 120))
  (is (= (factorial-reduce 10) 3628800)))

(deftest test-factorial-lazy
  (is (= (factorial-lazy 1) 1))
  (is (= (factorial-lazy 5) 120))
  (is (= (factorial-lazy 10) 3628800)))

(deftest test-digit-sum
  (is (= (digit-sum (factorial-rec 100N)) 648))
  (is (= (digit-sum (factorial-tail-rec 100N)) 648))
  (is (= (digit-sum (factorial-reduce 100N)) 648))
  (is (= (digit-sum (factorial-lazy 100N)) 648)))
