package fake

import fake.generator._

class Book {

	val title = Name.first_name
	val author = Name.factory
	val cover = Image.image("""C:\Users\Public\Pictures\Sample Pictures""")
	val publisher = Company.name
	val author_email = Internet.email(Some(author))
	val edition = "%s edition" format gen(Array("first", "second", "third"))
	val year = Date.date
	val tags = Lorem.words(gen(2 to 4)).mkString(", ")
	val isbn = numerify("#-####-#######-#")

	override def toString = {
"""Title: %s
Author: %s
Cover: %s
Publisher: %s
Author-email: %s
Edition: %s
Year: %s
Tags: %s
Isbn: %s""" format (title, author, cover, publisher, author_email, edition, year, tags, isbn)
	}
}

object Book {
	def factory = new Book
}