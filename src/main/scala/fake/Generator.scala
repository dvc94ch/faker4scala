package fake

import scala.util.Random

package object generator {
  
	import scala.collection.immutable.Range
	
	def gen[T](arr: Array[T]): T = arr(gen(arr.length))
	
	def gen(i: Int): Int = Random.nextInt(i)
	
	def gen(range: Range): Int = gen(range.end - range.start) + range.start

	def bothify(str: String) = convert(str, true)
	
	def numerify(str: String) = convert(str, false)
	
	private def convert(str: String, both: Boolean) = {
	  
	  def work(i: Int = 0, s: String = ""): String =
			if(i == str.length) s
			else
				work(i + 1, str.charAt(i) match {
					case '#' => s + gen(10).toString
					case '?' if(both) => s + (gen(26) + 65).toChar
					case x => s + x
					})
				
		work()
	}
	
	def fill(f: => Any, size: Int) = (for(i <- 1 to size)yield f).toArray
}