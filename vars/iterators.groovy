def call(List items) {
  node ('agent') {
  items.each {  
    sh "echo ${it}"
  }
  }
}
