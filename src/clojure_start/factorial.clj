(ns clojure-start.factorial)

; will throw overfrlow exception for n > 20 becauase * accepts and returns Long values
(defn basic [n]
  (if (= n 0) 1
    (* n (basic (dec n)))))

; uses arbitrary precision math function so works for n > 20
(defn bigint-version [n]
  (if (= n 0) 1
    (*' n (bigint-version (dec n)))))

(defn bigint-loop-version [n]
  (if (= n 0) 1
    (loop [val n i n]
      (if (<= i 1) val
        (recur(*' val (dec i)) (dec i))))))