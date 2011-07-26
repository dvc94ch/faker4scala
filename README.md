This is a Scala port of the [ruby faker lib](http://faker.rubyforge.org/) for generating sample data like names, addresses, companies, email addresses, telephone numbers and just nonsense text for testing purposes.

### Getting Started with Faker 1.2:

```scala
import fake._

object GenerateSomeData extends Application {

  //print some stuff
  for(i <- 0 to 10) {
    println("%s %s" format (Name.name, PhoneNumber.phone_number))
    println("%s %s %s" format (Company.name, Company.catch_phrase, Company.bs))
    println("%s %s" format (Internet.free_email(), Internet.email())
    println("%s %s %s %s %s %s %s %s" format (Address.street_address(), Address.city,
      Address.uk_country, Address.uk_county, Address.uk_postcode, Address.us_state,
      Address.us_state_abbr, Address.zip_code))
    println(Lorem.text(5))
  }
}
```

### A more extensive example:

*Books.scala*

```scala
import fake._

class Book extends Generator {

  // define some fields
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
  // define factory method
  def factory = new Book
}
```

*main.scala*

```scala
object GenerateSomeData {

  def main(args: Array[String]) {
    import fake._
    // create an Array with 5 books and print it to screen
    println(Generator.fill(Book.factory, 5).mkString("\n"))
  }
}
```

*Scala Doc:*

http://dvc94ch.github.com/faker4scala