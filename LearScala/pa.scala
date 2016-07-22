args.foreach(arg => println(arg))
args.foreach((arg: String) => println(arg))
args.foreach(println)

for (arg <- args) println(arg)

