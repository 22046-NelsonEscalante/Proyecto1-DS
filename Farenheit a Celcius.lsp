Printing the string "Conversion de Farenheit a Celcius"
(print "Conversion de Farenheit a Celcius")

Printing the string "Ingresa los grados Farenheit: "
(print "Ingresa los grados Farenheit: ")

Declaring the variable F.
(defvar F)

Reading the value of F and storing it in the variable F.
(setq F (read))

Defining a function called Switch that takes a variable F and returns the conversion of Farenheit to Celcius.
(defun Switch (F)
    (format t "La conversion es igual a: ~D" (* (- F 32) 0.56))
)

Calling the function Switch and passing the value of F as an argument.
(Switch F)




