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

(facts "recee uma letra minuscula e a quantidade de posicoes que deve inserir, e retorna a letra do alfabeto: a,3 = d, x,4 = b"
       (tabular
        (core/shift ?char number) => ?result
        ?char number ?result
        \a    3      \d
        \a    4      \e
        \x    4      \b
        \b    20     \v
        \z    3      \c
        \a    -3     \x))

(facts "Recebe uma palavra e uma chave que indica a quantidade de posicoes e retorna a palavra encriptada"
       (tabular
        (core/caesar-encrypt ?word k) => ?result
        ?word              k    ?result
        "apple"            20     "ujjfy"
        "boston"           5      "gtxyts"
        "clojurebridge"    10     "mvytebolbsnqo"))

(facts "Recebe uma palavra encriptada e uma chave que indica a quantidade de posicoes e retorna a palavra descriptada"
       (tabular
        (core/caesar-decrypt ?word k) => ?result
        ?word              k    ?result
        "ujjfy"            20   "apple"
        "gtxyts"           5    "boston"
        "mvytebolbsnqo"    10   "clojurebridge"))

(facts "Recebe uma palavra encriptada e uma chave que indica a quantidade de posicoes e retorna a palavra descriptada"
       (tabular
        (core/get-letters ?word) => ?result
        ?word              ?result
        "Hello, friend!"   "hellofriend"
        "DANIELA"          "daniela"
        "D@n!elA"          "dnela"))

(facts "Recebe uma frase e retorna ela encriptada"
        (core/encrypt "Hello, friend!" 5) => "mjqqtkwnjsi")

(facts "Conta quantos caracateres da letra passada como parametro tem na paavra"
       (tabular
        (core/count-letters ?letter ?word) => result
        ?letter ?word     result
        \a      "aadvark" 3
        \x      "aadvark" 0
        \d      "daniela" 1))

