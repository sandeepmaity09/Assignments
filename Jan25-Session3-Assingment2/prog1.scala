object URL {
  def apply(protocal:String, domain:String, path:String, params:Map[String,String]) : String =
    {
      val keys = params.keys
      var result = ""
      for(i<-keys)
        result = result + i + "=" + params(i) + "&"
      protocal + "://" + domain + path + "?" + result 
    }

  def unapply(url: String) : Option[(String,String,String,Map[String,String])] = 
    {
      val protocolWithRest = url.split("://")
      val protocol = protocolWithRest(0).toString
      val withoutProtocol = protocolWithRest(1)

      val domainWithRest = withoutProtocol.split("/",2)
      val domain = domainWithRest(0).toString
      val withoutDomain = domainWithRest(1)

      val pathWithRest = withoutDomain.split("\\?")
      val path = pathWithRest(0).toString
      val withoutPath = pathWithRest(1)

      val onlyStates = withoutPath.split("&").toList
      val statesArr = onlyStates.map(i=>i.split("="))
      val statesList = statesArr.map(i=>(i(0),i(1)))

      val statesMap = statesList.toMap
      
      Some(protocol,domain,path,statesMap)

    }
}
