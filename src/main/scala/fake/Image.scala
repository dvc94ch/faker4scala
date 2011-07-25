package fake

import fake.generator._

object Image {
  
	import java.io.File
	
	def image(rootPath: String): File = {
	  
	  val file = new File(rootPath)
	  
	  if(file.exists == false)
		  throw new Exception("""file %s not found""" format (file.getAbsolutePath.toString))
	    
	  if(file.isFile)
	    return file
	  else {
	    val files = file.listFiles()
	    return gen(files)
	  }
	}
}