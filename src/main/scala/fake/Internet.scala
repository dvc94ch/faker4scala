package fake

import fake.generator._

object Internet {

	def domain_name = "%s.%s" format (domain_word, domain_suffix)
	
	def domain_suffix = gen(Array("co.uk", "com", "us", "ca", "biz", "info", "name"))
	
	def domain_word: String = Company.name(true).split(' ')(0).toLowerCase
		
	def email(name: Option[Name] = None) = "%s@%s" format (user_name(name), domain_name)
	
	def free_email(name: Option[Name] = None) = user_name(name) + gen(Array("@gmail.com", "@yahoo.com", "@hotmail.com"))
	
	def user_name(name: Option[Name] = None): String = {
		
		def build(first: String, last: String) = (first + gen(Array(".", "_")) + last).toLowerCase
		
		name match {
			case None => build(Name.first_name, Name.last_name)
			case Some(name) => build(name.first_name, name.last_name)
		}
	}
}