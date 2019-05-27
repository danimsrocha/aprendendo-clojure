(ns cipher.core-test
  (:require [clojure.test :refer :all]
            [cipher.core :as core]
            [midje.sweet :refer :all]))

(fact "this will fail"
      1 => 1)

(facts "recebe dois numeros e retorna o caculo deles"
       (tabular
        (core/g int1 int2 ) => result
        int1 int2 result
        10   5    55
        5    1    26
        9    2    47
        1    3    8))

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (tabular
        (core/to-int ?char) => result
        ?char result
        \a    0
        \b    1
        \c    2
        \d    3))

(facts "recebe um número e retorna o código ascii: 1 = b, 2 = c"
       (tabular
        (core/to-char number) => ?result
        number ?result
        0     \a
        1     \b
        2     \c
        3     \d))

(facts ""
       (tabular
        (core/shift (+ ?char number)) => ?result
        ?char number ?result
        \a    3      \d))