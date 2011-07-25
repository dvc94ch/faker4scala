import fake._
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar

class SomeTestSpec extends Spec with ShouldMatchers with MockitoSugar  {

	import fake.generator._
	
	println(fill(Book.factory, 5).mkString("\n"))
}