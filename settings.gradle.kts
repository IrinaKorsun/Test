include ("db")
include ("book")
project(":book").projectDir = File("book")
include ("book-service")
include ("book-api")
project(":book-service").projectDir = File("book/book-service")
project(":book-api").projectDir = File("book/book-api")