function transToBinary(n) {
    if(n == 0) {
      return '';
    }
    else {
      if( n % 2 == 0) {
        return  transToBinary( Math.floor(n/2)) + '0' 
      }
      else {
        return  transToBinary( Math.floor(n/2)) + '1'
      }
    }
  }
  
  console.log(transToBinary(6))