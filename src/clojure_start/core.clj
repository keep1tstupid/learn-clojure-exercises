(ns clojure-start.core
  (:require [clojure-start.factorial :as factorial]
            [clojure-start.fizz-buzz :as fizz-buzz]
            [clojure-start.rock-paper-scissors :as rps]
            [clojure-start.tic-tac-toe :as tic-tac-toe])
  (:gen-class))

(defn -main [& args]
;  (println (factorial/bigint-loop-version 10))
;  (println(fizz-buzz/fizz-buzz-cond))
;  (loop []
;    (rps/play-hand)
;    (recur))
  (tic-tac-toe/play-game))
