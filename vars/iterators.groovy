def call(List items) {
  for (def item in items) {
    sh "echo ${item}"
  }
}
