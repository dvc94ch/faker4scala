package fake

import fake.generator._

object Date {
	
	def day(month: Int) = if(month==1) gen(1 to 28) else gen(1 to 30)
	
	def month = gen(11)
	
	def year = gen(1950 to 2012)
	
	def sec = gen(60)
	
	def min = gen(60)
	
	def hour = gen(24)
	
	def date = {
		import java.util.{Date => JDate}
		val d = new JDate; val m = month
		d.setYear(year - 1900)
		d.setMonth(month)
		d.setDate(day(m))
		d.setHours(hour)
		d.setMinutes(min)
		d.setSeconds(sec)
		d
	}
}