(ns clojure-start.rock-paper-scissors)

; returns nil on invalid input
(defn get-guess[]
  (println "play your hand: (r)ock, (p)aper, (s)cissors: ")
  (let [guess (read-line)]
    (if (get {"r" true "p" true "s" true} guess) guess)))

; returns 1 if 1st player wins, 2 if 2nd wins, 0 if a tie
(defn winner [guess1 guess2]
  (let [guesses [guess1 guess2]]
    (cond
    (= guess1 guess2) 0
    (= guesses ["p" "r"]) 1
    (= guesses ["r" "p"]) 2
    (= guesses ["r" "s"]) 1
    (= guesses ["s" "r"]) 2
    (= guesses ["s" "p"]) 1
    (= guesses ["p" "s"]) 2)))

(defn play-hand []
  (let [comp-guess (rand-nth ["r" "p" "s"])
        player-guess (get-guess)
        winner (winner comp-guess player-guess)]
    (println "the computer guessed:" comp-guess)
    (println "you guessed:" player-guess)
    (cond
      (= player-guess nil) (println "your entry was invalid")
      (= winner 0) (println "game tied")
      (= winner 1) (println "computer wins")
      (= winner 2) (println "player wins"))))