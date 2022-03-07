(ns clojure-start.core
  (:require [clojure-start.factorial :as factorial]
            [clojure-start.fizz-buzz :as fizz-buzz])
  (:gen-class))

(defn -main [& args]
;  (println (factorial/bigint-loop-version 10))
  (println(fizz-buzz/fizz-buzz-cond)))
