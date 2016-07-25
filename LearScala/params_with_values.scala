val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "Scala!\n"

for (i <- 0 to 2)
print(greetStrings(i))

greetStrings.update(0, "Hi")
greetStrings.update(1, ", ")
greetStrings.update(2, "Scala again!\n")

for (i <- 0.to(2)) print(greetStrings.apply(i))

