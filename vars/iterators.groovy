def call(List items) {
  node ('agent') {
  for (def item in items) {
    sh "echo ${item}"
  }
  }
}
