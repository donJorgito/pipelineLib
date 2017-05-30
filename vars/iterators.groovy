def call(List items) {
  node ('agent') {
  items.each { it ->
    sh "echo ${it}"
  }
  }
}
