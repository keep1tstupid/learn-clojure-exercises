(ns clojure-start.tic-tac-toe)

(defn triple-winner? [triple]
  (if (every? #{:x} triple) :x
    (if (every? #{:o} triple) :o)))

(declare triples) ; = (def triples nil)

; returns :x if x win, :o if o win, otherwise nil
(defn winner? [board]
  (first (filter #{:x :o} (map triple-winner? (triples board)))))

; returns sequence of triples (the rows, columns, and diagonals of the board )
(defn triples [board]
  (concat ; all triples
   (partition-all 3 board) ;the rows
   (list
    (take-nth 3 board) ; first column
    (take-nth 3 (drop 1 board)) ; second column
    (take-nth 3 (drop 2 board)) ; third column
    (take-nth 4 board) ; top-left to bottom-right diagonal
    (take-nth 2 (drop-last 2 (drop 2 board)))))) ; top-right to bottom-left diagonal

(defn full-board? [board]
  (every? #{:x :o} board))

; replace keywords with str representation
(defn print-board [board]
  (let [board (map #(if (keyword? %) (subs (str %) 1) %) board)]
    (println (nth board 0) (nth board 1) (nth board 2))
    (println (nth board 3) (nth board 4) (nth board 5))
    (println (nth board 6) (nth board 7) (nth board 8))))

(defn player-name [player]
  (subs (str player) 1))

(def starting-board [1 2 3 4 5 6 7 8 9])

(def player-sequence (cycle [:x :o]))

(defn get-move [board]
  (let [input (try
                (. Integer parseInt(read-line))
                (catch Exception e nil))]
    (if (some #{input} board)
      input
      nil)))

(defn take-turn [player board]
  (println "select your move, player" (player-name player) " (press 1-9 and hit enter):")
  (loop [move (get-move board)]
    (if move
      (assoc board (dec move) player) ; dec to make an index
      (do
        (println "move was invalid, select new move player" (str (player-name player) ":"))
        (recur (get-move board))))))

(defn play-game []
  (loop [board starting-board player-sequence player-sequence]
    (let [winner (winner? board)]
      (println "current board:")
      (print-board board)
      (cond
        winner (println "player" (player-name winner) "wins")
        (full-board? board) (println "game is a draw")
        :else
        (recur
          (take-turn (first player-sequence) board)
          (rest player-sequence))))))