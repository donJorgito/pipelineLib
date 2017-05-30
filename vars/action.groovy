def call(Map conf, String script) {
  if (conf.enabled) {
    def shStdout 
    node ('agent') {
      shStdout = sh returnStdout: true, script: "${script}"
    }
    return shStdout
  } else {
    echo "Wont run action due configured settings"
    return "Wont run action due configured settings"
  }
}
