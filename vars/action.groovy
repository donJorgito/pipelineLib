def call(String script) {
  if (config.enabled) {
    def shStdout = sh returnStdout: true, script: "${script}"
    return shStdout
  } else {
    echo "Wont run action due configured settings"
    return "Wont run action due configured settings"
  }
}
