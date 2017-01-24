def length(lis:List[Int]):Int = {
lis.foldRight(0){(z,i)=>i+1}
}
